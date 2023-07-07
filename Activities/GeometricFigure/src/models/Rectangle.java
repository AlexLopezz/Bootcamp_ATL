package models;

import java.util.Scanner;

public class Rectangle extends RegularPolygon{
    public Rectangle() {
    }

    public Rectangle(double base, double height) {
        super(base, height);
    }

    @Override
    public double getArea() {
        return base * height;
    }

    @Override
    public double getPerimeter() {
        return Math.pow(base,2) + Math.pow(height,2);
    }

    @Override
    public void fillData() {
        var readInput = new Scanner(System.in);
        System.out.print("--> Ingrese la base del triangulo: ");
        this.base = Double.parseDouble(readInput.next());
        System.out.print("--> Ingrese la altura del triangulo: ");
        this.height = Double.parseDouble(readInput.next());
    }
}
