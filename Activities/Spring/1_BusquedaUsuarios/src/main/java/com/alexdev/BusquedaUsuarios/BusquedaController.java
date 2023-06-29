package com.alexdev.BusquedaUsuarios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class BusquedaController {
    // Almacenamos los nombres completos en un array.
    String[] names = loadNames();

    /**
     *  Este metodo buscara en el arreglo de String creado
     *  el nombre que busca el usuario.
     * @param name del usuario a buscar
     * @return el nombre del usuario, o avisa si no es encuentra.
     */
    @GetMapping("/api/usuarios/{name}")
    public Map<String, String> searchName(@PathVariable String name){
        Map<String, String> findName = new HashMap<>();
        Optional<String> nameUser = Arrays.stream(names).filter(n -> n.equals(name)).findFirst();
        findName.put("search", nameUser.orElse("No se encontraron resultados."));

        return findName;
    }

    /**
     *  Este metodo retornara un arreglo con nombres completos de personas
     *  que se utilizaran como fuente de busqueda.
     * @return arreglo de String.
     */
    static String[] loadNames(){
        return new String[]{
            "Jorge NewBerry",
            "Samanta Xander",
            "Gaona Lugo",
            "Jorge Esquivel",
            "Florencia Hernandez",
            "Lucas Moy",
            "Alexa Sanchez",
            "Trinidad Frutos",
            "Facundo Iglesias",
            "Jorgelina Bermudez"
        };
    }
}
