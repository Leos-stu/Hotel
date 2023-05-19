package com.engeto.hotel;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<Booking> listOfBookings = new ArrayList<>();


    //vlozeni rezervace do systemu
    public void add(Booking newBooking){
        this.listOfBookings.add(newBooking);
    }

    //ziskani seznamu rezervaci
    public List<Booking> getBookings(){
        return this.listOfBookings;
    }

    //vyprazdneni seznamu rezervaci
    public void removeAll(){
        this.listOfBookings.removeAll(this.listOfBookings);
    }

    public int getNumberOfBookings(){
        return this.listOfBookings.size();
    }

    public int getNumberOfWorkingBookings(){
        int counter=0;
        for (Booking booking: this.listOfBookings){
            if (booking.getTypeOfVacation().equals("BUSINESS")){
                counter++;
            }
        }
        return counter;
    }

    public double getAverageNumberOfGuestsPerBooking(){
        int numberOfAllGuests = 0;
        for (Booking booking: this.listOfBookings){
            numberOfAllGuests = numberOfAllGuests + booking.getNumberOfGuests();
            }
        return numberOfAllGuests / this.listOfBookings.size();
    }

    public List<Booking> getFirstEightPrivateBookings(){
        List<Booking> listOfFirstEightPrivateBookings = new ArrayList<>();
        int bookingCounter = 0;
        while (listOfFirstEightPrivateBookings.size()<8){
            if (this.listOfBookings.get(bookingCounter).getTypeOfVacation().equals("PRIVATE")){
                listOfFirstEightPrivateBookings.add(this.listOfBookings.get(bookingCounter));
            }
            bookingCounter++;
        }
        return listOfFirstEightPrivateBookings;
    }

    public int getNumberOfBookingsByLenghtOfDays(int days){
        int numberOfBookingsByLengthOfDays = 0;
        for (Booking booking: this.listOfBookings){
            if (booking.getLenghtOfBookingInDays() == days) {
                numberOfBookingsByLengthOfDays = numberOfBookingsByLengthOfDays + 1;
            }
        }
        return numberOfBookingsByLengthOfDays;
    }
}
