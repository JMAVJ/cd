package testing;
import animals.Bat;

public class BatTest {

	public static void main(String[] args) {
		Bat bat = new Bat();
		bat.displayEnergy();
		bat.fly();
		bat.eatHumans();
		bat.attackTown();
		bat.displayEnergy();
	}

}
