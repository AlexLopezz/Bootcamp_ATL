package com.alexdev.newsletters.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "leads")
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;

    public Lead(String email) {
        this.email = email;
    }

    public Lead() {
    }
}
