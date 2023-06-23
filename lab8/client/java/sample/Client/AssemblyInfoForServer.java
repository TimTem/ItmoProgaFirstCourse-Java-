package sample.Client;

import sample.AssemblyMultiMap.MultiMap;
import sample.Commands.CommandType;

import java.util.ArrayList;

public class AssemblyInfoForServer {
    public static MultiMap infoForServer() {
        MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
        ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
        MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        multiMap.put(CommandType.INFO, arrayList);
        arrayList1.add(multiMap);
        multiMap1.put(CommandType.INFO, arrayList1);
        return multiMap1;
    }
}
