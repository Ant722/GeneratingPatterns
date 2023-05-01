package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person = new PersonBuilder()
            .setName("Август")
            .setSurname("Гельяро")
            .build();

    @Test
    void hasAge() {
        Assertions.assertFalse(person.hasAge());

    }

    @Test
    void hasAddress() {
        Assertions.assertFalse(person.hasAddress());
    }

    @Test
    void getName() {
        String expected = "Август";
        Assertions.assertEquals(expected, person.getName());
    }

    @Test
    void getSurname() {
        String expected = "Гельяро";
        Assertions.assertEquals(expected, person.getSurname());
    }

    @Test
    void getAge() {
        Person person1 = new PersonBuilder()
                .setName("Ахил")
                .setAge(3)
                .setSurname("Сынпелея")
                .build();
        int expected = 3;
        OptionalInt actualO = person1.getAge();
        int actual = actualO.getAsInt();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void getAddress() {
        Person person2 = new PersonBuilder()
                .setAddress("Чалтырь")
                .setName("Ахил")
                .setAge(3)
                .setSurname("Сынпелея")
                .build();
        String expected = "Чалтырь";
        String actual = person2.getAddress();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void setAddress() {
        person.setAddress("Тагил");
        String expected = "Тагил";
        String actual = person.address;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void happyBirthday() {
        person.happyBirthday();
        int expected = 1;
        Assertions.assertEquals(expected, person.age);
    }

    @Test
    void testToString() {
        String expected = "Person{" +
                "\n\tname = Август" +
                "\n\tsurname = Гельяро" +
                "\n\tage = возраст не определен" +
                "\n\taddress = БОМЖ" +
                "\n\t" + '}';

        String actual = person.toString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testHashCode() {
        int expected = -1054107965;
        int actual = person.hashCode();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void newChildBuilder() {
    }
}