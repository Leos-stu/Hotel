import com.engeto.bookings.Booking;
import com.engeto.guests.Guest;
import com.engeto.rooms.Room;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String formattedDate;
        enum TypeOfVacation{
            BUSINESS,
            PRIVATE
        }
        TypeOfVacation typeOfVacation;

        //vytvoreni hostu
        Guest guest1 = new Guest("Adela","Malikova", LocalDate.of(1993,03,13));
        Guest guest2 = new Guest("Jan","Dvoracek",LocalDate.of(1995,05,05));


        //souhrnny vypis hostu
        List<Guest> guestList = new ArrayList<>();
        guestList.add(guest1);
        guestList.add(guest2);

        System.out.println("=====List of guests=====");
        for (Guest guest : guestList) {
            formattedDate = guest.getDateOfBirth().format(DateTimeFormatter.ofPattern("d.M.yyyy"));
            System.out.println(guest.getFirstName() + " " + guest.getLastName() + " (" + formattedDate +")");
        }


        //vytvoreni pokoju
        Room room1 = new Room(1,1,true,true,1000);
        Room room2 = new Room(2,1,true,true,1000);
        Room room3 = new Room(3,3,false,true,2400);

        //souhrnny vypis pokoju
        List<Room> roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);

        System.out.println("=====List of rooms=====");
        for (Room room : roomList) {
            System.out.println(room.toString());
        }

        //vytvoreni rezervaci
        Booking booking1 = new Booking(room2,
                                        1,
                                        LocalDate.of(2021,07,19),
                                        LocalDate.of(2021,07,26));

        booking1.setRoomGuestList(Arrays.asList(guest1));
        booking1.setTypeOfVacation((TypeOfVacation.BUSINESS).toString());

        Booking booking2 = new Booking(room3,
                                        2,
                                        LocalDate.of(2021,9,01),
                                        LocalDate.of(2021,9,14));

        booking2.setRoomGuestList(Arrays.asList(guest1, guest2));
        booking2.setTypeOfVacation((TypeOfVacation.PRIVATE).toString());

        //souhrnny vypis rezervaci
        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(booking1);
        bookingList.add(booking2);


        System.out.println("=====List of bookings=====");
        for (Booking booking : bookingList) {
            System.out.println(booking.toString());
        }
    }
}