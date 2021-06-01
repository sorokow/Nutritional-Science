package com.example.Nutritional_Science.Entity;

import javax.persistence.*;

@Entity
@Table (name="food_menu")
public class FoodMenu {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(nullable = false)
    private Long foodMenuId;

    private String foodType;

    private int numberDayWeek;

    private String name;

    private int quantity;

    private int calories;

    public FoodMenu() {
    }

    public FoodMenu(String foodType, int numberDayWeek, String name, int quantity, int calories) {
        this.foodType = foodType;
        this.numberDayWeek = numberDayWeek;
        this.name = name;
        this.quantity = quantity;
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Long getFoodMenuId() {
        return foodMenuId;
    }

    public void setFoodMenuId(Long foodMenuId) {
        this.foodMenuId = foodMenuId;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public int getNumberDayWeek() {
        return numberDayWeek;
    }

    public void setNumberDayWeek(int numberDayWeek) {
        this.numberDayWeek = numberDayWeek;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
