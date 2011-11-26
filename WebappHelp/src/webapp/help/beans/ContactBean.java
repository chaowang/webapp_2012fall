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
	public static String PROPERTY_PARENT = "parent";
	public static String PROPERTY_NAME = "name";
	public static String PROPERTY_PHONE = "phone";
	public static String PROPERTY_EMAIL = "email";
	public static String PROPERTY_MSG = "msg";
	public static String PROPERTY_CAT = "category";
	
	private Key parent;
	private Key key;
	
	private String name;
	private String phone;
	private String email;
	private String message;
	private String category;
	
	private Entity entity;
	
	public ContactBean( String name, String phone, String email, String category, String message){
		this.parent = KeyFactory.createKey("User",  UserServiceFactory.getUserService().getCurrentUser().getEmail());
		
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.message = message;
		this.category = category;
		
		this.entity = getEntity();
		
		this.key = entity.getKey();
		
	}
	
	public ContactBean(Entity entity){
		parent = entity.getParent();
		key = entity.getKey();
		name = (String) entity.getProperty(PROPERTY_NAME);
		phone = (String) entity.getProperty(PROPERTY_PHONE);
		email = (String) entity.getProperty(PROPERTY_EMAIL);
		message = (String) entity.getProperty(PROPERTY_MSG);
		category = (String) entity.getProperty(PROPERTY_CAT);
		this.entity = entity;
	}
	
	public Entity getEntity(){
		if(entity == null){
			entity = new Entity(kind,parent);
			
			entity.setProperty(PROPERTY_PARENT,parent);
			
			entity.setProperty(PROPERTY_NAME,name);
			entity.setProperty(PROPERTY_PHONE,phone);
			entity.setProperty(PROPERTY_EMAIL,email);
			entity.setProperty(PROPERTY_MSG,message);  
			entity.setProperty(PROPERTY_CAT,category);
		}

		return entity;

	}
	
	public Key getParent(){return parent;}
	public Key getKey() {return entity.getKey(); };
	
	public String getName(){return name;}
	public String getPhone(){return phone;}
	public String getEmail(){return email;}
	public String getMessage(){return message;}
	public String getCategory(){return category;}
	public String getKeyStr() {return KeyFactory.keyToString(this.key);}
	
	
	public static boolean Validate(ContactBean bean){
		// TODO
		return false;
	}
	
	public static ContactBean createBean(HttpServletRequest req){
		String name = req.getParameter(PROPERTY_NAME);
		String phone = req.getParameter(PROPERTY_PHONE);
		String email = req.getParameter(PROPERTY_EMAIL);
		String message = req.getParameter(PROPERTY_MSG);
		String category = req.getParameter(PROPERTY_CAT); 
		
		return new ContactBean(name, phone, email, category, message);
	}
}
