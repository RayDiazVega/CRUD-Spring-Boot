package com.example.demo.exceptions;

import java.util.UUID;
import java.util.logging.Logger;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExceptionsHandler {
	
	private static final Logger LOG = Logger.getLogger(ExceptionHandler.class.getName());
	
	private void logError(ErrorCode errorCode, Exception e) {
		LOG.severe(errorCode.getCodigo());
		LOG.severe(errorCode.getMensaje());
		LOG.severe(e.getMessage());
	}
	
	public String getUUID() {
		return UUID.randomUUID().toString();
	}
	/*
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode handleException(Exception e) {
		ErrorCode errorCode = new ErrorCode();
		errorCode.setCodigo(getUUID());
		errorCode.setMensaje("Error encontrado");
		logError(errorCode, e);
		return errorCode;
	}
	*/
	
	@ExceptionHandler(RegistroNoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorCode RegistroNoEncontradoException(Exception e) {
		ErrorCode errorCode = new ErrorCode();
		errorCode.setCodigo(getUUID());
		errorCode.setMensaje("Producto no Encontrado");
		logError(errorCode, e);
		return errorCode;
	}
	
	@ExceptionHandler(ValorException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode ValorException(Exception e) {
		ErrorCode errorCode = new ErrorCode();
		errorCode.setCodigo(getUUID());
		errorCode.setMensaje("Valor incorrecto");
		logError(errorCode, e);
		return errorCode;
	}
	
	@ExceptionHandler(CodigoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode CodigoException(Exception e) {
		ErrorCode errorCode = new ErrorCode();
		errorCode.setCodigo(getUUID());
		errorCode.setMensaje("Codigo incorrecto");
		logError(errorCode, e);
		return errorCode;
	}
	
	@ExceptionHandler(NombreException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode NombreException(Exception e) {
		ErrorCode errorCode = new ErrorCode();
		errorCode.setCodigo(getUUID());
		errorCode.setMensaje("Nombre incorrecto");
		logError(errorCode, e);
		return errorCode;
	}
	
	@ExceptionHandler(IdException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode IdException(Exception e) {
		ErrorCode errorCode = new ErrorCode();
		errorCode.setCodigo(getUUID());
		errorCode.setMensaje("Id incorrecto");
		logError(errorCode, e);
		return errorCode;
	}
	
	@ExceptionHandler(CantidadException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCode CantidadException(Exception e) {
		ErrorCode errorCode = new ErrorCode();
		errorCode.setCodigo(getUUID());
		errorCode.setMensaje("Cantidad incorrecta");
		logError(errorCode, e);
		return errorCode;
	}

}
