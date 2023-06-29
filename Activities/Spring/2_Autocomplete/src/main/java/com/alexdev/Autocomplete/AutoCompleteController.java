package com.alexdev.Autocomplete;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AutoCompleteController {
    //Almacenamos las busquedas en una variable global, para utilizar en el endpoint.
    String[] searches = availableSearches();

    /**
     *  Este metodo 'buscara' todas las ocurrencias que el usuario intente buscar.
     * @param search palabra a buscar.
     * @return Una lista de posibles resultados.
     */
    @GetMapping("/api/search/{search}")
    public List<String> searching(@PathVariable String search){
        return Arrays.stream(searches).filter(s -> s.contains(search)).toList();
    }

    /**
     *  Este metodo creara una arreglo de busquedas
     *  disponibles, lo cual servira para filtrar aquello
     *  que el usuario busca.
     * @return Arreglo de String.
     */
    static String[] availableSearches(){
        return new String[]{
                "Bootcamp ATL",
                "Curso de SpringBoot - ATL Academy",
                "Aprende Java (Nivel Principiante)",
                "Como convertirse en Java Developer",
                "Ruta backend Java",
                "Ruta backend cualquier lenguaje",
                "Pasar de trainee a junior",
                "Niveles de seniority en IT",
                "Programacion Orientada a Objetos",
                "Aprende SQL gratis"
        };
    }
}
