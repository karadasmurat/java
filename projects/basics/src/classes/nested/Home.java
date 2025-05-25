package classes.nested;

import java.util.ArrayList;
import java.util.List;

public class Home {

    // Outer class instance variable
    private String address;
    private List<Room> rooms; // Rooms in the home

    // Constructor for the outer class
    public Home(String address) {
        this.address = address;
        this.rooms = new ArrayList<>(); // Initialize the list in the constructor
    }

    // Method in the outer class to create and use an Inner class.
    // public void addRoom(String roomType) {
    // Room newRoom = new Room(roomType);
    // this.rooms.add(newRoom); // Add the new room to the list
    // }

    // Creating inner class instance within the outer class
    public Room createRoom(String roomType) {
        // 1. Create an instance of the inner class, WITHIN the outer class
        // using the same syntax as you would for any other class:
        Room room = new Room(roomType);
        return room;
    }

    // Method to add a Room to the list
    public void addRoomToHome(String roomType) {
        this.rooms.add(createRoom(roomType));
    }

    // Outer class method
    public void visitRooms() {
        for (var room : rooms)
            room.displayRoomInfo();
    }

    // Inner class declaration
    protected class Room {

        private String roomType; // e.g., "Bedroom", "Living Room"

        // Constructor for the inner class
        public Room(String roomType) {
            this.roomType = roomType;
        }

        // Inner class method accessing outer class members
        public void displayRoomInfo() {
            System.out.println("Home Address: " + address); // Accessing the outer class instance's address
            System.out.println("Room Type: " + roomType);
        }
    }

    public static void main(String[] args) {
        Home myHome = new Home("123 Main St");
        // myHome.addRoom("Bedroom"); // creates a new room and displays the home info
        // myHome.addRoom("Living Room"); // creates a new room and displays the home
        // info
        myHome.visitRooms(); // visits the rooms
    }

}
