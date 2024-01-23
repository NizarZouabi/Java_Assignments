package com.assignment.zookeeper;

public class Gorilla extends Mammal {
	
	public Gorilla() {
		super();
	}
	
	public void throwSomething() {
		System.out.println("Angry Gorilla threw a rock");
		int currentEnergyLevel = getEnergy();
		int newEnergyLevel = currentEnergyLevel -5;
		if (newEnergyLevel < 0) {
			setEnergy(0);
		} else {
			setEnergy(newEnergyLevel);
		}
		displayEnergy();
	}
	
	public void eatBananas() {
		System.out.println("Gorilla ate bananas, Gorilla is happy");
		int currentEnergyLevel = getEnergy();
		int newEnergyLevel = currentEnergyLevel +10;
		if (newEnergyLevel > 100) {
			setEnergy(100);
		} else {
			setEnergy(newEnergyLevel);
		}
		displayEnergy();
	}
	
	public void climb() {
		System.out.println("Gorilla climbed a tree");
		int currentEnergyLevel = getEnergy();
		int newEnergyLevel = currentEnergyLevel -5;
		if (newEnergyLevel < 0) {
			setEnergy(0);
		} else {
			setEnergy(newEnergyLevel);
		}
		displayEnergy();
	}
}
