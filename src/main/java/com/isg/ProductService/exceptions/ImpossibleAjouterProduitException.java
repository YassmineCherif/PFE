package com.isg.ProductService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ImpossibleAjouterProduitException extends RuntimeException {

	public ImpossibleAjouterProduitException(String message) {
		 super(message);
	}

}
