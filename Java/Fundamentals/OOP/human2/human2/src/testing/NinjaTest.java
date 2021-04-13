package testing;
import characters.Human;
import characters.Ninja;

public class NinjaTest {

	public static void main(String[] args) {
		Human h1 = new Human();
		Ninja ninja = new Ninja();
		System.out.println("Target initial health");
		System.out.println(h1.getHealth());
		System.out.println("Ninja initial health");
		System.out.println(ninja.getHealth());
		ninja.steal(h1);
		System.out.println(h1.getHealth());
		System.out.println(ninja.getHealth());
		ninja.runAway();
		System.out.println(ninja.getHealth());
	}

}
