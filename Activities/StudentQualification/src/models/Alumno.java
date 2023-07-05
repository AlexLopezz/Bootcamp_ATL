package models;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private String name,
                   lastName;
    private List<Double> qualifications;

    public Alumno() {
        qualifications = new ArrayList<>();
    }

    public Alumno(String name, String lastName, List<Double> qualifications) {
        this.name = name;
        this.lastName = lastName;
        this.qualifications = qualifications;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Double> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Double> qualifications) {
        this.qualifications = qualifications;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        int countQualifications = 0;
        sb.append("-> Alumno: ").append(name).append(" ").append(lastName).append("\n");
        sb.append("-> Calificaciones: ").append("\n");
        if(qualifications.size() > 0) {
            for (var q : qualifications) {
                countQualifications++;
                sb.append("\t*Nota N°").append(countQualifications).append(": ").append(q).append("\n");
            }
        }else{
            sb.append("X No tiene ninguna calificacion.");
        }
        sb.append("\n");
        return sb.toString();
    }
}
