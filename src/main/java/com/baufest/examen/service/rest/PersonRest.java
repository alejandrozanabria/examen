package com.baufest.examen.service.rest;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baufest.examen.dto.Greeting;
import com.baufest.examen.dto.Person;
import com.baufest.examen.dto.Response;
import com.baufest.examen.model.Persona;
import com.baufest.examen.service.PersonService;

@RestController(value = "/rest")
public class PersonRest {
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private PersonService personService;
    

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
	
	@GetMapping(value="/persons", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getPersons() {
        System.out.println("Entro en getPersons ");
        return personService.getPersons();
    }
	

	@RequestMapping(value = "/persistPerson", method = RequestMethod.POST)
    public Response persistPerson(@RequestBody Person person) {
	    System.out.println("Entro en persistPerson " + person);
        return personService.addPerson(person);
    }
    
    @GetMapping(value="/personas", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Persona> getPersonas() {
        System.out.println("Entro en getPersonas ");
        return personService.getPersonas();
    }

    @RequestMapping(value = "/persistPersona", method = RequestMethod.POST)
    public Response persistPersona(@RequestBody Persona persona) {
        System.out.println("Entro en persistPersona " + persona);
        return personService.addPersona(persona);
    }

}
