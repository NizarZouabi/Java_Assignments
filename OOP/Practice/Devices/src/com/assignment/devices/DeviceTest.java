package com.assignment.devices;

public class DeviceTest {

	public static void main(String[] args) {
		Phone phone = new Phone();
		
		phone.displayBatteryStatus();
		phone.makeCall();
		phone.makeCall();
		phone.makeCall();
		phone.playGame();
		phone.playGame();
		phone.playGame();
		phone.makeCall();
		phone.playGame();
		phone.charge();
	}
}
