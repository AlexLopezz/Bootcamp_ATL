package models;

public abstract class Figure {
    public abstract double getArea();
    public abstract void fillData();
    public abstract double getPerimeter();
    public void showAreaAndPerimeter(){
        System.out.printf("-> El area es de: %.2f\n", getArea());
        System.out.printf("-> El perimetro es de: %.2f\n", getPerimeter());
    }
}
