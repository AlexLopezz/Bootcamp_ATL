package models;

import java.util.Scanner;

public class Circle extends Figure{
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    public void fillData(){
        Scanner readInput = new Scanner(System.in);
        System.out.print("--> Ingrese por favor el radio del circulo: ");
        this.radius = Double.parseDouble(readInput.next());
    }
}
