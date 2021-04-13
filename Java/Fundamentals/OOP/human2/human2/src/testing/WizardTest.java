package testing;
import characters.*;

public class WizardTest {

	public static void main(String[] args) {
		Human h1 = new Human();
		Wizard w1 = new Wizard();
		System.out.println(w1.getIntelligence());
		System.out.println(h1.getHealth());
		w1.heal(h1);
		System.out.println(h1.getHealth());
		w1.fireBall(h1);
		System.out.println(h1.getHealth());
	}

}
