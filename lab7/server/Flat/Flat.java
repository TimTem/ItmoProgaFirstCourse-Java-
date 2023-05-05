package Flat;

import Launcher.StackRunner;
import com.sun.jdi.connect.Transport;

import java.time.LocalDate;


public class Flat {
    private int id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate = LocalDate.now(); //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long area; //Значение поля должно быть больше 0
    private long numberOfRooms; //Значение поля должно быть больше 0
    private boolean New;
    private Furnish furnish; //Поле не может быть null
    private Transports transports; //Поле не может быть null
    private House house; //Поле не может быть null
    private User user;
    public static int count = 0;

    public Flat(int id, String name, Coordinates coordinates, LocalDate creationDate, Long area, long numberOfRooms, boolean New, Furnish furnish, Transports transports, House house) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.area = area;
        this.numberOfRooms = numberOfRooms;
        this.New = New;
        this.furnish = furnish;
        this.transports = transports;
        this.house = house;
    }

    public Flat() {
    }

    public int getId() {
        return id;
    }

    public void setId() {
        count += 1;
        this.id = count;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            System.out.println("Unknown flat № " + this.id);
        } else {
            this.name = name;
        }
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        if (coordinates == null) {
            this.coordinates = new Coordinates(0, 0D);
        } else {
            this.coordinates = coordinates;
        }
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        if (area <= 0 || area == null) {
            System.out.println("value must be positive");
        } else {
            this.area = area;
        }
    }

    public long getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(long numberOfRooms) {
        if (numberOfRooms <= 0) {
            System.out.println("value must be positive");
        } else {
            this.numberOfRooms = numberOfRooms;
        }
    }

    public boolean isNew() {
        return New;
    }

    public void setNew(boolean aNew) {
        New = aNew;
    }

    public Furnish getFurnish() {
        return furnish;
    }

    public void setFurnish(String string) {
        for (Furnish furnish1 : Furnish.values()) {
            if (string.toLowerCase().equals(furnish1)) {
                this.furnish = furnish1;
                break;
            } else {
                this.furnish = Furnish.NONE;
            }
        }
    }

    public Transports getTransport() {
        return transports;
    }

    public void setTransport(String string) {
        for (Transports transport1 : Transports.values()) {
            if (string.toLowerCase().equals(transport1)) {
                this.transports = transport1;
                break;
            } else {
                this.transports = Transports.NONE;
            }
        }
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        if (house == null) {
            this.house = new House(null, null, null);
        } else {
            this.house = house;
        }
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        String stringline = "---".repeat(15);
        return "\n" + stringline + "\n"
                + "Flat: " + name + "\n"
                + "Username" + user + "\n"
                + "Id: " + id + "\n"
                + "coordinates: " + coordinates + "\n"
                + "creation date: " + creationDate + "\n"
                + "area: " + area + "\n"
                + "numbers of rooms: " + numberOfRooms + "\n"
                + "new: " + New + "\n"
                + "furnish: " + furnish + "\n"
                + "transport: " + transports + "\n"
                + "house: " + house;
    }

    public User getUserName() {
        return user;
    }

    public void setIdWithParametrs(int id) {
        this.id = id;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public String getUser() {
        return user.getNameUser();
    }
    public void setFurnish(Furnish furnish) {
        this.furnish = furnish;
    }

    public void setTransports(Transports transports) {
        this.transports = transports;
    }
    public static void setCount(int count) {
        Flat.count = count;
    }

    public Transports getTransports() {
        return transports;
    }

    public static int getCount() {
        return count;
    }
//    public void setCreationDate(LocalDate creationDate) {
//        this.creationDate = creationDate;
//    }
}


