package others.customeException;

/**
 * Class to test {@link NameNotFoundException}
 * */
public class CustomerService {

	public Customer findByName(String name) throws NameNotFoundException{
		
		if("".equals(name)){
			
			throw new NameNotFoundException("Name is empty!",new NullPointerException());
		}
		
		else if(!"Avi".equalsIgnoreCase(name)){
			throw new NameNotFoundException("Name not matched"); 
		}
		
		//Escaping the logic to find the customer from the list of customer 
		return new Customer(name);
	}
	
	public static void main(String[] args) {
		
		CustomerService customerService = new CustomerService();
		try {
			Customer customer = customerService.findByName("Avi");
			//Customer customer = customerService.findByName("");
			//Customer customer = customerService.findByName("RandomName");
			if(customer instanceof Customer){
				System.out.println("Customer with name Avi found");
			}
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
	}
}
