package models;

import java.util.Arrays;
import java.util.Scanner;

public class Triangle extends RegularPolygon{
    private final double[] sides;

    public Triangle() {
        this.sides = new double[3];
    }
    public Triangle(double base, double height, double[] sides) {
        super(base, height);
        this.sides = sides;
    }

    @Override
    public double getArea() {
        return (base * height) / 2;
    }

    @Override
    public double getPerimeter() {
        return Arrays.stream(sides).sum();
    }

    @Override
    public void fillData() {
        var readInput = new Scanner(System.in);
        for(int i= 0; i < 3; i++){
            System.out.printf("--> Ingrese el valor del lado %s: ", (i+1));
            this.sides[i] = Integer.parseInt(readInput.next());
        }
        System.out.print("--> Ingrese la base del triangulo: ");
        this.base = Double.parseDouble(readInput.next());
        System.out.print("--> Ingrese la altura del triangulo: ");
        this.height = Double.parseDouble(readInput.next());
    }
}
