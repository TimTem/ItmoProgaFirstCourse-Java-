package Flat;

public enum Transports implements com.sun.jdi.connect.Transport {
    FEW("Few"),
    NONE("None"),
    LITTLE("Litle"),
    NORMAL("Normal"),
    ENOUGH("Enough");
    private final String name;
    Transports(String string){
        this.name = string;
    }
    public String getName(){
        return name.toLowerCase();
    }

    @Override
    public String toString(){
        return name.toLowerCase();
    }
}