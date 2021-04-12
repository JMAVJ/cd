package animals;

public class Gorilla extends Mammal {
	public void throwSomething() {
		System.out.println("The gorilla threw something");
		this.energyLevel -= 5;
	}

	public void eatBananas() {
		System.out.println("The gorilla ate bananas");
		this.energyLevel += 10;
	}

	public void climb() {
		System.out.println("The gorilla climbed a tree");
		this.energyLevel -= 10;
	}
}