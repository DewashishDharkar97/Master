package dewaSB;

public class OrderNotFoundException extends RuntimeException {
	  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	OrderNotFoundException(long id){
		
		super("Could not find product " + id);
	}

}
