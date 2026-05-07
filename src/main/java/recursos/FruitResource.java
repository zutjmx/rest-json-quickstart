package recursos;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import com.github.javafaker.Faker;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import models.Fruit;

@Path("/fruits")
public class FruitResource {
    private Set<Fruit> fruits = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));
    private Faker faker = new Faker();

    public FruitResource() {

        for (int i = 0; i < 5; i++) {
            fruits.add(new Fruit(faker.food().fruit(), faker.lorem().sentence()));
        }

        // fruits.add(new Fruit("Apple", "Winter fruit"));
        // fruits.add(new Fruit("Pineapple", "Tropical fruit"));
    }

    @GET
    public Set<Fruit> list() {
        return fruits;
    }

    @POST
    public Set<Fruit> add(Fruit fruit) {
        fruits.add(fruit);
        return fruits;
    }

    @DELETE
    public Set<Fruit> delete(Fruit fruit) {
        fruits.removeIf(existingFruit -> existingFruit.name.contentEquals(fruit.name));
        return fruits;
    }
}
