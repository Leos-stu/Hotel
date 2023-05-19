import com.engeto.hotel.BookingManager;
import com.engeto.hotel.Booking;
import com.engeto.hotel.Guest;
import com.engeto.hotel.Room;

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

        //UKOL ZE 3.LEKCE
        System.out.println();
        System.out.println();
        System.out.println("=====HERE STARTS HOMEWORK FROM 3RD LESSON=====");
        System.out.println();


        //vlozeni rezervaci pomoci tridy BookingManager
        BookingManager bookingManager = new BookingManager();
        bookingManager.add(booking1);
        bookingManager.add(booking2);

        //vypis seznamu rezervaci tridou BookingManager
        System.out.println("=====List of bookings by BookingManager=====");
        bookingManager.getBookings().forEach(System.out::println);
        System.out.println();

        //vyprazdneni objektu bookingManager
        bookingManager.removeAll();
            //kontrola, zda bylo vse odstraneno
            System.out.println("Size of bookingManager: " + bookingManager.getBookings().size());
            System.out.println();

        //vytvoreni rezervace Karel Dvořák, pokoj číslo 3 od 1. 6. 2023 do 7. 6. 2023, pracovní pobyt
            //vytvoreni a vlozeni rezervace
                //vytvoreni hosta
                Guest guest3 = new Guest("Karel","Dvořák", LocalDate.of(1910,12,24));
                //vytvoreni rezervace
                Booking bookingKarelDvorak = new Booking(room3,
                                                    1,
                                                    LocalDate.of(2023,6,1),
                                                    LocalDate.of(2023,6,7));
                bookingKarelDvorak.setRoomGuestList(Arrays.asList(guest3));
                bookingKarelDvorak.setTypeOfVacation((TypeOfVacation.BUSINESS).toString());
                //vlozeni rezervace
                bookingManager.add(bookingKarelDvorak);
        //end vytvoreni rezervace Karel Dvořák

        //vytvoreni rezervace Cestovní kancelář ABC Relax, pokoj číslo 2 na každý den v měsíci červnu 2023
            //vytvoreni a vlozeni rezervace
                //vytvoreni hosta
                Guest guest4 = new Guest("CestovniKancelar","ABC Relax", LocalDate.of(2020,10,1));
                //vytvoreni rezervace pomoci cyklu
                for (int i = 0; i < 30; i++) {
                    Booking booking = new Booking(room2,
                                                    1,
                                                    LocalDate.of(2023,6,i+1),
                                                    LocalDate.of(2023,6,i+1),
                                                    i+1);
                    booking.setRoomGuestList(Arrays.asList(guest4));
                    booking.setTypeOfVacation((TypeOfVacation.PRIVATE).toString());
                    //vlozeni rezervace
                    bookingManager.add(booking);
                }
        //end vytvoreni rezervace Cestovní kancelář ABC Relax

        //vytvoreni rezervace Alena Krásová, 7 rezervací pokoje číslo 1 vždy na prvních 5 dnů v měsící počínaje 1. 6. 2023, pracovní pobyty
            //vytvoreni a vlozeni rezervace
                //vytvoreni hosta
                Guest guest5 = new Guest("Alena","Krásová", LocalDate.of(1999,12,31));
                //vytvoreni rezervace pomoci cyklu
                for (int i = 0; i < 7; i++) {
                    Booking booking = new Booking(room1,
                                                    1,
                                                    LocalDate.of(2023,6+i,1),
                                                    LocalDate.of(2023,6+i,5),
                                                    i+1);
                    booking.setRoomGuestList(Arrays.asList(guest5));
                    booking.setTypeOfVacation((TypeOfVacation.BUSINESS).toString());
                    //vlozeni rezervace
                    bookingManager.add(booking);
                }
        //end vytvoreni rezervace Alena Krásová

        //vytvoreni rezervace Cestovní kancelář ABC Relax, pokoj číslo 2, čtyři třídenní rezervace, které budou začínat 1., 7., 14. a 21. srpna 2023
            //vytvoreni a vlozeni rezervace
            //vytvoreni hosta - pouziju jiz vyse vytvoreneho pro Cestovní kancelář
            //vytvoreni rezervace pomoci cyklu
                for (int i = 0; i < 4; i++) {
                    Booking booking = new Booking(room2,
                                                    1,
                                                    LocalDate.of(2023,8,Math.max(1,(i*7))),
                                                    LocalDate.of(2023,8,Math.max(3,(i*7+2))),
                                                    i+1);
                    booking.setRoomGuestList(Arrays.asList(guest4));
                    booking.setTypeOfVacation((TypeOfVacation.PRIVATE).toString());
                    //vlozeni rezervace
                    bookingManager.add(booking);
                }
        //end vytvoreni rezervace Cestovní kancelář ABC Relax, pokoj číslo 2, čtyři třídenní rezervace, které budou začínat 1., 7., 14. a 21. srpna 2023

        //vypis celkoveho poctu rezervaci
        System.out.println("=====Number of all bookings by BookingManager=====");
        System.out.println("======================= " + bookingManager.getNumberOfBookings() + " =======================");
        System.out.println();

        //vypis poctu rezervaci pro pracovni pobyty
        System.out.println("==Number of BUSINESS bookings by BookingManager==");
        System.out.println("======================= " + bookingManager.getNumberOfWorkingBookings() + " =======================");
        System.out.println();

        //vypis prumerneho poctu hostu na rezervaci
        System.out.println("=======Average number of guests per booking=======");
        System.out.println("======================= " + bookingManager.getAverageNumberOfGuestsPerBooking() + " =======================");
        System.out.println();

        //vypis prvnich osmi rekreacnich rezervaci
        System.out.println("=======First eight PRIVATE bookings=======");
        bookingManager.getFirstEightPrivateBookings().forEach(System.out::println);
        System.out.println();

        //vypis poctu jednodennich rezervaci
        System.out.println("=======One day bookings=======");
        System.out.println("============== " + bookingManager.getNumberOfBookingsByLenghtOfDays(1) + " ==============");
        System.out.println();

        //vypis poctu dvoudennich rezervaci
        System.out.println("=======Two days' bookings=======");
        System.out.println("============== " + bookingManager.getNumberOfBookingsByLenghtOfDays(2) + " ================");
        System.out.println();

        //vypis poctu vicedennich rezervaci
        System.out.println("=======Many days' bookings=======");
        System.out.println("============== " + (bookingManager.getNumberOfBookings() -
                (bookingManager.getNumberOfBookingsByLenghtOfDays(1) + bookingManager.getNumberOfBookingsByLenghtOfDays(2))) + " ==============");
        System.out.println();

        //vypis seznamu rezervaci tridou BookingManager
        System.out.println("=======List of bookings by BookingManager=======");
        bookingManager.getBookings().forEach(System.out::println);




    }
}