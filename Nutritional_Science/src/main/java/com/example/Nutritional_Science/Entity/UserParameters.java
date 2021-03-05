package com.example.Nutritional_Science.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class UserParameters {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne(mappedBy = "userParameters",cascade = CascadeType.ALL)
    private User user;

    @NotNull
    private int height;

    @NotNull
    private int weight;

    @NotNull
    private int age;

    @NotNull
    private boolean isMan;

    @NotNull
    private double activity;

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public void setActivity(double activity) {
        this.activity = activity;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public boolean isMan() {
        return isMan;
    }

    public double getActivity() {
        return activity;
    }
}
