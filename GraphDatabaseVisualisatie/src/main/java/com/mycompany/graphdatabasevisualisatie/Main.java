/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graphdatabasevisualisatie;

import java.util.ArrayList;
import processing.core.PApplet;

/**
 *
 * @author Roy van den Heuvel
 */
public class Main extends PApplet {

    static int windowSize = 900;
    static ArrayList<Person> people;

    public static void main(String[] args) {
        Parser p = new Parser();

        people = decideLocations(p.people);

        PApplet.main(new String[]{Main.class.getName()});

    }

    private static ArrayList<Person> decideLocations(ArrayList<Person> people) {
        double squaredAsDouble = Math.sqrt(people.size());
        int squared = (int) Math.ceil(squaredAsDouble);
        ArrayList<Person> peopleWithCoordinates = new ArrayList();

        int k = 0;

        for (int i = 0; i < squared; i++) {
            for (int j = 0; j < squared; j++) {
                if (k < people.size()) {

                    int mappedX = (int) map(i % squared, 0, squared, 100, windowSize - 100);
                    int mappedY = (int) map(j % squared, 0, squared, 100, windowSize - 100);

                    int[] coordinates = new int[2];
                    coordinates[1] = mappedX;
                    coordinates[0] = mappedY;

                    Person p = people.get(k);

                    p.setCoordinatesOnScreen(coordinates);
                    peopleWithCoordinates.add(p);
                }
                k++;
            }
            k++;
        }

        return peopleWithCoordinates;

    }

    @Override
    public void setup() {
        size(windowSize, windowSize);
        people.stream().forEach((p) -> {
            fill(color(255));
            ellipse(p.getCoordinatesOnScreen()[0], p.getCoordinatesOnScreen()[1], 125, 125);
            drawMiscInformation(p);
            drawConnections(p);
        });
    }

    public void drawMiscInformation(Person p) {
        fill(color(0));
        text(p.getFirstName() + " " + p.getLastName(), p.getCoordinatesOnScreen()[0] - 30, p.getCoordinatesOnScreen()[1] - 25);
        text("Gender: " + p.getGender(), p.getCoordinatesOnScreen()[0] - 30, p.getCoordinatesOnScreen()[1] - 10);
        try {
            text("Age: " + (int) p.getAge(), p.getCoordinatesOnScreen()[0] - 30, p.getCoordinatesOnScreen()[1] + 5);
        } catch (ClassCastException e) {
            System.out.println("Person in JSON file did not have an age.");
        }
    }

    public void drawConnections(Person p) {

        ArrayList<Integer> friends = p.getFriends();
        for (int i = 0; i < friends.size(); i++) {
            for (Person per : people) {
                if (per.getId() == friends.get(i)) {
                    fill(color(255));
                    line(p.getCoordinatesOnScreen()[0], p.getCoordinatesOnScreen()[1], per.getCoordinatesOnScreen()[0], per.getCoordinatesOnScreen()[1]);
                }
            }

        }
    }

}
