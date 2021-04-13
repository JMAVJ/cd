package animals;

public class Mammal {
	int energyLevel;

	public Mammal() {
		this.energyLevel = 10;
	}

	public int displayEnergy() {
		System.out.println(this.energyLevel);
		return this.energyLevel;
	}
}
