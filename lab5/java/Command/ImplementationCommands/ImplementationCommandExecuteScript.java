package Command.ImplementationCommands;

import Command.*;
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
    public static void executeScript(Stack<Flat> flats ,String filename) throws IOException {
        String counter;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String str;
            while ((str = reader.readLine()) != null) {
                if (!str.trim().isEmpty()) {
                    if (RegExpAdd.addRegExp(str) != null) {
                       ImplementationCommandAdd.implementationAdd(flats, RegExpAdd.addRegExp(str));
                        continue;
                    }
                    if (RegExpHelp.regExpHelp(str)) {
                        ImplementationCommandHelp.implementationHelp();
                        continue;
                    }
                    if (RegExpClear.clearRegExp(str)) {
                        ImplementationCommandClear.implementationClear(flats);
                        continue;
                    }
                    if (RegExpInfo.infoRegExp(str)) {
                        ImplementationCommandInfo.implementationInfo(flats);
                        continue;
                    }
                    if (RegExpShow.showRegExp(str)) {
                        ImplementationCommandShow.ImplementationShow(flats);
                        continue;
                    }
                    if(RegExpAverageOfNumberOfRooms.averageOfNumberOfRoomsRegExp(str)){
                        ImplementationCommandAverageOfNumberOfRooms.averageOfNumberOfRooms(flats);
                        continue;
                    }
                    if(RegExpExit.exitRegExp(str)){
                        ImplementationCommandExit.exit(flats);
                        continue;
                    }
                    if(RegExpRemoveLast.removeLastRegExp(str)){
                        ImplementationCommandRemoveLast.implemenatationRemoveLast(flats);
                    }
                    if(RegExpFilterStartsWithName.filterStartsWithNameRegExp(str) != null){
                        ImplementationFilterStartsWithName.filterStartsWithName(flats,RegExpFilterStartsWithName.filterStartsWithNameRegExp(str));
                        continue;
                    }
                    if(RegExpRemoveById.removeByIdRegExp(str) != null){
                        ImplementationCommandRemoveById.RemoveById(flats,RegExpRemoveById.removeByIdRegExp(str));
                        continue;
                    }
                    if(RegExpSave.saveRegExp(str)){
                        ImplementationCommandSave.save(flats);
                        continue;
                    }
                    if(RegExpExucuteScript.executeScriptReg(str) != null){
                        for (String element : arrayList) {
                            if (!stringSet.add(element)) {
                                System.out.println("Этот файл может вызвать рекурсию. Измените переменные в файле.");
                                return;
                            }
                        }
                        ImplementationCommandExecuteScript.executeScript(flats, RegExpExucuteScript.executeScriptReg(str));
                        continue;
                    }
                    System.out.println("Executing script line: " + str);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file");
        }
    }
}
