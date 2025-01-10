package com.BankAccount;

import java.util.InputMismatchException;

import java.util.Scanner;

import com.InsufficientBalanceException.InsufficientBalanceException;
import com.InvalidAccountNumberException.InvalidAccountNumberException;

public class BankAccount {
	public int balance;
	public int previousTransaction;
	public String customerName;
	public String accountNumber;

	void deposit(int amount) {
		if (amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}

	void withdraw(int amount) throws InsufficientBalanceException {
		if (amount > balance) {
			throw new InsufficientBalanceException();
		}
		balance = balance - amount;
		previousTransaction = -amount;
	}

	void getpreviousTranscation() {
		if (previousTransaction > 0) {
			System.out.println("Deposited" + previousTransaction);
		} else if (previousTransaction < 0) {
			System.out.println("Withdraw " + Math.abs(previousTransaction));
		} else {
			System.out.println("No transaction is occured!");
		}
	}

	public void AcceptCustomerInfo() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the full name : ");
		customerName = sc.nextLine();

		System.out.print("Enter account number(11 digit) : ");
		accountNumber = sc.nextLine();

		System.out.println();

	}

	public void ValidateCustomerInfo() throws InvalidAccountNumberException {
		int len = String.valueOf(accountNumber).length();

		if (accountNumber.length() == 11) {
			System.out.println("login Done!");
		} else {
			InvalidAccountNumberException iane = new InvalidAccountNumberException();
			System.out.println(iane.getMessage());
			throw iane;
		}

	}

	public void showMenue() throws InsufficientBalanceException {
		char option;
		Scanner sc = new Scanner(System.in);

		System.out.println("Please choose an option from the menu below :");
		System.out.println();
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraws");
		System.out.println("4. Check Previous Transaction");
		System.out.println("5. Exit");

		System.out.println();

		do {
			System.out.print("Enter the option number : ");
			option = sc.next().charAt(0);

			switch (option) {
			case '1':
				System.out.println();
				System.out.print("Your Current Balance is : " + balance);
				System.out.println();
				break;

			case '2':
				System.out.println();
				System.out.print("Enter the amount to deposit : ");
				int depositAmount = sc.nextInt();
				deposit(depositAmount);

				if (depositAmount != 0) {
					System.out.println("Deposit Successful...");
				}

				try {
					if (depositAmount == 0) {
						throw new ArithmeticException("Invalid input! Amount 0 is not deposit.");
					}
				} catch (ArithmeticException a) {
					System.out.println(a.getMessage());
					try {
						if (depositAmount == 0) {
							System.out.print("Enter the amount to deposit : ");
							int depositAmount2 = sc.nextInt();

							if (depositAmount2 != 0) {
								deposit(depositAmount2);
								System.out.println("Deposit Successful...");
							}
						}
					} catch (ArithmeticException a2) {
						System.out.println();
					}
				}

				System.out.println();

				System.out.print("Do you want to check balance? Yes OR No : ");
				String checkBalInput1 = sc.next();

				try {
					if (!checkBalInput1.equalsIgnoreCase("yes") && !checkBalInput1.equalsIgnoreCase("no")) {
						throw new InputMismatchException("Invalid input! Please enter yes OR no");
					}
					if (checkBalInput1.equalsIgnoreCase("yes")) {
						System.out.println("Your current Balance is : " + balance);
					}

				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					try {
						if (!checkBalInput1.equalsIgnoreCase("yes") && !checkBalInput1.equalsIgnoreCase("no")) {
							System.out.print("Do you want to check balance? Yes OR No : ");
							String checkBalInput2 = sc.next();

							if (checkBalInput2.equalsIgnoreCase("yes")) {
								System.out.println();
								System.out.println("Your current Balance i0s : " + balance);
							}
						}

					} catch (InputMismatchException e2) {
						System.out.println(e.getMessage());
					}
				}

				System.out.println();

				System.out.print("Do you want to perform any other transaction? Yes OR No : ");
				String otherTractInput1 = sc.next();

				try {
					if (!otherTractInput1.equalsIgnoreCase("yes") && !otherTractInput1.equalsIgnoreCase("no")) {
						throw new InputMismatchException("Invalid input! Please enter yes OR no");
					}
					if (otherTractInput1.equalsIgnoreCase("yes")) {
						continue;
					} else {
						Exit();
						return;
					}
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					try {
						if (!otherTractInput1.equalsIgnoreCase("yes") && !otherTractInput1.equalsIgnoreCase("no")) {
							System.out.print("Do you want to perform any other transaction? Yes OR No : ");
							String otherTractInput2 = sc.next();

							if (otherTractInput2.equalsIgnoreCase("yes")) {
								continue;
							} else {
								Exit();
								return;
							}
						}
					} catch (InputMismatchException e2) {
						System.out.println(e.getMessage());
					}
				}

				System.out.println();
				break;

			case '3':
				System.out.println();
				System.out.print("Enter the amount to withdraw : ");
				int withdrwAmount = sc.nextInt();

				try {
					withdraw(withdrwAmount);
				} catch (InsufficientBalanceException i) {
					System.out.println(i.getMessage());
				}

				if (withdrwAmount != 0 && withdrwAmount < balance) {
					System.out.println("Withdraw Successful....");
				}
				try {
					if (withdrwAmount == 0) {
						throw new ArithmeticException("Invalid input! amount 0 is not withdraw.");
					}
				} catch (ArithmeticException a) {
					System.out.println(a.getMessage());
					try {
						if (withdrwAmount == 0) {
							System.out.print("Enter the amount to withdraw : ");
							int withdrwAmount2 = sc.nextInt();
							if (withdrwAmount2 != 0) {
								withdraw(withdrwAmount2);
								System.out.println("Withdraw Successful...");
							}
						}
					} catch (ArithmeticException a2) {
						System.out.println();
					}
				}

				System.out.println();

				System.out.print("Do you want to check balance? Yes OR No : ");
				String checkBalInput3 = sc.next();

				try {
					if (!checkBalInput3.equalsIgnoreCase("yes") && !checkBalInput3.equalsIgnoreCase("no")) {
						throw new InputMismatchException("Invalid input! Please enter yes OR no");
					}
					if (checkBalInput3.equalsIgnoreCase("yes")) {
						System.out.println("Your current Balance is : " + balance);
					}

				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					try {
						if (!checkBalInput3.equalsIgnoreCase("yes") && !checkBalInput3.equalsIgnoreCase("no")) {
							System.out.print("Do you want to check balance? Yes OR No : ");
							String checkBalInput4 = sc.next();

							if (checkBalInput4.equalsIgnoreCase("yes")) {
								System.out.println();
								System.out.println("Your current Balance is : " + balance);
							}
						}

					} catch (InputMismatchException e2) {
						System.out.println(e.getMessage());
					}
				}

				System.out.println();

				System.out.print("Do you want to perform any other transaction? Yes OR No : ");
				String otherTractInput2 = sc.next();

				try {
					if (!otherTractInput2.equalsIgnoreCase("yes") && !otherTractInput2.equalsIgnoreCase("no")) {
						throw new InputMismatchException("Invalid input! Please enter yes OR no");
					}
					if (otherTractInput2.equalsIgnoreCase("yes")) {
						continue;
					} else {
						Exit();
						return;
					}
				} catch (InputMismatchException e) {
					System.out.println(e.getMessage());
					try {
						if (!otherTractInput2.equalsIgnoreCase("yes") && !otherTractInput2.equalsIgnoreCase("no")) {
							System.out.print("Do you want to perform any other transaction? Yes OR No : ");
							String otherTractInput3 = sc.next();

							if (otherTractInput3.equalsIgnoreCase("yes")) {
								continue;
							} else {
								Exit();
								return;
							}
						}
					} catch (InputMismatchException e2) {
						System.out.println(e.getMessage());
					}
				}

				System.out.println();
				break;

			case '4':
				getpreviousTranscation();
				System.out.println();
				break;

			case '5':
				Exit();
				return;

			default:
				System.out.println("Invalid option entered! Please enter correct option.");
			}
		} while (true);
	}

	void Exit() {
		System.out.println();
		System.out.println("Thank you for using our banking system. Goodbye!");
	}
}
