package org.example;

import java.util.OptionalInt;

import static java.lang.Integer.MIN_VALUE;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = MIN_VALUE;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.address = null;
    }

    public Person(String name, String surname, Integer age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return this.age == MIN_VALUE;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return (hasAddress() ? address : "БОМЖ");
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        } else {
            age = 1;
        }
    }

    @Override
    public String toString() {

        return "Person{" +
                "\n\tname = " + name +
                "\n\tsurname = " + surname +
                "\n\tage = " + (hasAge() ? age : "возраст не определен") +
                "\n\taddress = " + getAddress() +
                "\n\t" + '}';
    }

    @Override
    public int hashCode() {
        int hash = 4;
        hash = 23 * hash + (name == null ? 0 : name.hashCode());
        hash = 23 * hash + surname.hashCode();
        hash = 23 * hash + age;
        hash = 23 * hash + (address == null ? 0 : address.hashCode());
        return hash;
    }

    public PersonBuilder newChildBuilder() {

        return new PersonBuilder().setSurname(this.surname).setAge(0).setAddress(this.address);
    }


}