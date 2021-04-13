package animals;

public class Bat extends Mammal {

	public Bat() {
		this.energyLevel = 300;
	}

	public void fly() {
		System.out.println("*Bat flying*");
		this.energyLevel -= 50;
	}
	
	public void eatHumans() {
		System.out.println("The bat ate a human");
		this.energyLevel += 25;
		
	}
	
	public void attackTown() {
		System.out.println("The bat is attacking the city");
		this.energyLevel -= 100;
	}
} 
