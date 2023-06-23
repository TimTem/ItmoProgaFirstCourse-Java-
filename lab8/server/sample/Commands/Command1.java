package sample.Commands;



import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Command1 implements Serializable {
    @Serial
    private static final long serialVersionUID = 321321321321L;
    public CommandType commandType;
    public ArrayList<String> arrayList;
    public Command1(CommandType commandType, ArrayList<String> arrayList) {
        this.commandType = commandType;
        this.arrayList = arrayList;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public ArrayList<String> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }
}
