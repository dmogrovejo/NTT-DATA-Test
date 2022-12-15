package com.nttdata.test.exceptions;

import org.springframework.http.ResponseEntity;

/**
 * @author David Mogrovejo
 */
public class ResponseEntityBuilder {
	
	public static ResponseEntity<Object> build(ApiNttDataError apiError) {
	      return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}

