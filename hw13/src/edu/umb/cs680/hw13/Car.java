package edu.umb.cs680.hw13;

public class Car {
    private String make, model;
    private int mileage, year;
    private float price;

    private int dominationCount = 0;

    public Car(String make, String model, int mileage, int year, float price) {
        this.make = make;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public float getPrice() {
        return price;
    }

    public int getMileage() {
        return mileage;
    }

    public int getYear() {
        return year;
    }

    public void setDominationCount(int count) { this.dominationCount = count; }

    public int getDominationCount() { return this.dominationCount; }

    public boolean isDominatedBy(Car c2) {
        if (c2.getMileage() <= this.getMileage() && c2.getYear() >= this.getYear() && c2.getPrice() <= this.getPrice()) {
            if (!(c2.getPrice() == this.getPrice() && c2.getMileage() == this.getMileage() && this.getPrice() == this.getPrice())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

}