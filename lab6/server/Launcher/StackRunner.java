package Launcher;

import AssemblyMultiMap.MultiMap;
import Command.*;
import Command.ImplementationCommands.*;
import Commands.CommandType;
import Flat.Flat;
import Json.Deserializer;
import com.sun.jdi.Value;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.Key;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackRunner {
    public static Stack<Flat> flats = new Stack<>();
    public static Command.Stack stack = new Command.Stack(flats);

    //    public static Developer developer = new Developer(new Help(stack), new Show(stack), new Clear(stack), new Save(stack), new RemoveLast(stack), new History(stack), new AverageOfNumberOfRooms(stack), new Exit(stack), new Info(stack), new Add(stack), new RemoveById(stack), new RemoveGreater(stack), new FilterStartsWithName(stack));
    public StackRunner() {

    }

    public static void runner(MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap) throws IOException {

//        Scanner scanner1;
//        String answer;
//        // if ((new File("/home/studs/s371814/proga/lab5/SaverChecker.txt")).length() != 0L)
//        if ((new File("/home/studs/s371814/proga/lab5/SaverChecker.txt")).length() != 0)
//        {
//            scanner1 = new Scanner(System.in);
//            System.out.print("The program did not finish its work correctly. Do you want to restore? (yes/no) ");
//            answer = scanner1.nextLine();
//            answer = answer.replaceAll(" ", "");
//            Pattern pattern_2 = Pattern.compile("(YES|Yes|yes)");
//            Matcher mt_2 = pattern_2.matcher(answer);
//            if (mt_2.matches()) {
//                StringBuilder stringBuilder = new StringBuilder();
//                File file = new File("/home/studs/s371814/proga/lab5/SaverChecker.txt");
//                if (file.canRead()) {
//                    FileInputStream fileInputStream = new FileInputStream(file);
//
//                    InputStreamReader inputStreamReader;
//                    for (inputStreamReader = new InputStreamReader(fileInputStream); inputStreamReader.ready(); stringBuilder = stringBuilder.append(Character.toString(inputStreamReader.read()))) {
//                    }
//
//                    inputStreamReader.close();
//                } else {
//                    System.out.println("File have same problems");
//                }
//
//                if (!stringBuilder.isEmpty()) {
//                    flats.addAll(Deserializer.deserializer(stringBuilder.toString()));
//                    ImplementationCommandCheckSave.saveAgain();
//                }
//            }
//
//            ImplementationCommandCheckSave.saveAgain();
//        }
//        while (true) {
            if (multiMap.containsKey(CommandType.ADD)) {
                ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList = new ArrayList<>();
                arrayList = multiMap.get(CommandType.ADD);
                MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
                multiMap1 = arrayList.get(0);
                ImplementationCommandAdd.implementationAdd(flats,multiMap1.get(CommandType.ADD));
                ImplementationCommandSave.save(flats);
            }
            if (multiMap.containsKey(CommandType.INFO)) {
                ImplementationCommandInfo.implementationInfo(flats);
                ImplementationCommandSave.save(flats);
            }
            if (multiMap.containsKey(CommandType.HELP)) {
                ImplementationCommandHelp.implementationHelp();
                ImplementationCommandSave.save(flats);
            }
            if(multiMap.containsKey(CommandType.SHOW)){
                ImplementationCommandShow.ImplementationShow(flats);
                ImplementationCommandSave.save(flats);
            }
            if (multiMap.containsKey(CommandType.CLEAR)) {
                ImplementationCommandClear.implementationClear(flats);
                ImplementationCommandSave.save(flats);
            }
            if (multiMap.containsKey(CommandType.AVERAGE_OF_NUMBER_OF_ROOMS)) {
                ImplementationCommandAverageOfNumberOfRooms.averageOfNumberOfRooms(flats);
                ImplementationCommandSave.save(flats);
            }
            if (multiMap.containsKey(CommandType.REMOVE_LAST)) {
                ImplementationCommandRemoveLast.implemenatationRemoveLast(flats);
                ImplementationCommandSave.save(flats);
            }
            if (multiMap.containsKey(CommandType.FILTER_STARTS_WITH_NAME)) {
                ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList = new ArrayList<>();
                arrayList = multiMap.get(CommandType.ADD);
                MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
                multiMap1 = arrayList.get(0);
               ImplementationFilterStartsWithName.filterStartsWithName(flats, multiMap1.get(CommandType.FILTER_STARTS_WITH_NAME));
                ImplementationCommandSave.save(flats);
            }
            if (multiMap.containsKey(CommandType.REMOVE_BY_ID)) {
                ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList = new ArrayList<>();
                arrayList = multiMap.get(CommandType.ADD);
                MultiMap<CommandType, ArrayList<String>> multiMap1 = new MultiMap<>();
                multiMap1 = arrayList.get(0);
                ImplementationCommandRemoveById.RemoveById(flats, multiMap1.get(CommandType.REMOVE_BY_ID));
                ImplementationCommandSave.save(flats);
            }
            if (multiMap.containsKey(CommandType.EXECUTE_SCRIPT)) {
                ImplementationCommandExecuteScript.executeScript(flats, multiMap);

            }
        }
    }
