insert into client values ('ka@gmail.com','5555');

insert into bus values (1,'TAT','KA-7993');
insert into bus values (2,'Vignesh TAT','KA-4227');

insert into bus_bus_features values (1,'SLEEPER');
insert into bus_bus_features values (2,'SITTING');
insert into bus_bus_features values (2,'NON_AC');

insert into seat values (1,'1A',500.00,1,false,1,1);
insert into seat values (2,'1U',500.00,1,true,1,1);
insert into seat values (3,'1A',600.00,1,false,1,2);
insert into seat values (4,'1U',600.00,1,true,1,2);

insert into trip values (1,'Svk','2020-10-23 07:00:00-00',700.00,'Maa','2020-10-22 19:00:00-00',1);
insert into trip values (2,'Svk','2020-10-23 05:00:00-00',900.00,'Maa','2020-10-22 21:00:00-00',2);


insert into trip_meta_data values (4,false,'Svk bus stand','4311','2020-10-23 05:00:00-07',2);