import java.time.LocalDate;

public class Persona {
    private int id;
    private String nombre;
    private int edad;
    private LocalDate fechaNacimiento;
    private int DNI;

    public Persona(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void mostrarDatos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad : " + edad);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("DNI: " + DNI);
    }
    public boolean esMayorDeEdad(){
        return edad>=18;
    }
}
