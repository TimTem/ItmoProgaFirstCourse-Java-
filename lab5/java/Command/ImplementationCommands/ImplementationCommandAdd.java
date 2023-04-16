package Command.ImplementationCommands;
import Flat.*;
import Command.ImplementationCommands.FieldInitialization.*;

import java.util.Stack;

public class ImplementationCommandAdd {
    public static void implementationAdd(Stack<Flat> flats, String name){
        System.out.println("Сommand execution".toUpperCase());
        Flat flat = new Flat();
        flat.setId();
        flat.setName(name);
        flat.setCoordinates(new Coordinates(InitializationCoordinates.initializationCoordinateX(), InitializationCoordinates.initializationCoordinateY()));
        flat.setArea(InitializationArea.initializationArea());
        flat.setNumberOfRooms(InitializationNumberOfRooms.numberOfRooms());
        flat.setNew(InitializationNew.whatApartment());
        flat.setFurnish(InitializationFurnish.initializationFurnish());
        flat.setTransport(InitializationTransports.initializationTransports());
        flat.setHouse(new House(InitializationHouse.initializationHouseName(),InitializationHouse.initializationYear(),InitializationHouse.initializationNumberOfFlatsOnFloor()));
        flats.add(flat);
        System.out.println("New flat was added.");
    }
}
