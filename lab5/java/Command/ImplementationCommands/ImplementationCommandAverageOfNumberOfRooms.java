package Command.ImplementationCommands;

import Flat.Flat;

import java.util.Stack;

public class ImplementationCommandAverageOfNumberOfRooms {
    public static void averageOfNumberOfRooms(Stack<Flat> flats) {
        if (flats.size() == 0) {
            System.out.println("Collection empty");
            return;
        }
        long counter = 0;
        for (Flat flat : flats) {
            counter += flat.getNumberOfRooms();
        }
        Math.round(counter /= flats.size());
        System.out.println("The average value of the numberOfRooms field for all elements of the collection: " + counter);
    }
}
