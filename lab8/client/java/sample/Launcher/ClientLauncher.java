package sample.Launcher;


import sample.AssemblyMultiMap.MultiMap;
import sample.Commands.CommandType;
import sample.Flat.Flat;
import sample.Flat.User;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Stack;

public class ClientLauncher {
    public static Stack<Flat> stack = new Stack<Flat>();
    public static User user = new User();
    public static Socket socket;
    private static String host = "localhost";
    private static int port = 8081;
    public static String infoFlat;
    public static Float average;

    public static void setSocket(Socket socket) {
        ClientLauncher.socket = socket;
    }
}
//               ImplementationCommandSave.save(flats);
//               continue;
//        while (true) {
//            System.out.print("Enter the command: ");
//            Scanner scanner = new Scanner(System.in);
//            String str = scanner.nextLine();
//            if (RegExpAdd.addRegExp(str) != null) {
//                MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
//                ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
//                MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
//                ArrayList<String> arrayList = new ArrayList<>();
//                AddInArrayListForCommandAdd.addInArrayList(arrayList, RegExpAdd.addRegExp(str));
//                multiMap.put(CommandType.ADD, arrayList);
//                arrayList1.add(multiMap);
//                multiMap1.put(CommandType.ADD, arrayList1);
//                return multiMap1;
////                ClientWork.sendToServer(out,multiMap1,inputStream);
////                continue;
////                return multiMap1;
////                HashMap<CommandType, ArrayList<String>> hashMap = new HashMap<>();
////                ArrayList<String> arrayList = new ArrayList<>();
////                AddInArrayList.addInArrayList(arrayList, RegExpAdd.addRegExp(str));
////                hashMap.put(CommandType.ADD, arrayList);
////                return hashMap;
//            }
//            if (RegExpHelp.regExpHelp(str)) {
//                MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
//                ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
//                MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
//                ArrayList<String> arrayList = new ArrayList<>();
//                multiMap.put(CommandType.HELP, arrayList);
//                arrayList1.add(multiMap);
//                multiMap1.put(CommandType.HELP, arrayList1);
//                return multiMap1;
////                ClientWork.sendToServer(out,multiMap1,inputStream);
////                continue;
//
////                HashMap<CommandType, ArrayList<String>> hashMap = new HashMap<>();
////                ArrayList<String> arrayList = new ArrayList<>();
////                hashMap.put(CommandType.HELP, arrayList);
////                return hashMap;
//            }
//            if (RegExpInfo.infoRegExp(str)) {
//                MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
//                ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
//                MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
//                ArrayList<String> arrayList = new ArrayList<>();
//                multiMap.put(CommandType.INFO, arrayList);
//                arrayList1.add(multiMap);
//                multiMap1.put(CommandType.INFO, arrayList1);
//                return multiMap1;
////                ClientWork.sendToServer(out,multiMap1,inputStream);
////                continue;
//
////                HashMap<CommandType, ArrayList<String>> hashMap = new HashMap<>();
////                ArrayList<String> arrayList = new ArrayList<>();
////                hashMap.put(CommandType.INFO, arrayList);
////                return hashMap;
//            }
//            if (RegExpShow.showRegExp(str)) {
//                MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
//                ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
//                MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
//                ArrayList<String> arrayList = new ArrayList<>();
//                multiMap.put(CommandType.SHOW, arrayList);
//                arrayList1.add(multiMap);
//                multiMap1.put(CommandType.SHOW, arrayList1);
//                return multiMap1;
////                ClientWork.sendToServer(out,multiMap1,inputStream);
////                continue;
//
////                HashMap<CommandType, ArrayList<String>> hashMap = new HashMap<>();
////                ArrayList<String> arrayList = new ArrayList<>();
////                hashMap.put(CommandType.SHOW, arrayList);
////                return hashMap;
//            }
//            if (RegExpClear.clearRegExp(str)) {
//                MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
//                ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
//                MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
//                ArrayList<String> arrayList = new ArrayList<>();
//                arrayList.add(User.getNameUser());
//                multiMap.put(CommandType.CLEAR, arrayList);
//                arrayList1.add(multiMap);
//                multiMap1.put(CommandType.CLEAR, arrayList1);
//                return multiMap1;
////                ClientWork.sendToServer(out,multiMap1,inputStream);
////                continue;
//
////                HashMap<CommandType, ArrayList<String>> hashMap = new HashMap<>();
////                ArrayList<String> arrayList = new ArrayList<>();
////                hashMap.put(CommandType.CLEAR, arrayList);
////                return hashMap;
//            }
//            if (RegExpAverageOfNumberOfRooms.averageOfNumberOfRoomsRegExp(str)) {
//                MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
//                ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
//                MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
//                ArrayList<String> arrayList = new ArrayList<>();
//                multiMap.put(CommandType.AVERAGE_OF_NUMBER_OF_ROOMS, arrayList);
//                arrayList1.add(multiMap);
//                multiMap1.put(CommandType.AVERAGE_OF_NUMBER_OF_ROOMS, arrayList1);
//                return multiMap1;
////                ClientWork.sendToServer(out,multiMap1,inputStream);
////                continue;
//
////                HashMap<CommandType, ArrayList<String>> hashMap = new HashMap<>();
////                ArrayList<String> arrayList = new ArrayList<>();
////                hashMap.put(CommandType.AVERAGE_OF_NUMBER_OF_ROOMS, arrayList);
////                return hashMap;
//            }
//            if (RegExpExit.exitRegExp(str)) {
//                System.out.println(User.getNameUser());
////                if(ExitClient.exitClient() == true){
////                    System.exit(0);
////                }
////                continue;
//            }
//            if (RegExpRemoveLast.removeLastRegExp(str)) {
//                MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
//                ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
//                MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
//                ArrayList<String> arrayList = new ArrayList<>();
//                multiMap.put(CommandType.REMOVE_LAST, arrayList);
//                arrayList1.add(multiMap);
//                multiMap1.put(CommandType.REMOVE_LAST, arrayList1);
//                return multiMap1;
////                ClientWork.sendToServer(out,multiMap1,inputStream);
////                continue;
//
////                HashMap<CommandType, ArrayList<String>> hashMap = new HashMap<>();
////                ArrayList<String> arrayList = new ArrayList<>();
////                hashMap.put(CommandType.REMOVE_LAST, arrayList);
////                return hashMap;
//            }
//            if (RegExpFilterStartsWithName.filterStartsWithNameRegExp(str) != null) {
//                MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
//                ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
//                MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
//                ArrayList<String> arrayList = new ArrayList<>();
//                arrayList.add(RegExpFilterStartsWithName.filterStartsWithNameRegExp(str));
//                multiMap.put(CommandType.FILTER_STARTS_WITH_NAME, arrayList);
//                arrayList1.add(multiMap);
//                multiMap1.put(CommandType.FILTER_STARTS_WITH_NAME, arrayList1);
//                return multiMap1;
////                ClientWork.sendToServer(out,multiMap1,inputStream);
////                continue;
//
////                HashMap<CommandType, ArrayList<String>> hashMap = new HashMap<>();
////                ArrayList<String> arrayList = new ArrayList<>();
////                arrayList.add(RegExpFilterStartsWithName.filterStartsWithNameRegExp(str));
////                hashMap.put(CommandType.FILTER_STARTS_WITH_NAME, arrayList);
////                return hashMap;
//            }
//            if (RegExpRemoveById.removeByIdRegExp(str) != null) {
//                MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
//                ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
//                MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
//                ArrayList<String> arrayList = new ArrayList<>();
//                arrayList.add(RegExpRemoveById.removeByIdRegExp(str));
//                arrayList.add(User.getNameUser());
//                multiMap.put(CommandType.REMOVE_BY_ID, arrayList);
//                arrayList1.add(multiMap);
//                multiMap1.put(CommandType.REMOVE_BY_ID, arrayList1);
//                return multiMap1;
////                ClientWork.sendToServer(out,multiMap1,inputStream);
////                continue;
//            }
//            if(RegExpUpdate.updateReg(str) != null){
//                MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
//                ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
//                MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
//                ArrayList<String> arrayList = new ArrayList<>();
//                UpdateArrayList.addInArrayList(arrayList, RegExpUpdate.updateReg(str));
//                multiMap.put(CommandType.UPDATE, arrayList);
//                arrayList1.add(multiMap);
//                multiMap1.put(CommandType.UPDATE, arrayList1);
//                return multiMap1;
//
//
////                ClientWork.sendToServer(out,multiMap1,inputStream);
////                continue;
//            }
//            if (RegExpExucuteScript.executeScriptReg(str) != null) {
//                return (InitializationCommandExecuteScript.execute(RegExpExucuteScript.executeScriptReg(str)));
////                ClientWork.sendToServer(out,InitializationCommandExecuteScript.execute(RegExpExucuteScript.executeScriptReg(str), inputStream, out),inputStream);
////                continue;
//            }
//            System.out.println("Invalid syntax");
//        }


