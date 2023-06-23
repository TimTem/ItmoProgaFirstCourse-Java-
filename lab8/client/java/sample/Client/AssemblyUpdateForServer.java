package sample.Client;

import sample.AssemblyMultiMap.MultiMap;
import sample.Commands.CommandType;
import sample.FieldInitialization.*;
import sample.ImplementationCommand.UpdateCommand;
import sample.Launcher.ClientLauncher;

import java.util.ArrayList;

public class AssemblyUpdateForServer {
    public static MultiMap add(String name, Double xCoordinates, Double yCoordinates, Integer area, Integer numberOfRooms, Boolean qualityBurger, String finishingBurger, String transportBurger, String nameHouse, Integer yearsHouse, Integer numberOfApartments) {
        MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
        ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
        MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(String.valueOf(UpdateCommand.flat.getId()));
        arrayList.add(name);
        arrayList.add(InitializationCoordinates.initializationCoordinateX(xCoordinates));
        arrayList.add(InitializationCoordinates.initializationCoordinateY(yCoordinates));
        arrayList.add(InitializationArea.initializationArea(area));
        arrayList.add(InitializationNumberOfRooms.numberOfRooms(numberOfRooms));
        arrayList.add(InitializationNew.whatApartment(qualityBurger));
        arrayList.add(InitializationFurnish.initializationFurnish(finishingBurger));
        arrayList.add(InitializationTransports.initializationTransports(transportBurger));
        arrayList.add(InitializationHouse.initializationHouseName(nameHouse));
        arrayList.add(InitializationHouse.initializationYear(yearsHouse));
        arrayList.add(InitializationHouse.initializationNumberOfFlatsOnFloor(numberOfApartments));
        arrayList.add(ClientLauncher.user.getNameUser());
        multiMap.put(CommandType.UPDATE, arrayList);
        arrayList1.add(multiMap);
        multiMap1.put(CommandType.UPDATE, arrayList1);
        return multiMap1;
    }
}
