package com.alexdev.newsletters.controller;

import com.alexdev.newsletters.models.Lead;
import com.alexdev.newsletters.repository.LeadRepository;
import com.alexdev.newsletters.validators.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewslettersController {
    @Autowired
    LeadRepository leadRepository;
    @GetMapping("api/newsletters")
    public List<Lead> getLeads(){
        return leadRepository.getLeads();
    }
    @PostMapping("api/newsletters")
    public String saveLead(@RequestBody Lead lead){
        EmailValidator ev = new EmailValidator();

        if(ev.isValid(lead.getEmail())){
            leadRepository.saveLead(lead);
            return "Usuario guardado con exito.";
        }else{
            return "Email no valido.";
        }
    }
    @DeleteMapping("api/newsletters/unsuscribe")
    public String deleteLead(@RequestBody Lead lead){
        if(leadRepository.deleteLead(lead)){
            return "¡Se desuscribio exitosamente!";
        }else {
            return "No se encuentra el lead especificado.";
        }
    }
}
