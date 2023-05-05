package FieldInitialization;

import AssemblyMultiMap.MultiMap;
import Client.ClientWork;
import Commands.CommandType;
import ExitMethodException.ExitFromExecuteScript;
import Launcher.ExitClient;
import RegularExpressions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InitializationCommandExecuteScript {
    public static MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap = new MultiMap<>();
    public static ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayListForMultiMap = new ArrayList<>();
    public static ArrayList<String> arrayListForExceptionRecursion = new ArrayList<>();
    public static Set<String> stringSet = new HashSet<>();
//    public static ArrayList<String> arrayList = new ArrayList<>();
//    public static Set<String> stringSet = new HashSet<>();

    public static MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> execute(String filename) throws IOException{
        arrayListForExceptionRecursion.add(filename);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String str;
            while ((str = reader.readLine()) != null) {
                if (!str.trim().isEmpty()) {
                    if (RegExpAdd.addRegExp(str) != null) {
                        MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
                        ArrayList<String> arrayList = new ArrayList<>();
                        AddInArrayListForCommandAdd.addInArrayList(arrayList, RegExpAdd.addRegExp(str));
                        multiMap.put(CommandType.ADD, arrayList);
                        arrayListForMultiMap.add(multiMap);
//                        MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
//                        ArrayList<String> arrayList = new ArrayList<>();
//                        AddInArrayList.addInArrayList(arrayList, RegExpAdd.addRegExp(str));
//                        multiMap1.put(CommandType.ADD, arrayList);
//                        arrayListForMultiMap.add(multiMap1);
                    }
                    if (RegExpHelp.regExpHelp(str)) {
                        MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
                        ArrayList<String> arrayList = new ArrayList<>();
                        multiMap1.put(CommandType.HELP, arrayList);
                        arrayListForMultiMap.add(multiMap1);
                    }
                    if (RegExpClear.clearRegExp(str)) {
                        MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
                        ArrayList<String> arrayList = new ArrayList<>();
                        multiMap1.put(CommandType.CLEAR, arrayList);
                        arrayListForMultiMap.add(multiMap1);
                    }
                    if (RegExpInfo.infoRegExp(str)) {
                        MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
                        ArrayList<String> arrayList = new ArrayList<>();
                        multiMap1.put(CommandType.INFO, arrayList);
                        arrayListForMultiMap.add(multiMap1);
                    }
                    if (RegExpShow.showRegExp(str)) {
                        MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
                        ArrayList<String> arrayList = new ArrayList<>();
                        multiMap1.put(CommandType.SHOW, arrayList);
                        arrayListForMultiMap.add(multiMap1);
                    }
                    if (RegExpAverageOfNumberOfRooms.averageOfNumberOfRoomsRegExp(str)) {
                        MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
                        ArrayList<String> arrayList = new ArrayList<>();
                        multiMap1.put(CommandType.AVERAGE_OF_NUMBER_OF_ROOMS, arrayList);
                        arrayListForMultiMap.add(multiMap1);
                    }
                    if (RegExpExit.exitRegExp(str)) {
                        ExitClient.exitClient();
                        continue;
                    }
                    if (RegExpRemoveLast.removeLastRegExp(str)) {
                        MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
                        ArrayList<String> arrayList = new ArrayList<>();
                        multiMap1.put(CommandType.REMOVE_LAST, arrayList);
                        arrayListForMultiMap.add(multiMap1);
                    }
                    if (RegExpFilterStartsWithName.filterStartsWithNameRegExp(str) != null) {
                        MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(RegExpFilterStartsWithName.filterStartsWithNameRegExp(str));
                        multiMap1.put(CommandType.HELP, arrayList);
                        arrayListForMultiMap.add(multiMap1);
                    }
                    if (RegExpRemoveById.removeByIdRegExp(str) != null) {
                        MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
                        ArrayList<String> arrayList = new ArrayList<>();
                        arrayList.add(RegExpRemoveById.removeByIdRegExp(str));
                        multiMap1.put(CommandType.HELP, arrayList);
                        arrayListForMultiMap.add(multiMap1);
                    }
                    try{
                        if (RegExpExucuteScript.executeScriptReg(str) != null){
                            for (String element : arrayListForExceptionRecursion) {
                                if (!stringSet.add(element)) {
//                                    System.out.println("Этот файл может вызвать рекурсию.");
                                    throw new ExitFromExecuteScript();
                                }
                            }
                            execute(RegExpExucuteScript.executeScriptReg(str));
                        }
                    }catch (Exception e){
                        System.err.println("Команда отправлена на сервер, но так как файл может вызвать рекурсию, команда не будет выполнена!");
                        return multiMap;
                    }
                }
                multiMap.put(CommandType.EXECUTE_SCRIPT, arrayListForMultiMap);
//                    try {
//                        if (RegExpExucuteScript.executeScriptReg(str) != null) {
//                            for (String element : arrayList) {
//                                if (!stringSet.add(element)) {
//                                    throw new ExitException();
//                                }
//                            }
//                            InitializationCommandExecuteScript.execute(RegExpExucuteScript.executeScriptReg(str));
//                            continue;
//                        }
//                    } catch (Exception e) {
//                        System.err.println("Этот файл может вызвать рекурсию. Измените переменные в файле.");
//                    }
//                    System.out.println("Выполнение строки скрипта: " + str);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file");
        }
        return multiMap;
    }
}



