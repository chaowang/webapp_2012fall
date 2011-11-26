package webapp.help.beans;
import javax.servlet.http.HttpServletRequest;
import webapp.help.utility.Category;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

public class ContactBean{
	public static String kind = "Contact";
	public static String PROPERTY_OWNER = "owner";
	public static String PROPERTY_NAME = "name";
	public static String PROPERTY_PHONE = "phone";
	public static String PROPERTY_EMAIL = "email";
	public static String PROPERTY_MSG = "msg";
	public static String PROPERTY_CAT = "category";
	
	private Key parentKey;
	private String name;
	private String phone;
	private String email;
	private String message;
	private String category;
	private Key key;
	
	private Entity entity;
	
	public ContactBean( String name, String phone, String email, String category, String message){
		this.parentKey = KeyFactory.createKey("User",  UserServiceFactory.getUserService().getCurrentUser().getEmail());
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.message = message;
		this.category = category;
		this.entity = new Entity("contact",parentKey);
	}
	
	
	public Key getParentKey(){return parentKey;}
	public String getName(){return name;}
	public String getPhone(){return phone;}
	public String getEmail(){return email;}
	public String getMessage(){return message;}
	public String getCategory(){return category;}
	
	public Entity getEntity(){
		return entity;
	}
	
	public static boolean Validate(ContactBean bean){
		// TODO
		return false;
	}
	
	public static ContactBean createBean(HttpServletRequest req){
		String name = req.getParameter(PROPERTY_NAME);
		String phone = req.getParameter(PROPERTY_PHONE);
		String email = req.getParameter(PROPERTY_EMAIL);
		String message = req.getParameter(PROPERTY_MSG);
		String category = req.getParameter(PROPERTY_CAT); // tODO update this later
		return new ContactBean(name, phone, email, category, message);
	}
}
