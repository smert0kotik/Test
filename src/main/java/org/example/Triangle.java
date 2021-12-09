package org.example;

import java.util.Scanner;

public class Triangle {

    private static Triangle t;
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) throws IllegalArgumentException {
        isTriangle(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public double square() {
        return Triangle.getSquare(this);
    }

    public static double getSquare(Triangle t) {
        double s = (t.a + t.b + t.c)/2.0;
        return Math.sqrt(s * (s - t.a) * (s - t.b) * (s - t.c));

    }
    public static Triangle createFromInput() throws IllegalArgumentException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину стороны А: ");
        int a = in.nextInt();

        System.out.println("Введите длину стороны B: ");
        int b = in.nextInt();

        System.out.println("Введите длину стороны C: ");
        int c = in.nextInt();

        return new Triangle(a, b, c);
    }

    private void isTriangle(int a, int b, int c) throws IllegalArgumentException {
        isNonNegativeSides(a,b,c);
        isSidesJoinable(a,b,c);
    }

    private void isSidesJoinable(int a, int b, int c) throws IllegalArgumentException {
        if(a + b > c && a + c > b && b + c > a) {
            return;
        }
        throw new IllegalArgumentException("Это не треугольник");
    }

    private void isNonNegativeSides(int a, int b, int c) {
        if(a > 0 && b > 0 && c > 0) {
            return;
        }
        throw new IllegalArgumentException("Значение стороны треугольника не может быть отрицательным");
    }
}
