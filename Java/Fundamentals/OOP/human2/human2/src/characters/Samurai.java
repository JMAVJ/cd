package characters;

public class Samurai extends Human {
	private static int instanceCounter;
	
	public Samurai() {
		this.setHealth(200);
		instanceCounter++;
	}

	public void deathBlow(Human target) {
		target.setHealth(0);
		this.setHealth(this.getHealth()/2);
	}
	
	public void meditate() {
		this.setHealth(this.getHealth() + this.getHealth()/2);
	}
	
	public static int howMany() {
		return instanceCounter;
	}
}