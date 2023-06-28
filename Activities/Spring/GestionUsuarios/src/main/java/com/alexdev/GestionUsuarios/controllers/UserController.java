package com.alexdev.GestionUsuarios.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/api/usuarios")
    public String listUsers(){
        return "[\n"+
                "{\n" +
                "    \"id\": 1,\n" +
                "    \"nombre\": \"Alex\",\n" +
                "    \"apellido\" : \"Lopez\",\n" +
                "    \"telefono\" : \"234323342\",\n" +
                "    \"email\": \"alexxxd23@gmail.com\"\n" +
                "  },\n" +
                "    {\n" +
                "    \"id\": 1,\n" +
                "    \"nombre\": \"Alex\",\n" +
                "    \"apellido\" : \"Lopez\",\n" +
                "    \"telefono\" : \"234323342\",\n" +
                "    \"email\": \"alexxxd23@gmail.com\"\n" +
                "  }\n]";
    }
}
