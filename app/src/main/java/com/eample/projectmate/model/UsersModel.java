package com.eample.projectmate.model;

import java.util.List;

public class UsersModel {

    private String id;
    private String name;
    private String university;
    private List<String> interests;

    public UsersModel() {
    }

    public UsersModel(String id, String name, String university) {
        this.id = id;
        this.name = name;
        this.university = university;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
}
