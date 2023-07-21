package com.alexdev.newsletters.repository;

import com.alexdev.newsletters.models.Lead;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class LeadRepository {
    @PersistenceContext
    EntityManager database;

    @Transactional
    public void saveLead(Lead lead){
        var querySQL = "INSERT INTO leads(email) VALUES(:email)";
        Query query = database.createNativeQuery(querySQL);
        query.setParameter("email", lead.getEmail());

        query.executeUpdate();
    }
    @Transactional
    public List<Lead> getLeads(){
        var querySQL = "SELECT * FROM leads";

        return database.createNativeQuery(querySQL, Lead.class).getResultList();
    }
    @Transactional
    public boolean deleteLead(Lead lead){
        var querySQL = "DELETE FROM leads WHERE id = :id";
        Query query = database.createNativeQuery(querySQL);
        query.setParameter("id", lead.getId());

        return query.executeUpdate() > 0;
    }

}
