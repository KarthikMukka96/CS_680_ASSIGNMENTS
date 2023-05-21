package edu.umb.cs680.hw10;

import java.util.Arrays;

public class Car {
	private String make, model;
	private int mileage, year;
	private float price;

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

}