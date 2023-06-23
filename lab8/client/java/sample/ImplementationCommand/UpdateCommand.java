package sample.ImplementationCommand;

import sample.Flat.Coordinates;
import sample.Flat.Flat;
import sample.Flat.House;
import sample.Flat.User;
import sample.Launcher.ClientLauncher;

public class UpdateCommand {
    public static Flat flat;

    public static void setFlat(Flat flat1) {
        flat = flat1;
    }

    public static void updateCommand(String name, Double xCoordinates, Double yCoordinates, Integer area, Integer numberOfRooms, Boolean qualityBurger, String finishingBurger, String transportBurger, String nameHouse, Integer yearsHouse, Integer numberOfApartments) {
        for (Flat flat1 : ClientLauncher.stack) {
            if (flat1.getId() == flat.getId()) {
                flat1.setName(name);
                flat1.setCoordinates(new Coordinates(xCoordinates, yCoordinates));
                flat1.setArea(Long.valueOf(area));
                flat1.setNumberOfRooms(numberOfRooms);
                flat1.setNew(qualityBurger);
                flat1.setFurnish(finishingBurger);
                flat1.setTransport(transportBurger);
                flat1.setHouse(new House(nameHouse, yearsHouse, Long.valueOf(numberOfApartments)));
            }
        }
    }
}
