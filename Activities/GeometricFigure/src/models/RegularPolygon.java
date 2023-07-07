package models;

import java.util.Scanner;

public abstract class RegularPolygon extends Figure{
    protected double base,
                     height;

    public RegularPolygon() {
    }

    public RegularPolygon(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }
}
