package com.BankingApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.customer.Customer;
import com.BankAccount.BankAccount;

public class BankingApplication {
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to Apna Bank...");
		System.out.println();
		System.out.println("Please enter your name and account number here : ");
		System.out.println();

		Customer c = new Customer();
		BankAccount ba = new BankAccount();

		c.initiate();
		ba.showMenue();

	}
}
