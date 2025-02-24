package com.mycompany.prac2;

import com.github.javafaker.Faker;
import java.util.ArrayList;

public class DataGenerator {

    public static void generator(int number) {
        Faker faker = new Faker();
        for(int i = 0; i < number; i++){
            String name = faker.name().fullName();
            String lastSeenLocation = faker.address().cityName();
            String threatLevel = faker.book().title();
            String crimes = faker.chuckNorris().fact();
            String id = faker.idNumber().invalid();
            Heretic example = new Heretic(name, crimes, lastSeenLocation, id, threatLevel);
            example.addToList(example);
        }
        Heretic.printList();
    }
}
