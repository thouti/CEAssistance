package com.cea.util;

public class CeaException extends Exception
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CeaException(){
	        super();
	    }
	    public CeaException(String errorMessage){
	        super(errorMessage);
	    }
	    public CeaException(String errorMessage,Throwable throwClass){
	        super(errorMessage,throwClass);
	    }
}
