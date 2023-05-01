package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class PersonBuilderTest {
    PersonBuilder personBuilder = new PersonBuilder();

    @Test
    void setName() {
        personBuilder.setName("Дартаньян");
        String expected = "Дартаньян";
        Assertions.assertEquals(expected, personBuilder.name);
    }

    @Test
    void setSurname() {
        personBuilder.setSurname("Велостер");
        String expected = "Велостер";
        Assertions.assertEquals(expected, personBuilder.surname);
    }

    @Test
    void setAge() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> personBuilder.setAge(-20));
        personBuilder.setAge(15);
        int expected = 15;
        Assertions.assertEquals(expected, personBuilder.age);
    }

    @Test
    void setAddress() {
        personBuilder.setAddress("Зимбабве");
        String expected = "Зимбабве";
        Assertions.assertEquals(expected, personBuilder.address);
    }

    @Test
    void build() {
        Assertions.assertThrows(IllegalStateException.class,
                () -> personBuilder.build());
    }
}