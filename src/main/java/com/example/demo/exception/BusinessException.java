package com.example.demo.exception;

public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5656216210816870423L;
    private String errorCode;
    private String message;
	@Override
	public synchronized Throwable fillInStackTrace() {
		return this;
	}

	public BusinessException(String message,String errorCode) {
		this.message = message;
		this.errorCode = errorCode;
	}

	public BusinessException() {
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
