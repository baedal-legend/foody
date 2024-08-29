package com.sparta.baedallegend.global.config.exception;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({
		HttpMessageNotReadableException.class,
		MethodArgumentTypeMismatchException.class,
		HttpRequestMethodNotSupportedException.class,
		HttpMediaTypeNotAcceptableException.class,
		HttpMediaTypeNotSupportedException.class,
		MissingPathVariableException.class,
		MissingServletRequestParameterException.class
	})
	public ResponseEntity<GlobalErrorResponse> invalidRequestException(
		Exception exception,
		HttpServletRequest request
	) {
		GlobalErrorCode errorCode = GlobalErrorCode.valueOf(exception);
		GlobalErrorResponse errorResponse = GlobalErrorResponse.of(
			request,
			errorCode);

		log.error(errorResponse.toString());
		
		return ResponseEntity.status(errorCode.status)
			.body(errorResponse);
	}

	@ExceptionHandler({Exception.class, RuntimeException.class})
	public ResponseEntity<GlobalErrorResponse> unexpectedException(
		Exception exception,
		HttpServletRequest request
	) {
		GlobalErrorResponse errorResponse = GlobalErrorResponse.of(
			request,
			GlobalErrorCode.UNEXPECTED_ERROR
		);

		exception.printStackTrace();

		return ResponseEntity.internalServerError()
			.body(errorResponse);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<GlobalErrorResponse> businessException(
		BusinessException exception,
		HttpServletRequest request
	) {
		GlobalErrorResponse globalErrorResponse = GlobalErrorResponse.businessErrorOf(
			request,
			exception
		);

		log.error(globalErrorResponse.toString());

		return ResponseEntity.status(exception.getStatus())
			.body(globalErrorResponse);
	}

}
