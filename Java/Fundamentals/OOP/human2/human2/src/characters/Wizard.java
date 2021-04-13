package characters;

public class Wizard extends Human {
	public Wizard() {
		this.setHealth(50);
		this.setIntelligence(8);
	}

	public void heal(Human target) {
		target.setHealth(target.getHealth() + this.getIntelligence());
	}

	public void fireBall(Human target) {
		target.setHealth(target.getHealth() - (this.getIntelligence() * 3));
	}
}
