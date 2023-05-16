package com.engeto.bookings;

import com.engeto.guests.Guest;
import com.engeto.rooms.Room;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class Booking {
    //int roomId;
    private Room room;
    private int numberOfGuests;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    List<Guest> roomGuestList;
    private String typeOfVacation;

    public Booking(Room room, int numberOfGuests, LocalDate dateFrom, LocalDate dateTo) {
        this.room = room;
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
                "Room number: " + room.getNumberOfRoom() +
                ", Number of guests: " + numberOfGuests +
                ", Date from: " + dateFromFormatted +
                ", Date to: " + dateToFormatted +
                ", Guests: " + guestNames +
                ", Type of vacation: " + typeOfVacation;
    }
}
