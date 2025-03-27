package entities;

import java.util.Scanner;

public class Account {

	private int number;
	private String holder;
	private double balance;

	public Account() {
	}

	public Account(int number, String holder) {
		this.number = number;
		this.holder = holder;
	}

	public Account(int number, String holder, double initialDeposit) {
		this.number = number;
		this.holder = holder;
		deposit(initialDeposit);
	}

	public int getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void inputAccountNumber(Scanner sc) {
		boolean validAccountNumber = false;

		while (!validAccountNumber) {
			System.out.print("Enter the account number (6 digits): ");
			String accountNumberInput = sc.nextLine();

			if (isValidAccountNumber(accountNumberInput)) {
				this.number = Integer.parseInt(accountNumberInput);
				validAccountNumber = true; // Se for válido, sai do loop
			} else {
				System.out.println("Invalid account number! It must be exactly 6 digits.");
			}
		}
	}

	public boolean isValidAccountNumber(String accountNumberInput) {
		return accountNumberInput.length() == 6 && accountNumberInput.matches("[0-9]+");
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		balance -= amount + 5.0;
	}

	public String toString() {
		return "Account "
				+ number
				+ ", Holder: "
				+ holder
				+ ", Balance: $ "
				+ String.format("%.2f", balance);
	}
}
