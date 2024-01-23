package com.assignment.devices;

public class Phone extends Device {
	
	public Phone() {
		super();
	}
	
	public void makeCall() {
		System.out.println("Making a call...");
		int currentBattery = getBattery();
		int newBatteryLevel = currentBattery -5;
		if (newBatteryLevel < 0) {
			setBattery(0);
		} else if (newBatteryLevel < 10) {
			System.out.println("battery critical");
			setBattery(newBatteryLevel);
		} else {
			setBattery(newBatteryLevel);
		}
		displayBatteryStatus();
	}
	
	public void playGame() {
		int currentBattery = getBattery();
		int newBatteryLevel = currentBattery -20;
		if (newBatteryLevel >= 25) {
			System.out.println("Playing a game...");
			setBattery(newBatteryLevel);
		} else if (newBatteryLevel < 25) {
			System.out.println("battery is too low");
		} else if (newBatteryLevel < 0) {
			setBattery(0);
		}
		displayBatteryStatus();
	}
	
	public void charge() {
		System.out.println("Phone is charging...");
		int currentBattery = getBattery();
		int newBatteryLevel = currentBattery + 50;
		if ( newBatteryLevel > 100) {
			setBattery(100);
		} else {
			setBattery(newBatteryLevel);
		}
		displayBatteryStatus();
	}
}
