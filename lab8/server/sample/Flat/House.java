package sample.Flat;

import java.io.Serializable;

public class House implements Serializable {
    private static final long serialVersionUID = 566252501286294813L;
    private String name; //Поле может быть null
    private Integer year; //Значение поля должно быть больше 0
    private Long numberOfFlatsOnFloor; //Значение поля должно быть больше 0


    public House(String name, Integer year, Long numberOfFlatsOnFloor) {
        if(name == null || name.isBlank()){
            this.name = "Name № " + (Flat.count);
        }else{
            this.name = name;
        }
        if(year <= 0 || year == null){
            this.year = 1;
        }else{
            this.year = year;
        }
        if(numberOfFlatsOnFloor <= 0){
            this.numberOfFlatsOnFloor = 1L;
        }else{
            this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public long getNumberOfFlatsOnFloor() {
        return numberOfFlatsOnFloor;
    }

    public void setNumberOfFlatsOnFloor(Long numberOfFlatsOnFloor) {
        this.numberOfFlatsOnFloor = numberOfFlatsOnFloor;
    }

    @Override
    public String toString() {
        String tab = "  ".repeat(2);
        return  "\n"
                + tab + "name: " + name + "\n"
                + tab + "year: " + year + "\n"
                + tab + "number of flats on floor: " + numberOfFlatsOnFloor;
    }
}
