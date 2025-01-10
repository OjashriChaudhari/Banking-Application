package com.customer;

import java.util.Iterator;

import com.BankAccount.BankAccount;
import com.InvalidAccountNumberException.InvalidAccountNumberException;

public class Customer {
	public void initiate() throws InvalidAccountNumberException {
		BankAccount ba = new BankAccount();
		try {
			ba.AcceptCustomerInfo();
			ba.ValidateCustomerInfo();
		} catch (InvalidAccountNumberException e) {
			try {
				ba.AcceptCustomerInfo();
				ba.ValidateCustomerInfo();
			} catch (Exception f) {
				try {
					ba.AcceptCustomerInfo();
					ba.ValidateCustomerInfo();
				} catch (Exception g) {
					System.out.println("Your account is blocked! ");
				}
			}
		}
	}
}
