package com.nttdata.test.exceptions;

/**
 * @author David Mogrovejo
 */
public class MovementException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public MovementException(String message) {
		super(message);
	}

}
