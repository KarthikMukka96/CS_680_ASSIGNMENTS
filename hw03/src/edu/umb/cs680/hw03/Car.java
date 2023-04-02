package edu.umb.cs680.hw03;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;

    public Car(String make, String model, int year, int mileage, float price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public int getMileage() {
        return mileage;
    }

    public float getPrice() {
        return price;
    }

    public int getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }


    public static void main(String[] args) {
        Car car1 = new Car("Dodge", "model", 2010, 20000, 70000f);
        System.out.println("Car object created.");
    }
}