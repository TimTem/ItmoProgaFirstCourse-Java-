package Flat;

public enum Furnish {
    DESIGNER("Designer"),
    NONE("None"),
    BAD("Bad"),
    LITTLE("Little");
    private final String name;

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
