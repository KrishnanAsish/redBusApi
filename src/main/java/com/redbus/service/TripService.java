package com.redbus.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.redbus.entities.Booking;
import com.redbus.entities.Bus;
import com.redbus.entities.Seat;
import com.redbus.entities.Trip;
import com.redbus.entities.TripManager;
import com.redbus.model.BusDao;
import com.redbus.model.TripDao;
import com.redbus.model.TripManagerDao;
import com.redbus.utils.RedBusConstants.SeatStatus;
import com.redbus.vo.BusTripVO;
import com.redbus.vo.SeatLockVO;
import com.redbus.vo.SeatSelectionVO;

@Service
public class TripService {

	@Autowired
	private TripDao tripDao;
	
	@Autowired
	private BusDao busDao;
	
	@Autowired
	private TripManagerDao tripManagerDao;

	public List<BusTripVO> fetchTripsBasedOnTimeAndPlace(String source, String destination, Date journeyDate) {
		List<Trip> tripDetails = tripDao.findTripBySourceAndDestinationAndStartTimeAfter(source, destination, journeyDate);
		List<BusTripVO> busTripDetailList = new ArrayList<>();
		
		for(Trip trip:tripDetails) {
			BusTripVO busTripVo = new BusTripVO();
			busTripVo.setBusName(trip.getBus().getBusName());
			busTripVo.getBusFacilities().addAll(trip.getBus().getBusFeatures());
			busTripVo.setJourneyStartTime(trip.getStartTime().toLocaleString());
			busTripVo.setJourneyEndTime(trip.getEndTime().toLocaleString());
			busTripVo.setPrice(trip.getPrice());
			busTripVo.setSeatsAvailable(trip.getBus().getSeats().size()-trip.getBookings().size());
			
			busTripDetailList.add(busTripVo);
		}
		return busTripDetailList;
	}

	public List<SeatSelectionVO> showSeatLayoutForBus(String busName, String source, String destination, Date startTime) {
		List<SeatSelectionVO> seatSelectionList = new ArrayList<>();
		List<TripManager> tripManagerList = new ArrayList<>();
		
		Trip tripDetail = tripDao.findTripBySourceAndDestinationAndStartTime(source, destination, startTime);
		tripManagerList = tripManagerDao.findByTripId(tripDetail.getId());
		
		Set<String> bookedSeats = tripManagerList.stream().map(tripManager->tripManager.getSeat().getName()).collect(Collectors.toSet());
		if(tripDetail.getBus().getBusName().equals(busName)) {
			for(Seat seat:tripDetail.getBus().getSeats()) {
				SeatSelectionVO seatSelectionVO = new SeatSelectionVO();
				seatSelectionVO.setName(seat.getName());
				seatSelectionVO.setPrice(seat.getBasePrice());
				seatSelectionVO.setSeatPosition(seat.getSeatPosition());
				if(bookedSeats.contains(seat.getName()))
						seatSelectionVO.setSeatStatus(SeatStatus.BOOKED);
				else
					seatSelectionVO.setSeatStatus(SeatStatus.AVAILABLE);
				seatSelectionList.add(seatSelectionVO);
			}
		}
		return seatSelectionList;
	}

	public String lockSeats(SeatLockVO seatDetails) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.HH.mm");
		Date startDate = dateFormat.parse(seatDetails.getStartTime());
		Trip tripDetail = tripDao.findTripBySourceAndDestinationAndStartTime(seatDetails.getSource(), seatDetails.getDestination(),startDate );
		Optional<Bus> bus = busDao.findById(tripDetail.getBus().getId());
		Optional<Trip> trip = tripDao.findById(tripDetail.getBus().getId());
		Set<String> userSelectedSeats = seatDetails.getSelectedSeats().stream().map(seat->seat.getSeatName()).collect(Collectors.toSet());
		Set<Seat> selectedSeats = tripDetail.getBus().getSeats().stream().filter(seat->userSelectedSeats.contains(seat.getName())).collect(Collectors.toSet());
		List<TripManager> tripManagerList = new ArrayList<>();
		for(Seat seat:selectedSeats)
			tripManagerList.add(new TripManager(bus.get(),trip.get(),seat,SeatStatus.LOCKED));
		tripManagerDao.saveAll(tripManagerList);
		return "OK";
	}
}
