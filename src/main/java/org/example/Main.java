package org.example;

public class Main {
    public static void main(String[] Args) {
        try {
            Triangle triangle = Triangle.createFromInput();
            System.out.print(triangle.square());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
