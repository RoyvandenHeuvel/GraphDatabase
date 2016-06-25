/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.graphdatabasevisualisatie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Roy van den Heuvel
 */
public class Parser {

    public ArrayList<Person> people;

    public Parser() {

        JSONArray arr;
        String json = "";
        try {
            String socialDataJson = "social_graph.json";
            try (BufferedReader br = new BufferedReader(new FileReader(socialDataJson))) {
                String line;
                while ((line = br.readLine()) != null) {
                    json += line;
                }
            }

            arr = new JSONArray(json);

            people = jsonArrayToPersonArrayList(arr);

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Person> jsonArrayToPersonArrayList(JSONArray arr) {
        ArrayList<Person> people = new ArrayList();

        for (Object obj : arr) {
            JSONObject jsonObj = (JSONObject) obj;

            int id = (int) jsonObj.get("id");
            String fName = (String) jsonObj.get("firstName");
            String sName = (String) jsonObj.getString("surname");

            Object age = jsonObj.get("age");

            String gender = (String) jsonObj.get("gender");
            JSONArray friends = (JSONArray) jsonObj.get("friends");
            ArrayList<Integer> friendsArrayList = new ArrayList();
            for (int i = 0; i < friends.length(); i++) {
                friendsArrayList.add(friends.getInt(i));
            }

            Person p = new Person();
            p.setAge(age);
            p.setFirstName(fName);
            p.setFriends(friendsArrayList);
            p.setGender(gender);
            p.setId(id);
            p.setLastName(sName);

            people.add(p);

        }

        return people;

    }

}
