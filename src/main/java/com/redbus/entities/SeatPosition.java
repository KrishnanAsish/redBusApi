package com.redbus.entities;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Embeddable
public class SeatPosition {

	private int row;
	
	private int col;
	
	private boolean isUpper;

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public boolean isUpper() {
		return isUpper;
	}

	public void setUpper(boolean isUpper) {
		this.isUpper = isUpper;
	}
	
}
