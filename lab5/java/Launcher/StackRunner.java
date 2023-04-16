package Launcher;

import Command.*;
import Command.ImplementationCommands.ImplementationCommandCheckSave;
import Command.ImplementationCommands.ImplementationCommandExecuteScript;
import Flat.Flat;
import Json.Deserializer;
import RegularExpressions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StackRunner {
    public static Stack<Flat> flats = new Stack<>();
    public static Command.Stack stack = new Command.Stack(flats);
    public static Developer developer = new Developer(new Help(stack), new Show(stack), new Clear(stack), new Save(stack), new RemoveLast(stack), new History(stack), new AverageOfNumberOfRooms(stack), new Exit(stack), new Info(stack), new Add(stack), new RemoveById(stack), new RemoveGreater(stack), new FilterStartsWithName(stack), new ExecuteScript(stack));
    public StackRunner(){

    }
    public static void runner() throws IOException {
        Scanner scanner1;
        String answer;
       // if ((new File("/home/studs/s371814/proga/lab5/SaverChecker.txt")).length() != 0L)
        if ((new File("/home/studs/s371814/proga/lab5/SaverChecker.txt")).length() != 0)
        {
            scanner1 = new Scanner(System.in);
            System.out.print("The program did not finish its work correctly. Do you want to restore? (yes/no) ");
            answer = scanner1.nextLine();
            answer = answer.replaceAll(" ", "");
            Pattern pattern_2 = Pattern.compile("(YES|Yes|yes)");
            Matcher mt_2 = pattern_2.matcher(answer);
            if (mt_2.matches()) {
                StringBuilder stringBuilder = new StringBuilder();
                File file = new File("/home/studs/s371814/proga/lab5/SaverChecker.txt");
                if (file.canRead()) {
                    FileInputStream fileInputStream = new FileInputStream(file);

                    InputStreamReader inputStreamReader;
                    for (inputStreamReader = new InputStreamReader(fileInputStream); inputStreamReader.ready(); stringBuilder = stringBuilder.append(Character.toString(inputStreamReader.read()))) {
                    }

                    inputStreamReader.close();
                } else {
                    System.out.println("File have same problems");
                }

                if (!stringBuilder.isEmpty()) {
                    flats.addAll(Deserializer.deserializer(stringBuilder.toString()));
                    ImplementationCommandCheckSave.saveAgain();
                }
            }

            ImplementationCommandCheckSave.saveAgain();
        }
        while (true) {
            System.out.print("Enter the command: ");
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            if (RegExpAdd.addRegExp(str) != null) {
                developer.addStack(RegExpAdd.addRegExp(str));
                ImplementationCommandCheckSave.saveChecker(flats);
                continue;
            }
            if (RegExpHelp.regExpHelp(str)) {
                developer.helpStack();
                ImplementationCommandCheckSave.saveChecker(flats);
                continue;
            }
            if (RegExpClear.clearRegExp(str)) {
                developer.clearStack();
                ImplementationCommandCheckSave.saveChecker(flats);
                continue;
            }
            if (RegExpInfo.infoRegExp(str)) {
                developer.infoStack();
                ImplementationCommandCheckSave.saveChecker(flats);
                continue;
            }
            if (RegExpShow.showRegExp(str)) {
                developer.showStack();
                ImplementationCommandCheckSave.saveChecker(flats);
                continue;
            }
            if (RegExpAverageOfNumberOfRooms.averageOfNumberOfRoomsRegExp(str)) {
                developer.averageOfNumberOfRoomsStack();
                ImplementationCommandCheckSave.saveChecker(flats);
                continue;
            }
            if (RegExpExit.exitRegExp(str)) {
                developer.exitStack();
                continue;
            }
            if (RegExpRemoveLast.removeLastRegExp(str)) {
                developer.removeLastStack();
                ImplementationCommandCheckSave.saveChecker(flats);
            }
            if (RegExpFilterStartsWithName.filterStartsWithNameRegExp(str) != null) {
                developer.filterStartsWithNameStack(RegExpFilterStartsWithName.filterStartsWithNameRegExp(str));
                ImplementationCommandCheckSave.saveChecker(flats);
                continue;
            }
            if (RegExpRemoveById.removeByIdRegExp(str) != null) {
                developer.removeByIdStack(RegExpRemoveById.removeByIdRegExp(str));
                ImplementationCommandCheckSave.saveChecker(flats);
                continue;
            }
            if (RegExpSave.saveRegExp(str)) {
                developer.saveStack();
                ImplementationCommandCheckSave.saveChecker(flats);
                continue;
            }
            if (RegExpExucuteScript.executeScriptReg(str) != null) {
                ImplementationCommandExecuteScript.arrayList.add(RegExpExucuteScript.executeScriptReg(str));
                developer.executeScript(RegExpExucuteScript.executeScriptReg(str));
                ImplementationCommandCheckSave.saveChecker(flats);
                continue;
            }
            System.out.println("Invalid syntax");
        }
    }
}
