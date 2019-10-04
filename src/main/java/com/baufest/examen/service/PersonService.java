package com.baufest.examen.service;

import java.util.List;

import com.baufest.examen.dto.Person;
import com.baufest.examen.dto.Response;
import com.baufest.examen.model.Persona;

public interface PersonService {
    
    List<Person> getPersons();
    
    List<Persona> getPersonas();

    Person getPerson(int id);
    
    Response addPerson(Person person);
    
    Response addPersona(Persona persona);

}
