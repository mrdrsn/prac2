package com.mycompany.prac2;

import com.github.javafaker.Faker;
import java.util.ArrayList;

public class DataGenerator {

    public static Heretic generator() {
        
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String lastSeenLocation = faker.address().cityName();
        String threatLevel = faker.book().title();
        String crimes = faker.chuckNorris().fact();
        String id = faker.idNumber().invalid();
        Heretic example = new Heretic(name, crimes, lastSeenLocation, id, threatLevel);
      
        return example;
    }
}
