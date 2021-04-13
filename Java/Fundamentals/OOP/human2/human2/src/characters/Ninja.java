package characters;

public class Ninja extends Human {
	public Ninja() {
		this.setStealth(10);
	}
	
	public void steal(Human target) {
		target.setHealth(target.getHealth() - this.getStealth());
		this.setHealth(this.getHealth() + this.getStealth());
	}
	
	public void runAway() {
		this.setHealth(this.getHealth() - 10);
	}
}
