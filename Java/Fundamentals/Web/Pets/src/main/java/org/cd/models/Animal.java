package org.cd.models;

public abstract class Animal {
	String name;
	String breed;
	int weight;
	
	public Animal() {
		
	}
	
	public Animal(String name, String breed, int weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}
}
