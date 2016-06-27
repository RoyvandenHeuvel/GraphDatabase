package com.mycompany.graphdatabasevisualisatie;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roy van den Heuvel & Joey van Venrooij
 */
public class Person {

    private String firstName;
    private String lastName;
    private String gender;
    private int id;
    private Object age;
    private ArrayList<Integer> friends;
    private int[] coordinatesOnScreen;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Object getAge() {
        return age;
    }

    public void setAge(Object age) {
        this.age = age;
    }

    public List<Integer> getFriends() {
        return friends;
    }

    public void setFriends(List<Integer> friends) {
        this.friends = (ArrayList) friends;
    }

    public int[] getCoordinatesOnScreen() {
        return coordinatesOnScreen;
    }

    public void setCoordinatesOnScreen(int[] coordinatesOnScreen) {
        this.coordinatesOnScreen = coordinatesOnScreen;
    }

}
