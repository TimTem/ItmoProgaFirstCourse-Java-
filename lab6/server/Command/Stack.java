package Command;

import Command.ImplementationCommands.*;
import Flat.Flat;

import javax.imageio.IIOException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Stack {
    java.util.Stack<Flat> flats = new java.util.Stack<>();
    private static final LocalDateTime timeInit = LocalDateTime.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private String date = timeInit.format(formatter);
    public Stack(java.util.Stack<Flat> flats){
        this.flats = flats;
    }
    public void show(){
        ImplementationCommandShow.ImplementationShow(flats);
        ImplementationCommandHistory.separatlyHistory("Show");
    }
    public void help(){
        ImplementationCommandHelp.implementationHelp();
        ImplementationCommandHistory.separatlyHistory("Help");
    }
    public void exit(){
        ImplementationCommandExit.exit(flats);
        ImplementationCommandHistory.separatlyHistory("Exit");
    }
    public void info(){
        ImplementationCommandInfo.implementationInfo(flats);
        ImplementationCommandHistory.separatlyHistory("Info");
    }
//    public void filterStartsWithName(String str){
//        ImplementationFilterStartsWithName.filterStartsWithName(flats, str);
//        ImplementationCommandHistory.separatlyHistory("filter_starts_with_name: " + str);
//    }
    public void removeLast(){
        ImplementationCommandRemoveLast.implemenatationRemoveLast(flats);
        ImplementationCommandHistory.separatlyHistory("remove_last");
    }
    public void removeGreater(String str){
        ImplementationCommandRemoveGreater.removeGreater(flats, str);
        ImplementationCommandHistory.separatlyHistory("remove_greater");
    }
//    public void removeById(String str){
//        ImplementationCommandRemoveById.RemoveById(flats, str);
//        ImplementationCommandHistory.separatlyHistory("remove_by_id: " + str);
//    }
    public void history(){
        ImplementationCommandHistory.showHistory();
        ImplementationCommandHistory.separatlyHistory("history");
    }
    public void clear(){
        ImplementationCommandClear.implementationClear(flats);
        ImplementationCommandHistory.separatlyHistory("clear");
    }
    public void averageOfRooms(){
        ImplementationCommandAverageOfNumberOfRooms.averageOfNumberOfRooms(flats);
        ImplementationCommandHistory.separatlyHistory("average_of_number_of_rooms ");
    }
    public void addElement(String str){
        ImplementationCommandAdd.implementationAdd(flats, new ArrayList<>());
        ImplementationCommandHistory.separatlyHistory("add: " + str);
    }
    public void save(){
        ImplementationCommandSave.save(flats);
        ImplementationCommandHistory.separatlyHistory("save");
    }
//    public void executeScript(String str) throws IOException {
//        ImplementationCommandExecuteScript.executeScript(flats, str);
//        ImplementationCommandHistory.separatlyHistory("execute_script: " + str + ".txt");
//    }
}
