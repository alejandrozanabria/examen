package com.baufest.examen.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.baufest.examen.dto.Contract;
import com.baufest.examen.dto.Person;
import com.baufest.examen.dto.Response;
import com.baufest.examen.model.Persona;
import com.baufest.examen.repo.PersonaRepo;
import com.baufest.examen.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
    

    private static List<Person> personas;
    
    @Autowired
    private PersonaRepo personasRepo;
    
    static {
        personas = new ArrayList<>();
        personas.add(getPerson1());
        personas.add(getPerson2());
    }
    

    @Override
    public List<Person> getPersons() {
        return personas;
    }

    @Override
    public List<Persona> getPersonas() {
        return personasRepo.findAll();
    }

    @Override
    public Person getPerson(int id) {
        for(Person p : personas) {
            if(p.getPersonId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Response addPerson(Person person) {
        Response response = new Response();
        response.setCode(HttpStatus.CREATED.ordinal());
        response.setMessage("Persona agregada correctamente");
        for(Person p : personas) {
            if(p.getPersonId() == person.getPersonId()) {
                response.setMessage("El idPersona es incorrecto");
                return response;
            }
        }
        personas.add(person);
        return response;
    }
    
    @Override
    public Response addPersona(Persona persona) {
        Response response = new Response();
        Persona personaSaved = personasRepo.save(persona);
        if(personaSaved.getIdPersona() > 0) {
            response.setCode(HttpStatus.CREATED.ordinal());
            response.setMessage("Persona agregada correctamente");
        }else {
            response.setCode(HttpStatus.BAD_REQUEST.ordinal());
            response.setMessage("Error al agregar persona");            
        }
        return response;
    }
    
    
    private static Person getPerson1() {
        List<Contract> contracts = new ArrayList<>();
        Contract c1 = new Contract();
        c1.setCompany("Matrix");
        c1.setContractNumber("000001");
        contracts.add(c1);
        Person p1 = new Person();
        p1.setPersonId(1);
        p1.setName("Neo");
        p1.setLastName("");
        p1.setPersonType("F");
        p1.setContracts(contracts);
        return p1;
    }
    

    
    private static Person getPerson2() {
        List<Contract> contracts = new ArrayList<>();
        Contract c1 = new Contract();
        c1.setCompany("Matrix");
        c1.setContractNumber("000002");
        contracts.add(c1);
        Contract c2 = new Contract();
        c2.setCompany("Matrix 2");
        c2.setContractNumber("000003");
        contracts.add(c2);
        Person p1 = new Person();
        p1.setPersonId(2);
        p1.setName("Triniti");
        p1.setLastName("");
        p1.setPersonType("F");
        p1.setContracts(contracts);
        return p1;
    }

}
