package org.cd.models;

public class Dog extends Animal implements Pet {

	public Dog() {
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, String breed, int weight) {
		super(name, breed, weight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String showAffection() {
		// TODO Auto-generated method stub
		if (this.weight < 30) {
			return this.name + ": action for less than 30 lbs";
		}
		return this.name + ": action for 30 lbs or more";
	}

}
