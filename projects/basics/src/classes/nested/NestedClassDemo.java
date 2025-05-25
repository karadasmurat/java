package classes.nested;

public class NestedClassDemo {

    private int instanceVariable = 10; // Outer class instance variable

    public static void main(String[] args) {

        // Create an instance of the outer class
        Home myHome = new Home("123 Main St");

        // Create & Add rooms to the home
        myHome.addRoomToHome("Bedroom");
        myHome.addRoomToHome("Living Room");

        // Visit the rooms
        myHome.visitRooms();

        // Creating inner class instance within the outer class
        Home.Room newRoom = myHome.createRoom("Bathroom");
        newRoom.displayRoomInfo(); // Display room info

        // Create an instance of the inner class directly
        Home.Room myRoom = myHome.new Room("Kitchen");
        myRoom.displayRoomInfo(); // Display room info
    }
}
