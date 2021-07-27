package application;

import java.util.Locale;
import java.util.Scanner;

import model.Exceptions.BusinessException;
import model.entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		double limit = sc.nextDouble();

		Account acc = new Account(number, name, balance, limit);

		System.out.print("\nEnter amount for withdraw: ");
		double value = sc.nextDouble();

		try {
			acc.withdraw(value);
			System.out.println(acc);
		} 
		catch (BusinessException ex) {
			System.out.println("Withdraw error: " + ex);
		} 
		catch (RuntimeException ex) {
			System.out.println("Unexpected erro");
		}

		sc.close();

	}

}
