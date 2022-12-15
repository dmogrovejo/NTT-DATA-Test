package com.nttdata.test.exceptions;

/**
 * @author David Mogrovejo
 */
public class AccountException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public AccountException(String message) {
		super(message);
	}

}
