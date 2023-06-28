package com.alexdev.trivia.models;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {
    private String categoria;
    private String pregunta, explicacion;
    private String[] opciones;
    private int respuesta;

    public Pregunta(String categoria, String pregunta, String explicacion, String[] opciones, int respuesta) {
        this.categoria = categoria;
        this.pregunta = pregunta;
        this.explicacion = explicacion;
        this.opciones = opciones;
        this.respuesta = respuesta;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }
}
