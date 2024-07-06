package com.rest.pokedex.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)  // 400
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> tratamentoExcecaoValidacao(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String atributo = ((FieldError) error).getField();
			String mensagem = error.getDefaultMessage();
			errors.put(atributo, mensagem);
		});
		return errors;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)  // 404
	@ExceptionHandler(PokemonNotFoundException.class)
	public Map<String, String> estudanteNotFoundException(PokemonNotFoundException ex) {
		Map<String, String> errorsMap = new HashMap<String, String>();
		errorsMap.put("mensagem", ex.getMessage());
		return errorsMap;
	}
	
	@ResponseStatus(HttpStatus.CONFLICT)  // 409
	@ExceptionHandler(DuplicateKeyException.class)
	public Map<String, String> chaveDuplicadaException(DuplicateKeyException ex) {
		Map<String, String> errorsMap = new HashMap<String, String>();
		errorsMap.put("mensagem", ex.getMessage());
		return errorsMap;
	}
	
	
}
