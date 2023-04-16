package FieldInitialization;

import Flat.Flat;

import java.util.ArrayList;

public class AddInArrayList {
    public static void addInArrayList(ArrayList<String> arrayList, String name){
        System.out.println("Команда выполняется");
        arrayList.add(name);
        arrayList.add(InitializationCoordinates.initializationCoordinateX());
        arrayList.add(InitializationCoordinates.initializationCoordinateY());
        arrayList.add(InitializationArea.initializationArea());
        arrayList.add(InitializationNumberOfRooms.numberOfRooms());
        arrayList.add(InitializationNew.whatApartment());
        arrayList.add(InitializationFurnish.initializationFurnish());
        arrayList.add(InitializationTransports.initializationTransports());
        arrayList.add(InitializationHouse.initializationHouseName());
        arrayList.add(InitializationHouse.initializationYear());
        arrayList.add(InitializationHouse.initializationNumberOfFlatsOnFloor());
    }
}
