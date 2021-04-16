package phones;

import interfaces.Ringable;

public class Galaxy extends Phone implements Ringable {

	public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}

	@Override
	public String ring() {
		return this.getVersionNumber() + " is ringing";
	}
	
	@Override
	public String unlock() {
		return "Galaxy unlocked";
	}
	
	@Override
	public void displayInfo() {
		System.out.println("<Phone | iPhone " + this.getVersionNumber() + " Carrier: " + this.getCarrier() +">");
	}

}
