package com.solvd.people;

import com.solvd.airport.FoodCourt;
import com.solvd.interfaces.IEat;

import java.lang.invoke.MethodHandles;
import java.time.LocalDate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Person implements IEat {

    private static final Logger LOGGER = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private LocalDate bday;
    private String name;
    private String sex;

    public Person(LocalDate bday, String name, String sex) {
        this.bday = bday;
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public LocalDate getMyDate() {
        return bday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setMyDate(LocalDate date) {
        bday = date;
    }

    @Override
    public void eat(FoodCourt foodCourt) {
        LOGGER.info("I ate:" + foodCourt.getFoodType() + "from:" + foodCourt.getRestaurantName() + "it cost: " + foodCourt.getPrice());
    }

    @Override
    public String toString() {
        return "Person: [Name: " + name + ", bday: " + bday + ", Sex: " + sex + "]";
    }
}