package com.company;

public class mainclass {
    public static double function1(){
        double r;
        r = ((double) (Math.random()*18)-8);
        return r;
    }
    public static void main(String[] args) {
        int[] a;
        a = new int[10];
        int h = 0;
        for (int i = 17; i >= 5; i--) {
            if (i % 2 != 0) {
                a[h] = i;
                System.out.println("Нечетное число в диапозоне от 5 до 17 =" + a[h]);
                h++;
            }
        }
        double x[];
        x = new double[20];
        for (int i = 0; i < 20; i++) {
            x[i] = function1();
            System.out.println("Случайные числа типа double в диапозоне от -8.0 до 10.0 = " + x[i]);
        }

        double c[][] = new double[7][20];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 20; j++) {
                double z = x[j];
                if (i == 15) {
                    c[i][j] = Math.acos(Math.pow(Math.E, Math.abs(-z))) / 2f;
                } else if (i == 5 || i == 7 || i == 11) {
                    c[i][j] = Math.pow(Math.pow(Math.cbrt(z) / Math.pow(z, z + 1 / z) + 1, 2), 2 * Math.log(Math.pow(Math.cos(z), 2)));
                } else {
                    c[i][j] = Math.tan(Math.atan(Math.sin(Math.cbrt(Math.pow((((z + 2) / 2) / 3), 3)))));
                    //c[i][j] = Math.tan(Math.atan(Math.sin(Math.cbrt(Math.pow(((z + 2) / 2) / 3, 3)))));
                }
            }
        }
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(" Число = ");
                System.out.printf("%.2f", c[i][j]);
            }
            System.out.println();
        }
        char x2 = '2';
        char x3 = 'b';
        int x4;
        x4=x2;
        System.out.println(x4);
    }
}
