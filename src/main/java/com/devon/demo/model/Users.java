package com.devon.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.mapping.Table;

import javax.persistence.Entity;
import java.util.UUID;

/**
 * Created by diwenlao on 5/11/17.
 */
@Entity
@Table(value = "users")
public class Users {
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    public Users(String firstName, String lastName, int age) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Id
    private UUID id;

    private String firstName;
    private String lastName;
    private int age;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
