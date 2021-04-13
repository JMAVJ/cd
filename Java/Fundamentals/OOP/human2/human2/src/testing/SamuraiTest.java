package testing;
import characters.Human;
import characters.Samurai;

public class SamuraiTest {

	public static void main(String[] args) {
		Human target = new Human();
		Samurai s = new Samurai();
		Samurai s2 = new Samurai();
		System.out.println("There are " + Samurai.howMany() + " Samurai instances");
		s.deathBlow(target);
		System.out.println(target.getHealth());
		System.out.println(s.getHealth());
		s.meditate();
		System.out.println(s.getHealth());
		s.attack(s2);
		System.out.println(s2.getHealth());
	}

}
