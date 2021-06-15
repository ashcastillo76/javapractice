package com.ashley;

public class PhoneTest {

	public PhoneTest() {
		
	}

	public static void main(String[] args) {
		Iphone iphone1 = new Iphone("12pro ", 70, " Verizon", "RIIING RIIING");
		
		
		iphone1.displayInfo();
		System.out.println(iphone1.ring());
		System.out.println(iphone1.unlock());
		
		Galaxy g1 = new Galaxy("GalaxyModel", 100, "Sprint", "Answer Your Phone!");
		g1.displayInfo();
		System.out.println(g1.ring());
		System.out.println(g1.unlock());
		
		Iphone iphone2 = new Iphone("8s", 20, "AT&T", "Please enjoy the music while you're party is reached");
		iphone2.displayInfo();
		System.out.println(iphone2.ring());
		System.out.println(iphone2.unlock());
	}

}
