package com.phonebook.models;

public class Contact {
    private String name,  lastName,
     phone,  email,
     city,  description;

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    Contact(){}

    public Contact(String name, String lastName, String phone, String email, String city, String description) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.city = city;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Contact setCity(String city) {
        this.city = city;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Contact setDescription(String description) {
        this.description = description;
        return this;
    }
}