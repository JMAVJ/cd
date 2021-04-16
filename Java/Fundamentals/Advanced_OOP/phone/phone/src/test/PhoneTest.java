package test;
import phones.Iphone;
import phones.Galaxy;

public class PhoneTest {

	public static void main(String[] args) {
		Iphone ip1 = new Iphone("XR", 100, "AT&T", "iphone ringtone");
		Galaxy g1 = new Galaxy("S9", 20, "Verizon", "samsung ringtone");
		ip1.displayInfo();
		g1.displayInfo();
		System.out.println(ip1.ring());
		System.out.println(g1.unlock());
	}

}
