package Flat;

public class Coordinates {
    private double x;
    private Double y; //Значение поля должно быть больше -250, Поле не может быть null

    public Coordinates(double x, Double y) {
       if(y < -250){
           this.y = 0D;
       }else{
           this.y = y;
           this.x = x;
       }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
    @Override
    public String toString(){
        String tab = "    ".repeat(2);
        return "\n"
                + tab + "X: " + x + "\n"
                + tab + "Y: " + y;
    }
}
