package webapp.help.beans;
import com.google.appengine.api.datastore.Key;
import com.google.apphosting.api.DatastorePb.GetResponse.Entity;

public class ContactBean extends Entity{
	private static String kind = "Contact";
	
	private Key categoryKey;
	private String name;
	private String phone;
	private String email;
	private String message;
	
	public ContactBean(Key key, String name, String phone, String email, String message ){
	}
	
	public Key getKey(){return categoryKey;}
	public String getName(){return name;}
	public String getEmail(){return email;}
	public String getMessage(){return message;}
	
	public static boolean Validate(ContactBean bean){
		// TODO
		return false;
	}
	
// overrideen methods
	
	public String getKind(){return kind;}
}
