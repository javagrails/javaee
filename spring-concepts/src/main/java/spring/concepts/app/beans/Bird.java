package spring.concepts.app.beans;

import spring.concepts.app.di.Food;

public class Bird {
    private int id;
    private String name;
    private String zone;

    private Food food;

    public Bird() {
    }

    public Bird(int id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", zone='" + zone + '\'' +
                ", food=" + food +
                '}';
    }

    public void onCreateBean() {
        System.out.println("onCreateBean:Bird Created : " + this);
    }

    public void onDestroyBean() {
        System.out.println("onDestroyBean:Bird Destroyed");
    }


    public void sing() {
        System.out.println("Singing a Song");;
    }
}
