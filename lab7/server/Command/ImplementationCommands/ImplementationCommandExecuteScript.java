package Command.ImplementationCommands;

import AssemblyMultiMap.MultiMap;
import Commands.CommandType;
import Flat.Flat;
import RegularExpressions.*;
import org.w3c.dom.css.Counter;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ImplementationCommandExecuteScript {
    public static ArrayList<String> arrayList = new ArrayList<>();
    public static Set<String> stringSet = new HashSet<>();
    public static void executeScript(Stack<Flat> flats , MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap, ObjectOutputStream out) throws IOException {
        ArrayList <MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
        arrayList1 = multiMap.get(CommandType.EXECUTE_SCRIPT);
        for (int i = 0; i < arrayList1.size(); i++) {
            MultiMap<CommandType, ArrayList<String>> myMultiMap = arrayList1.get(i);
            if (myMultiMap.containsKey(CommandType.ADD)) {
                ImplementationCommandAddForExecuteScript.implementationAddForExecuteScript(flats,myMultiMap.get(CommandType.ADD), out);
//                ImplementationCommandSave.save(flats);
            }
            if (myMultiMap.containsKey(CommandType.INFO)) {
                ImplementationCommandInfo.implementationInfo(flats, out);
//                ImplementationCommandSave.save(flats);
            }
            if (myMultiMap.containsKey(CommandType.HELP)) {
                ImplementationCommandHelp.implementationHelp(out);
//                ImplementationCommandSave.save(flats);
            }
            if(myMultiMap.containsKey(CommandType.SHOW)){
                ImplementationCommandShow.ImplementationShow(flats, out);
//                ImplementationCommandSave.save(flats);
            }
            if (myMultiMap.containsKey(CommandType.CLEAR)) {
                ImplementationCommandClear.implementationClear(flats, myMultiMap.get(CommandType.CLEAR) ,out);
//                ImplementationCommandSave.save(flats);
            }
            if (myMultiMap.containsKey(CommandType.AVERAGE_OF_NUMBER_OF_ROOMS)) {
                ImplementationCommandAverageOfNumberOfRooms.averageOfNumberOfRooms(flats, out);
//                ImplementationCommandSave.save(flats);
            }
            if (myMultiMap.containsKey(CommandType.REMOVE_LAST)) {
                ImplementationCommandRemoveLast.implemenatationRemoveLast(flats, out);
//                ImplementationCommandSave.save(flats);
            }
            if (myMultiMap.containsKey(CommandType.FILTER_STARTS_WITH_NAME)) {
                ImplementationFilterStartsWithName.filterStartsWithName(flats, myMultiMap.get(CommandType.FILTER_STARTS_WITH_NAME), out);
//                ImplementationCommandSave.save(flats);
            }
            if (myMultiMap.containsKey(CommandType.REMOVE_BY_ID)) {
                ImplementationCommandRemoveById.RemoveById(flats, myMultiMap.get(CommandType.REMOVE_BY_ID), out);
//                ImplementationCommandSave.save(flats);
            }
            // работа с myMultiMap
        }
        out.writeObject("Все команды выполнены");
    }
}
