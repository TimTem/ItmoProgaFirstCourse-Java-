package FieldInitialization;

import Flat.User;

import java.util.ArrayList;

public class UpdateArrayList {
    public static void addInArrayList(ArrayList<String> arrayList, String id) {
        System.out.println("Команда выполняется");
        arrayList.add(id);
        arrayList.add(InitializationName.initalizationName());
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
        arrayList.add(User.getNameUser());
    }
}
