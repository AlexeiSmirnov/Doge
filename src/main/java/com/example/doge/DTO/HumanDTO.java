package com.example.doge.DTO;

import com.example.doge.Model.Dog;

import java.util.Set;

public class HumanDTO {



    private int id;
    private String name;
    private int age;
    private Set<DogDTO> dogs;
    private int dogsCount;
    private double avarageDogsAge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<DogDTO> getDogs() {
        return dogs;
    }

    public void setDogs(Set<DogDTO> dogs) {
        this.dogs = dogs;
    }

    public int getDogsCount() {
        return dogsCount;
    }

    public void setDogsCount(int dogsCount) {
        this.dogsCount = dogsCount;
    }

    public double getAvarageDogsAge() {
        return avarageDogsAge;
    }

    public void setAvarageDogsAge(double avarageDogsAge) {
        this.avarageDogsAge = avarageDogsAge;
    }
}
