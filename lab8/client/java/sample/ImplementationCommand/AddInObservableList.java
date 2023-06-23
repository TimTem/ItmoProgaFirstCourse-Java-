package sample.ImplementationCommand;

import sample.Flat.Coordinates;
import sample.Flat.Flat;
import sample.Flat.House;
import sample.Flat.User;
import sample.Launcher.ClientLauncher;

public class AddInObservableList {
    public static void addInObserverList(String name, Double xCoordinates, Double yCoordinates, Integer area,Integer numberOfRooms,Boolean qualityBurger,String finishingBurger, String transportBurger, String nameHouse, Integer yearsHouse, Integer numberOfApartments){
        Flat flat = new Flat();
        flat.setId();
        flat.setName(name);
        flat.setCoordinates(new Coordinates(xCoordinates, yCoordinates));
        flat.setArea(Long.valueOf(area));
        flat.setNumberOfRooms(numberOfRooms);
        flat.setNew(qualityBurger);
        flat.setFurnish(finishingBurger);
        flat.setTransport(transportBurger);
        flat.setHouse(new House(nameHouse,yearsHouse,Long.valueOf(numberOfApartments)));
        flat.setUser(new User(ClientLauncher.user.getNameUser(),(null)));
//        BasicPanelContoller.observableList.add(flat);
        ClientLauncher.stack.add(flat);
    }
}
