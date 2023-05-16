package Launcher;

import AssemblyMultiMap.MultiMap;
import Command.ImplementationCommands.*;
import Commands.CommandType;
import Flat.Flat;
//import Validator.ValidatorForStack;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Stack;

public class StackRunner {
    public static Stack<Flat> flats = new Stack<>();
//    public static Command.Stack stack = new Command.Stack(flats);

    //    public static Developer developer = new Developer(new Help(stack), new Show(stack), new Clear(stack), new Save(stack), new RemoveLast(stack), new History(stack), new AverageOfNumberOfRooms(stack), new Exit(stack), new Info(stack), new Add(stack), new RemoveById(stack), new RemoveGreater(stack), new FilterStartsWithName(stack));

    public synchronized static void runner(MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap, ObjectOutputStream out) throws Exception {
        if (multiMap.containsKey(CommandType.UPDATE)) {
            ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList;
            arrayList = multiMap.get(CommandType.UPDATE);
            MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
            multiMap1 = arrayList.get(0);
            ImplementationCommandUpdate.updateElementCollection(flats, multiMap1.get(CommandType.UPDATE), out);
//               ImplementationCommandSave.save(flats);
//               continue;
        }
        if (multiMap.containsKey(CommandType.ADD)) {
            ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList = new ArrayList<>();
            arrayList = multiMap.get(CommandType.ADD);
            MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
            multiMap1 = arrayList.get(0);
            ImplementationCommandAdd.implementationAdd(flats, multiMap1.get(CommandType.ADD), out);
//               ImplementationCommandSave.save(flats);
//               continue;
        }
        if (multiMap.containsKey(CommandType.INFO)) {
            ImplementationCommandInfo.implementationInfo(flats, out);
//               ImplementationCommandSave.save(flats);
//               continue;
        }
        if (multiMap.containsKey(CommandType.HELP)) {
            ImplementationCommandHelp.implementationHelp(out);
//               ImplementationCommandSave.save(flats);
//               continue;
        }
        if (multiMap.containsKey(CommandType.SHOW)) {
            ImplementationCommandShow.ImplementationShow(flats, out);
//               ImplementationCommandSave.save(flats);
//               continue;
        }
        if (multiMap.containsKey(CommandType.CLEAR)) {
            ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList = new ArrayList<>();
            arrayList = multiMap.get(CommandType.CLEAR);
            MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
            multiMap1 = arrayList.get(0);
            ImplementationCommandClear.implementationClear(flats, multiMap1.get(CommandType.CLEAR) ,out);
//               ImplementationCommandSave.save(flats);
//               continue;
        }
        if (multiMap.containsKey(CommandType.AVERAGE_OF_NUMBER_OF_ROOMS)) {
            ImplementationCommandAverageOfNumberOfRooms.averageOfNumberOfRooms(flats, out);
//               ImplementationCommandSave.save(flats);
//               continue;
        }
        if (multiMap.containsKey(CommandType.REMOVE_LAST)) {
            ImplementationCommandRemoveLast.implemenatationRemoveLast(flats, out);
//               ImplementationCommandSave.save(flats);
//               continue;
        }
        if (multiMap.containsKey(CommandType.FILTER_STARTS_WITH_NAME)) {
            ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList = new ArrayList<>();
            arrayList = multiMap.get(CommandType.ADD);
            MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
            multiMap1 = arrayList.get(0);
            ImplementationFilterStartsWithName.filterStartsWithName(flats, multiMap1.get(CommandType.FILTER_STARTS_WITH_NAME), out);
//               ImplementationCommandSave.save(flats);
//               continue;
        }
        if (multiMap.containsKey(CommandType.REMOVE_BY_ID)) {
            ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList = new ArrayList<>();
            arrayList = multiMap.get(CommandType.REMOVE_BY_ID);
            MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
            multiMap1 = arrayList.get(0);
            ImplementationCommandRemoveById.RemoveById(flats, multiMap1.get(CommandType.REMOVE_BY_ID), out);
//               ImplementationCommandSave.save(flats);
//               continue;
        }
        if (multiMap.containsKey(CommandType.EXECUTE_SCRIPT)) {
            ImplementationCommandExecuteScript.executeScript(flats, multiMap, out);
//               continue;
//           }
        }
    }
}
