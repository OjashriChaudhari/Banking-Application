package com.InvalidAccountNumberException;

public class InvalidAccountNumberException extends Exception {
	public String getMessage() {
		return "Invalid account number! Please enter 11 digit account number.";
	}
}
