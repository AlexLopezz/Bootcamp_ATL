package com.alexdev.GestionUsuarios.controllers;

import com.alexdev.GestionUsuarios.models.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    //Lista de usuarios para practicar CRUD.
    List<Usuario> usuarios = loadUsuarios();

    /**
     *  Este metodo se creo para mostrar todos los
     *  usuarios cargados en la lista improvisada para practicar CRUD.
     * @return lista de usuarios.
     */
    @GetMapping("/api/usuarios")
    public List<Usuario> listUsers(){
        return usuarios;
    }

    /**
     *  Este metodo agregara un nuevo usuario a la lista
     *  improvisada que se creo para para practicar CRUD.
     * @param user Que se puede crear desde el front o desde PostMAN.
     */
    @PostMapping("/api/usuarios")
    public void addUser(@RequestBody Usuario user){ //@RequestBody se utiliza para desearializar un JSON a Objeto.
        usuarios.add(user);
    }
    
    /**
     *  Este metodo se creo para eliminar un usuario(si es que existe)
     *  de la lista improvisada creada para practicar CRUD.
     * @param id del usuario a eliminar.
     */
    @DeleteMapping("/api/usuarios/{id}")
    public void deleteUser(@PathVariable int id){
        Optional<Usuario> usuarioEncontrado = findUser(id);

        usuarioEncontrado.ifPresent(usuario -> usuarios.remove(usuario));
    }

    /**
     *  Este metodo se creo para modificar un usuario ya existente en la
     *  lista improvisada para practicar CRUD.
     * @param usuario Que se modificara.
     */
    @PutMapping("/api/usuarios")
    public void modifyUser(@RequestBody Usuario usuario){
            if(findUser(usuario).isPresent()) {
                Usuario usuarioEncontrado = findUser(usuario).get();
                int indexUser = usuarios.indexOf(usuarioEncontrado);
                usuarios.set(indexUser, usuarioEncontrado);
            }
    }
    /**
     *  Este metodo cargara una lista improvisada con datos de
     *  usuarios para practicar CRUD.
     * @return Lista de usuarios.
     */
    private List<Usuario> loadUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(
                new Usuario(
                        1,
                        "Alex",
                        "Lopez",
                        "435434523",
                        "asdasd@gmail.com")
        );
        usuarios.add(
                new Usuario(2,
                        "Walter",
                        "Samuel",
                        "435434523",
                        "asdasd@gmail.com")
        );
        usuarios.add(
                new Usuario(3,
                        "Andrea",
                        "Bermudez",
                        "435434523",
                        "asdasd@gmail.com")
        );

        return usuarios;
    }

    /**
     *  Este metodo retornara un usuario(si es que existe)
     *  mediante el ID del mismo.
     * @param id de usuario
     * @return Optional<Usuario/>
     */
    private Optional<Usuario> findUser(int id) {
        return usuarios
                .stream().
                filter(u -> u.getId() == id).
                findFirst();
    }

    /**
     *  Este metodo es una sobrecarga del anterior, por lo que
     *  ahora encontrara un usuario(o no) mediante un objeto Usuario.
     * @param usuario A encontrar
     * @return  Optional<Usuario/>
     */
    private Optional<Usuario> findUser(Usuario usuario){
        return usuarios.stream().filter(u -> u.equals(usuario)).findFirst();
    }


    /* DOC:
    @RequestBody - https://springframework.guru/requestbody-annotation/
    @PathVariable - https://www.baeldung.com/spring-pathvariable
     */

}
