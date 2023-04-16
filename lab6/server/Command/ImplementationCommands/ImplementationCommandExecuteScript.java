package Command.ImplementationCommands;

import AssemblyMultiMap.MultiMap;
import Command.*;
import Commands.CommandType;
import Flat.Flat;
import RegularExpressions.*;
import org.w3c.dom.css.Counter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ImplementationCommandExecuteScript {
    public static ArrayList<String> arrayList = new ArrayList<>();
    public static Set<String> stringSet = new HashSet<>();
    public static void executeScript(Stack<Flat> flats , MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap) throws IOException {
        ArrayList <MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
        arrayList1 = multiMap.get(CommandType.EXECUTE_SCRIPT);
        for (int i = 0; i < arrayList1.size(); i++) {
            MultiMap<CommandType, ArrayList<String>> myMultiMap = arrayList1.get(i);
            if (myMultiMap.containsKey(CommandType.ADD)) {
                ImplementationCommandAdd.implementationAdd(flats,myMultiMap.get(CommandType.ADD));
                ImplementationCommandSave.save(flats);
            }
            if (myMultiMap.containsKey(CommandType.INFO)) {
                ImplementationCommandInfo.implementationInfo(flats);
                ImplementationCommandSave.save(flats);
            }
            if (myMultiMap.containsKey(CommandType.HELP)) {
                ImplementationCommandHelp.implementationHelp();
                ImplementationCommandSave.save(flats);
            }
            if(myMultiMap.containsKey(CommandType.SHOW)){
                ImplementationCommandShow.ImplementationShow(flats);
                ImplementationCommandSave.save(flats);
            }
            if (myMultiMap.containsKey(CommandType.CLEAR)) {
                ImplementationCommandClear.implementationClear(flats);
                ImplementationCommandSave.save(flats);
            }
            if (myMultiMap.containsKey(CommandType.AVERAGE_OF_NUMBER_OF_ROOMS)) {
                ImplementationCommandAverageOfNumberOfRooms.averageOfNumberOfRooms(flats);
                ImplementationCommandSave.save(flats);
            }
            if (myMultiMap.containsKey(CommandType.REMOVE_LAST)) {
                ImplementationCommandRemoveLast.implemenatationRemoveLast(flats);
                ImplementationCommandSave.save(flats);
            }
            if (myMultiMap.containsKey(CommandType.FILTER_STARTS_WITH_NAME)) {
                ImplementationFilterStartsWithName.filterStartsWithName(flats, myMultiMap.get(CommandType.FILTER_STARTS_WITH_NAME));
                ImplementationCommandSave.save(flats);
            }
            if (myMultiMap.containsKey(CommandType.REMOVE_BY_ID)) {
                ImplementationCommandRemoveById.RemoveById(flats, myMultiMap.get(CommandType.REMOVE_BY_ID));
                ImplementationCommandSave.save(flats);
            }
            // работа с myMultiMap
        }

//        String counter;
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader(filename));
//            String str;
//            while ((str = reader.readLine()) != null) {
//                if (!str.trim().isEmpty()) {
//                    if (RegExpAdd.addRegExp(str) != null) {
//                       ImplementationCommandAdd.implementationAdd(flats, RegExpAdd.addRegExp(str));
//                        continue;
//                    }
//                    if (RegExpHelp.regExpHelp(str)) {
//                        ImplementationCommandHelp.implementationHelp();
//                        continue;
//                    }
//                    if (RegExpClear.clearRegExp(str)) {
//                        ImplementationCommandClear.implementationClear(flats);
//                        continue;
//                    }
//                    if (RegExpInfo.infoRegExp(str)) {
//                        ImplementationCommandInfo.implementationInfo(flats);
//                        continue;
//                    }
//                    if (RegExpShow.showRegExp(str)) {
//                        ImplementationCommandShow.ImplementationShow(flats);
//                        continue;
//                    }
//                    if(RegExpAverageOfNumberOfRooms.averageOfNumberOfRoomsRegExp(str)){
//                        ImplementationCommandAverageOfNumberOfRooms.averageOfNumberOfRooms(flats);
//                        continue;
//                    }
//                    if(RegExpExit.exitRegExp(str)){
//                        ImplementationCommandExit.exit(flats);
//                        continue;
//                    }
//                    if(RegExpRemoveLast.removeLastRegExp(str)){
//                        ImplementationCommandRemoveLast.implemenatationRemoveLast(flats);
//                    }
//                    if(RegExpFilterStartsWithName.filterStartsWithNameRegExp(str) != null){
//                        ImplementationFilterStartsWithName.filterStartsWithName(flats,RegExpFilterStartsWithName.filterStartsWithNameRegExp(str));
//                        continue;
//                    }
//                    if(RegExpRemoveById.removeByIdRegExp(str) != null){
//                        ImplementationCommandRemoveById.RemoveById(flats,RegExpRemoveById.removeByIdRegExp(str));
//                        continue;
//                    }
//                    if(RegExpSave.saveRegExp(str)){
//                        ImplementationCommandSave.save(flats);
//                        continue;
//                    }
//                    if(RegExpExucuteScript.executeScriptReg(str) != null){
//                        for (String element : arrayList) {
//                            if (!stringSet.add(element)) {
//                                System.out.println("This file may cause recursion. Change the variables in the file.");
//                                return;
//                            }
//                        }
//                        ImplementationCommandExecuteScript.executeScript(flats, RegExpExucuteScript.executeScriptReg(str));
//                        continue;
//                    }
//                    System.out.println("Executing script line: " + str);
//                }
//            }
//            reader.close();
//        } catch (IOException e) {
//            System.out.println("An error occurred while reading the file");
//        }
    }
}
