package others.customeException;

@SuppressWarnings("serial")
public class NameNotFoundException extends Exception{

	public NameNotFoundException(String message){
		super(message);
	}
	
	
	public NameNotFoundException(String message, Throwable cause){
		super(message, cause);
	}
}
