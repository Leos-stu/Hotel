package com.engeto.hotel;

public class Room {
    private int numberOfRoom;
    private int roomNumberOfBeds;
    private boolean hasRoomBalcony;
    private boolean hasRoomSeaSight;
    private int roomPricePerNight;

    public Room(int numberOfRoom, int roomNumberOfBeds, boolean hasRoomBalcony, boolean hasRoomSeaSight, int roomPricePerNight) {
        this.numberOfRoom = numberOfRoom;
        this.roomNumberOfBeds = roomNumberOfBeds;
        this.hasRoomBalcony = hasRoomBalcony;
        this.hasRoomSeaSight = hasRoomSeaSight;
        this.roomPricePerNight = roomPricePerNight;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public int getRoomNumberOfBeds() {
        return roomNumberOfBeds;
    }

    public boolean isHasRoomBalcony() {
        return hasRoomBalcony;
    }

    public boolean hasRoomSeaSight() {
        return hasRoomSeaSight;
    }

    public int getRoomPricePerNight() {
        return roomPricePerNight;
    }

    @Override
    public String toString() {
        return "Room number: " + numberOfRoom +
                ", Number of beds: " + roomNumberOfBeds +
                ", Balcony: " + hasRoomBalcony +
                ", SeaSight: " + hasRoomSeaSight +
                ", Price Per Night: " + roomPricePerNight + "Kc/noc" +
                '}';
    }
}
