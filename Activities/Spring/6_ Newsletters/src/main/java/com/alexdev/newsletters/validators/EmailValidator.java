package com.alexdev.newsletters.validators;

import lombok.Getter;
import lombok.Setter;

import java.util.regex.Pattern;

public class EmailValidator {
    @Getter @Setter
    private Pattern defaultPattern;

    public EmailValidator() {
        this.defaultPattern = Pattern.compile("([a-z]|[0-9])+@[a-z]+\\.[a-z]+");
    }

    public EmailValidator(String regex) {
        this.defaultPattern = Pattern.compile(regex); //Compilamos nuestro patron de validacion.
    }

    public boolean isValid(String email){
        return defaultPattern.matcher(email).matches(); //Retornamos true o false, dependiendo de si hay match o no.
    }
}
