package pe.mycompany.reto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pe.mycompany.reto.model.ErrorResponseDTO;

@ControllerAdvice
public class CommentControllerAdvice {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ErrorResponseDTO> handleException(Exception e) {
		return new ResponseEntity<>(new ErrorResponseDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
