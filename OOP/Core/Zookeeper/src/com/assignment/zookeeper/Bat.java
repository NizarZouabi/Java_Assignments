package com.assignment.zookeeper;

public class Bat extends Mammal {
	
	public Bat() {
		super.setEnergy(300);
	}
	
	public void fly(){
		System.out.println("The giant bat stirred from its slumber.\r\n"
				+ "The dank air within the hidden den crackled with an eerie energy as the creature unfolded its immense wings\r\n"
				+ "Revealing the magnitude of its menacing presence\r\n"
				+ "Flying towards the nearly doomed towns");
		int currentEnergyLevel = getEnergy();
		int newEnergyLevel = currentEnergyLevel -50;
		if (newEnergyLevel < 0) {
			setEnergy(0);
		} else {
			setEnergy(newEnergyLevel);
		}
		displayEnergy();
	}
	
	public void eatHumans(){
		System.out.println("Sated with the spoils of its nocturnal feast, the giant bat ascended into the obsidian sky\r\n"
	    + "Its colossal wings cutting through the cool night air. The air bore witness to a ghastly symphony of silence\r\n"
		+ "As the once bustling town lay in the grip of an eerie stillness.\r\n"
		+ "The creature's predatory eyes gleamed with a sinister satisfaction");
		int currentEnergyLevel = getEnergy();
		int newEnergyLevel = currentEnergyLevel +25;
		if (newEnergyLevel > 300) {
			setEnergy(300);
		} else {
			setEnergy(newEnergyLevel);
		}
		displayEnergy();
	}
	
	public void attackTown(){
		System.out.println("The giant bat, its fur as dark as the night itself, descended upon the unsuspecting towns\r\n"
				+ "With an almost supernatural grace. Its eyes glowed a malevolent crimson, mirroring the malevolence that fueled its rampage. As it glided through the air\r\n"
				+ "The colossal creature unleashed a torrent of gusty wind, uprooting trees and scattering debris in its wake.\r\n"
				+ "With each beat of its monstrous wings, the giant bat launched itself from one end of the town to another, wreaking havoc upon everything in its path.");
		int currentEnergyLevel = getEnergy();
		int newEnergyLevel = currentEnergyLevel -100;
		if (newEnergyLevel < 0) {
			setEnergy(0);
		} else {
			setEnergy(newEnergyLevel);
		}
		displayEnergy();
	}
}
