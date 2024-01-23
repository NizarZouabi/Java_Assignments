package com.assignment.devices;

public class Device {
	private int battery;
	
	public Device() {
		this.battery = 100;
	}
	
	public int getBattery() {
		return battery;
	}
	
	public void setBattery(int battery) {
		this.battery = battery;
	}
	
	public void displayBatteryStatus() {
		System.out.println("Battery life is: " + battery + "%");
	}

}
