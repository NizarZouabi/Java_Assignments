package com.assignment.zookeeper;

public class ZooTest {

	public static void main(String[] args) {
		Gorilla gorilla = new Gorilla();
		Bat bat = new Bat();
		
		gorilla.displayEnergy();
		
		gorilla.throwSomething();
		gorilla.throwSomething();
		gorilla.throwSomething();
		
		gorilla.eatBananas();
		gorilla.eatBananas();
		
		gorilla.climb();
		
		bat.displayEnergy();
		
		bat.fly();
		
		bat.attackTown();
		
		bat.eatHumans();

	}

}
