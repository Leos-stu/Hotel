package com.engeto.hotel;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Booking {
    //int roomId;
    private Room room;
    private int numberOfGuests;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    List<Guest> roomGuestList;
    private String typeOfVacation;
    private int idOfBooking;    //used in task from 3rd lesson
    private int lenghtOfBookingInDays;    //used in task from 3rd lesson

    public Booking(Room room, int numberOfGuests, LocalDate dateFrom, LocalDate dateTo) {
        this.room = room;
        this.numberOfGuests = numberOfGuests;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    //constructor used in task from 3rd lesson


    public Booking(Room room, int numberOfGuests, LocalDate dateFrom, LocalDate dateTo, int idOfBooking) {
        this.room = room;
        this.numberOfGuests = numberOfGuests;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.idOfBooking = idOfBooking;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setRoomGuestList(List<Guest> roomGuestList) {
        this.roomGuestList = roomGuestList;
    }

    public void setTypeOfVacation(String typeOfVacation) {
        this.typeOfVacation = typeOfVacation;
    }

    public String getTypeOfVacation() {
        return typeOfVacation;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public int getLenghtOfBookingInDays(){
        Period dayDifference = Period.between(this.dateFrom,this.dateTo);
        lenghtOfBookingInDays = dayDifference.getDays()+1;
        return lenghtOfBookingInDays;
    }

    @Override
    public String toString() {
        String guestNames = "";
        String comma = "";

        String dateFromFormatted = "";
        String dateToFormatted = "";

        String noc = "";

        for(Guest guest : this.roomGuestList){
            guestNames = guestNames + comma + guest.getFirstName() + " " + guest.getLastName() ;
            comma = ", ";
            dateFromFormatted = this.dateFrom.format(DateTimeFormatter.ofPattern("d.M.yyyy"));
            dateToFormatted = this.dateTo.format(DateTimeFormatter.ofPattern("d.M.yyyy"));
        }

//        return "Booking: " +
//                "Room number: " + room.getNumberOfRoom() +
//                ", Number of guests: " + numberOfGuests +
//                ", Date from: " + dateFromFormatted +
//                ", Date to: " + dateToFormatted +
//                ", Guests: " + guestNames +
//                ", Type of booking: " + typeOfVacation +
//                ", Lenght of booking in days: " + this.getLenghtOfBookingInDays();
        switch (this.getLenghtOfBookingInDays()){
            case 1:
                noc = "noc";
                break;
            case 2:
                noc = "noci";
                break;
            case 3:
                noc = "noci";
                break;
            case 4:
                noc = "noci";
                break;
            default:
                noc = "nocí";
        }



        return guestNames +
                " (pokoj " + room.getNumberOfRoom() + "):" +
                "  " + this.getLenghtOfBookingInDays() + " " + noc + " od " +
                dateFromFormatted + " za " + this.room.getRoomPricePerNight() * this.getLenghtOfBookingInDays() + " Kč";
    }
}
