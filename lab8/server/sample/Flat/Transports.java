package sample.Flat;

import java.io.Serializable;

public enum Transports implements Serializable {
    FEW("Few"),
    NONE("None"),
    LITTLE("Litle"),
    NORMAL("Normal"),
    ENOUGH("Enough");
    private final String name;
    private static final long serialVersionUID = 5662525032286294813L;
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