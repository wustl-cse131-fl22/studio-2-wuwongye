package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);

		System.out.println("How much are you starting with?");
		int startAmount = in.nextInt();
		int money = startAmount;
		System.out.println("What is your win rate?");
		double winChance = in.nextDouble();
		System.out.println("What is your win limit?");
		int winLimit = in.nextInt();
		System.out.println("How many days are you gambling?");
		int totalSimulations = in.nextInt();
		int lossCount = 0;
		double ruinRate = 0;
		int i = 0;
		String status;
		int playTimes = 0;
		while (i < totalSimulations) {
			playTimes = 0;
			startAmount = money;
			while (startAmount > 0 && startAmount < winLimit){
				if (winChance > Math.random()){
					startAmount++;
					playTimes++;
				}
				else {
					startAmount--;
					playTimes++;
				}
			}
			i++;
			if (startAmount > 0) {
				status = "WIN";
			}
			else {
				status = "LOSE";
				lossCount++;
			}
			System.out.println("Simulation " + i + ": " + playTimes + " " + status);
		}
		System.out.println("Losses: "+lossCount+" Simulation: "+totalSimulations);
		double a = (1-winChance)/winChance;
		double expectedRuin = (Math.pow(a, money) - 
				Math.pow(a,  winLimit))/(1-Math.pow(a,winLimit));
		System.out.println("Ruin Rate from Simulation: " + 
				(Math.round((double)lossCount/totalSimulations * 100)/100.00) +
				" Expected Ruin Rate: " + expectedRuin);
	}
}
