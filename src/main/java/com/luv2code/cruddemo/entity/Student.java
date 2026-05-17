package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student") //map to this table not needed here as table name is same(lowercase) of class name
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //no need for id  name or even the decorator
    private int id;

    @Column(name = "first_name")//since naming is diff even though, it is snake of pascal, it is safe to write it explicitly
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

//    @Column //no need same as the field name but not recommended
    private String email;

    //define no-argument constructor(though optional as java will create one for any class who doesn't have a constructor
    //but compulsorily a constructor must be defined for java class
//    Always include a no-arg constructor (at least protected/public)
    public Student(){

    }
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //define getters and setters

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
//in defaults fields are nullable
