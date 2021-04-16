package phones;
import interfaces.Ringable;

public class Iphone extends Phone implements Ringable {

	public Iphone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}
	
	@Override
	public String ring() {
		return this.getVersionNumber() + " is ringing: " + this.getRingTone();
	}
	
	@Override
	public String unlock() {
		return "iPhone unlocked";
	}
	
	@Override
	public void displayInfo() {
		System.out.println("<Phone | iPhone " + this.getVersionNumber() + " Carrier: " + this.getCarrier() +">");
	}
}