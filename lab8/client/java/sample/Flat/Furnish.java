package sample.Flat;

import java.io.Serializable;

public enum Furnish implements Serializable {

    DESIGNER("Designer"),
    NONE("None"),
    BAD("Bad"),
    LITTLE("Little");
    private final String name;
    private static final long serialVersionUID = 596252501286294813L;
    Furnish(String string) {
        this.name = string;
    }

    public String getName() {
        return name.toLowerCase();
    }

    @Override
    public String toString() {
        return name.toLowerCase();
    }
}
