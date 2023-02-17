package com.loosecouple.example;

//
// https://www.javaguides.net/2018/08/coupling-in-java-with-example.html
//

public class LooseCoupling {

	public static void main(String[] args) {
		
		// Example of tight coupling - To change journey from Car to Bike, it requires 
		// changes in BadTraveler class
		BadTraveler bt = new BadTraveler();
		bt.startJourney();
		
		// Example of loose coupling - To change journey from Car to Bike, it 
		// is possible without changing GoodTraveler class
		GoodTraveler gt = new GoodTraveler();
		
		//YOUR_CODE_HERE // Inject Car dependency
		gt.setV(new Car());
		
		//YOUR_CODE_HERE // start journey by Car
		gt.startJourney();
		
		//YOUR_CODE_HERE // Inject Bike dependency
		gt.setV(new Bike());
		
		//YOUR_CODE_HERE// Start journey by Bike
		gt.startJourney();
		
	}
}