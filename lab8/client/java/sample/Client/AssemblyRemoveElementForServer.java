package sample.Client;

import sample.AssemblyMultiMap.MultiMap;
import sample.Commands.CommandType;

import java.util.ArrayList;

public class AssemblyRemoveElementForServer {
    public static MultiMap removeElementForServer(int id) {
        String idElement = Integer.toString(id);
        MultiMap<CommandType, ArrayList<MultiMap<CommandType, ArrayList<String>>>> multiMap1 = new MultiMap<>();
        ArrayList<MultiMap<CommandType, ArrayList<String>>> arrayList1 = new ArrayList<>();
        MultiMap<CommandType, ArrayList<String>> multiMap = new MultiMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(idElement);
        multiMap.put(CommandType.REMOVE_LAST, arrayList);
        arrayList1.add(multiMap);
        multiMap1.put(CommandType.REMOVE_LAST, arrayList1);
        return multiMap1;
    }
}
