package Excercise1.models;

public class Cuenta {
    private Persona titular;
    private double cantidad;

    public Cuenta() {
    }

    public Cuenta(Persona titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }

    public Persona getTitular() {
        return titular;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    private void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void mostrar(){
        System.out.println("Titular: "+ getTitular().getNombre()+
                "\nCantidad: $"+ getCantidad());
    }

    public void ingresar(double cantidad){
        if(cantidad > 0){
            cantidad += this.getCantidad();
            setCantidad(cantidad);
        }
    }

    public void retirar(double cantidad){
        var cantidadRestar = this.getCantidad() - cantidad;
        setCantidad(cantidadRestar);
    }

}
