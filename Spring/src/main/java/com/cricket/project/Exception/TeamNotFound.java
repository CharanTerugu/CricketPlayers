package com.cricket.project.Exception;

public class TeamNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeamNotFound(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}

	

	public TeamNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TeamNotFound(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TeamNotFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
