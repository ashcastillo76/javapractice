package com.ashley;

public class Iphone extends Phone implements Ringable {

	public Iphone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}

	@Override
	public String ring() {
		return this.getRingTone();

	}

	@Override
	public String unlock() {
		return "phone is unlocked";

	}

	@Override
	public void displayInfo() {
		System.out.println("Iphone: " +  this.getVersionNumber() + "Carrier: " + this.getCarrier());

	}

}
