package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		Account account;

		// Aqui, chamamos o método que garante a validação do número da conta
		account = new Account(); // Criamos a conta vazia primeiro
		account.inputAccountNumber(sc); // Valida o número da conta

		System.out.print("Enter account holder: ");
		String holder = sc.nextLine();
		System.out.print("Is there an initial deposit? (y/n) : ");
		char response = sc.next().charAt(0);
		if (response == 'y') {
			System.out.print("Enter initial deposit value: ");
			double initialDeposit = sc.nextDouble();
			account = new Account(account.getNumber(), holder, initialDeposit);
		} else {
			account = new Account(account.getNumber(), holder);
		}

		System.out.println();
		System.err.println("### Your account has been created successfully! ###");
		System.out.println("Here is your account information");
		System.out.print("--> ");
		System.out.println(account);

		while (true) {
			System.out.println();
			System.out.print("Do you want to make a Deposit, Withdraw or Leave account? (D / W / L): ");
			response = sc.next().toUpperCase().charAt(0); // Convertendo para maiúscula

			switch (response) {
				case 'D':
					System.out.print("Enter deposit value: ");
					double depositValue = sc.nextDouble();
					account.deposit(depositValue);
					System.out.println("Updated Account Data: ");
					System.out.println(account);
					break;

				case 'W':
					System.out.print("Enter withdraw value: ");
					double withdrawValue = sc.nextDouble();
					account.withdraw(withdrawValue);
					System.out.println("Updated Account Data: ");
					System.out.println(account);
					break;

				case 'L':
					System.out.println("Logging out of the account. Bye bye!");
					// sc.close();
					return; // Sai do programa

				default:
					System.out.println("Invalid option! Try again..");
					break;
			}
		}
	}
}
