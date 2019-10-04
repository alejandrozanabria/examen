package com.baufest.examen.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.baufest.examen.model.Persona;

@Repository
public interface PersonaRepo extends CrudRepository<Persona, String> {
    
    @Qualifier("ds1")
    List<Persona> findAll();

}
