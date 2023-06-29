package com.alexdev.GestionUsuarios.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

@Data @AllArgsConstructor
public class Usuario {
    private Integer id;

    private String nombre,
                   apellido,
                   telefono,
                   email;

    @Override
    public boolean equals(Object o) {
        if(o instanceof Usuario usuario) {
            return Objects.equals(id, usuario.id);
        }else{
            return false;
        }
    }
}
