package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Account> accounts = new ArrayList<>();

		System.out.print("Quantas contas serão registradas? ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.printf("\nConta #%d:\n", i + 1);
			System.out.print("ID: ");
			int id = sc.nextInt();
			while (hasId(accounts, id)) {
				System.out.print("ID já existente! Digite outro: ");
				id = sc.nextInt();
			}

			System.out.print("Titular: ");
			sc.nextLine();
			String holder = sc.nextLine();

			System.out.print("Deseja fazer um depósito inicial (s/n)? ");
			char option = sc.next().charAt(0);
			double initialDeposit = 0.0;
			if (option == 's') {
				System.out.print("Digite o valor do depósito inicial: ");
				initialDeposit = sc.nextDouble();
				accounts.add(new Account(id, holder, initialDeposit));
			} else {
				accounts.add(new Account(id, holder));
			}
		}

		System.out.print("\nDigite o ID da conta para depósito: ");
		int id = sc.nextInt();
		Account acc = findAccount(accounts, id);
		if (acc == null) {
			System.out.println("Conta não encontrada!");
		} else {
			System.out.print("Digite o valor para depósito: ");
			double amount = sc.nextDouble();
			acc.deposit(amount);
		}

		System.out.print("\nDigite o ID da conta para saque: ");
		id = sc.nextInt();
		acc = findAccount(accounts, id);
		if (acc == null) {
			System.out.println("Conta não encontrada!");
		} else {
			System.out.print("Digite o valor para saque: ");
			double amount = sc.nextDouble();
			acc.withdraw(amount);
		}

		System.out.println("\nLISTA DE CONTAS:");
		for (Account account : accounts) {
			System.out.println(account);
		}

		sc.close();
	}

	public static boolean hasId(List<Account> list, int id) {
		return list.stream().anyMatch(acc -> acc.getId() == id);
	}

	public static Account findAccount(List<Account> list, int id) {
		return list.stream().filter(acc -> acc.getId() == id).findFirst().orElse(null);
	}
}
