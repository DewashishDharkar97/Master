package dewaSB;

public class ProductNotFoundException extends RuntimeException {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ProductNotFoundException(Integer id){
		
		super("Could not find product " + id);
	}

}
