package recursos;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import com.github.javafaker.Faker;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import models.Persona;


@Path("/personas")
public class PersonaResource {

    private Set<Persona> personas = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
    private Faker faker = new Faker();

    public PersonaResource() {
        for (int i = 0; i < 5; i++) {
            personas.add(new Persona(faker.name().fullName(), faker.number().numberBetween(1, 100)));
        }
    }

    @GET
    public Set<Persona> list() {
        return personas;
    }

}
