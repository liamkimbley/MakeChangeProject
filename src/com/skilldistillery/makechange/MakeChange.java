package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome! This will calculate the change that needs to be returned.");
		while (true) {
			System.out.println("To Quit, please type \"QUIT\".");
			System.out.print("Please enter the price of the item: ");
			String cost = sc.next();
			if (cost.equalsIgnoreCase("QUIT")) {
				break;
			}
			System.out.print("Please enter the amount given: ");
			String given = sc.next();
			if (given.equalsIgnoreCase("QUIT")) {
				break;
			}
			double price = convertToDouble(cost);
			double money = convertToDouble(given);
//			System.out.println(money + " \t" + price);

			if (money == price) {
				System.out.println("Exact amount. No change needed.");
				System.out.println();
			} else if (money < price) {
				double need = (price - money);
				System.out.printf("Too little given. Need: $%.2f\n", need);
				System.out.println();
			} else {
				calculateChange(money, price);
			}
		}

		System.out.println("Goodbye.");
		sc.close();
	}

	public static void calculateChange(double money, double price) {

		double change = (money - price);
		double twenty, one, quarter, dime, penny;
		System.out.printf("$%.2f owed.\n", change);
		twenty = (change / 20);
		if (change >= 20.0) {
			twenty = (int) twenty;
			if (twenty == 1) {
				System.out.print("1 twenty dollar bill, ");
			} else {
				System.out.print((int) twenty + " twenty dollar bills, ");
			}
			change = change % 20;
		}
//		change = (change - ((20)*twenty*(int)twenty));
		if (change >= 10) {
			System.out.print("1 ten, ");
			change = change % 10;
		}
		if (change >= 5) {
			System.out.print("1 five dollar bill, ");
			change = change % 5;
		}
		if (change >= 1) {
			one = (int) change;
			if (one == 1) {
				System.out.print("1 one dollar bill, ");
			} else {
				System.out.print((int) one + " one dollar bills, ");
			}
			change = change % 1;
		}
		if (change >= .25) {
			quarter = (int) (change / .25);
			if (quarter == 1) {
				System.out.print("1 quarter, ");
			} else {
				System.out.print((int) quarter + " quarters, ");
			}
			change = change % .25;
		}
		if (change >= .10) {
			dime = (int) (change / .10);
			if (dime == 1) {
				System.out.print("1 dime, ");
			} else {
				System.out.print((int) dime + " dimes, ");
			}
			change = change % .10;
		}
		if (change >= .05) {
			System.out.print("1 nickel, ");
			change = change % .045;
		}
		if (change >= .006) {
			penny = (int) (change / .009);
//			System.out.print(penny);
			if (penny == 1) {
				System.out.println("1 penny.");
			} else {
				System.out.println(((int) penny) + " pennies.");
			}
		}
//		System.out.println(change);
	}

	public static double convertToDouble(String word) {
		double num = Double.parseDouble(word);
		return num;
	}

}