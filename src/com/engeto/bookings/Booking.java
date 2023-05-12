package com.engeto.bookings;

import com.engeto.guests.Guest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Booking {
    int roomId;
    int numberOfGuests;
    LocalDate dateFrom;
    LocalDate dateTo;
    List<Guest> roomGuestList;
    String typeOfVacation;

    public Booking(int roomId, int numberOfGuests, LocalDate dateFrom, LocalDate dateTo) {
        this.roomId = roomId;
        this.numberOfGuests = numberOfGuests;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
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

    @Override
    public String toString() {
        String guestNames = "";
        String comma = "";

        String dateFromFormatted = "";
        String dateToFormatted = "";

        for(Guest guest : this.roomGuestList){
            guestNames = guestNames + comma + guest.getFirstName() + " " + guest.getLastName() ;
            comma = ", ";
            dateFromFormatted = this.dateFrom.format(DateTimeFormatter.ofPattern("d.M.yyyy"));
            dateToFormatted = this.dateTo.format(DateTimeFormatter.ofPattern("d.M.yyyy"));
        }

        return "Booking: " +
                "Room number: " + roomId +
                ", Number of guests: " + numberOfGuests +
                ", Date from: " + dateFromFormatted +
                ", Date to: " + dateToFormatted +
                ", Guests: " + guestNames +
                ", Type of vacation: " + typeOfVacation;
    }
}
