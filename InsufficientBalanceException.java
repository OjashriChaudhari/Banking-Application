package com.InsufficientBalanceException;

public class InsufficientBalanceException extends Exception {
	public String getMessage() {
		return "Insufficient Balance! Please check your balance.";
	}
}
