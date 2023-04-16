package Command;

import java.io.IOException;

public class Developer {
    CommandWithoutVariable help;
    CommandWithoutVariable show;
    CommandWithoutVariable clear;
    CommandWithoutVariable save;
    CommandWithoutVariable removeLast;
    CommandWithoutVariable history;
    CommandWithoutVariable averageOfNumberOfRooms;
    CommandWithoutVariable exit;

    CommandWithoutVariable info;
    CommandWithVariable add;
   // CommandWithVariable update;
    CommandWithVariable removeById;
    CommandWithVariable executeScript;
   // CommandWithVariable insertAtIndex;
    CommandWithVariable removeGreater;
    CommandWithVariable filterStartsWithName;

    public Developer(CommandWithoutVariable help, CommandWithoutVariable show, CommandWithoutVariable clear, CommandWithoutVariable save, CommandWithoutVariable removeLast, CommandWithoutVariable history, CommandWithoutVariable averageOfNumberOfRooms, CommandWithoutVariable exit, CommandWithoutVariable info, CommandWithVariable add, CommandWithVariable removeById, CommandWithVariable removeGreater, CommandWithVariable filterStartsWithName, CommandWithVariable executeScript) {
        this.help = help;
        this.show = show;
        this.clear = clear;
        this.save = save;
        this.removeLast = removeLast;
        this.history = history;
        this.averageOfNumberOfRooms = averageOfNumberOfRooms;
        this.exit = exit;
        this.info = info;
        this.add = add;
        this.removeById = removeById;
        this.removeGreater = removeGreater;
        this.filterStartsWithName = filterStartsWithName;
        this.executeScript = executeScript;
    }

    // CommandWithVariable filterLessThanTransport;

//    public Developer(CommandWithoutVariable help, CommandWithoutVariable info, CommandWithoutVariable show, CommandWithoutVariable clear, CommandWithoutVariable removeLast, CommandWithoutVariable history, CommandWithoutVariable averageOfNumberOfRooms, CommandWithVariable add, CommandWithVariable removeById, CommandWithVariable removeGreater, CommandWithVariable filterStartsWithName, CommandWithoutVariable exit) {
//        this.help = help;
//        this.info = info;
//        this.show = show;
//        this.clear = clear;
//        this.save = save;
//        this.removeLast = removeLast;
//        this.history = history;
//        this.averageOfNumberOfRooms = averageOfNumberOfRooms;
//        this.add = add;
//        this.update = update;
//        this.removeById = removeById;
//        this.executeScript = executeScript;
//        this.insertAtIndex = insertAtIndex;
//        this.removeGreater = removeGreater;
//        this.filterStartsWithName = filterStartsWithName;
//        this.filterLessThanTransport = filterLessThanTransport;
//        this.exit = exit;
//    }

    public void helpStack(){
        help.exucute();
    }
    public void infoStack(){
        info.exucute();
    }
    public void showStack(){
        show.exucute();
    }
    public void addStack(String str){
        add.exucute(str);
    }
//    public void updateIdStack(String str){
//        update.exucute(str);
//    }
    public void removeByIdStack(String str){
        removeById.exucute(str);
    }
    public void clearStack(){
        clear.exucute();
    }
    public void saveStack(){
        save.exucute();
    }
    public void executeScript(String str){
        executeScript.exucute(str);
    }
    public void exitStack(){
        exit.exucute();
    }
//    public void insertAtIndexStack(String str){
//        insertAtIndex.exucute(str);
//    }
    public void removeLastStack(){
        removeLast.exucute();
    }
    public void removeGreaterStack(String str){
        removeGreater.exucute(str);
    }
    public void averageOfNumberOfRoomsStack(){
        averageOfNumberOfRooms.exucute();
    }
    public void filterStartsWithNameStack(String str){
        filterStartsWithName.exucute(str);
    }
//    public void filterLessThanTransportStack(String str){
//        filterLessThanTransport.exucute(str);
//    }
}
