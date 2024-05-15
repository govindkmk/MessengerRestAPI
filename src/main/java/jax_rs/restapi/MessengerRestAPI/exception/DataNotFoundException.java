package jax_rs.restapi.MessengerRestAPI.exception;

public class DataNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4528531627387727450L;

	public DataNotFoundException(String message){
		super(message);
	}
}
