package webapp.help.beans;
import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.users.User;

public class ContactBean{
	public static String kind = "Contact";
	public static String PROPERTY_OWNER = "owner";
	public static String PROPERTY_NAME = "name";
	public static String PROPERTY_PHONE = "phone";
	public static String PROPERTY_EMAIL = "email";
	public static String PROPERTY_MSG = "msg";
	public static String PROPERTY_CAT = "category";
	
	private Key key;
	private User owner;
	private String name;
	private String phone;
	private String email;
	private String message;
	private Category category;
	private Entity entity;
	
	public ContactBean(User owner, String name, String phone, String email, Category category, String message){
		initialize(KeyFactory.createKey(kind, email),
					owner, name, phone, email, category, message);
	}
	
	public ContactBean(Key key, User owner, String name, String phone, String email, Category category, String message ){
		initialize(key, owner, name, phone, email, category, message);
	}
	
	private void initialize(Key key, User owner, String name, String phone, String email, Category category, String message ){
		this.key = key;
		this.owner = owner;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.message = message;
		this.category = category;
	}
	
	public ContactBean(Entity entity){
		owner = (User) entity.getProperty(PROPERTY_OWNER);
		name = (String) entity.getProperty(PROPERTY_NAME);
		phone = (String) entity.getProperty(PROPERTY_PHONE);
		email = (String) entity.getProperty(PROPERTY_EMAIL);
		message = (String) entity.getProperty(PROPERTY_MSG);
		category = (Category) entity.getProperty(PROPERTY_CAT);
		key = entity.getKey();
		this.entity = entity;
	}
	
	public Key getKey(){return key;}
	public String getName(){return name;}
	public String getPhone(){return phone;}
	public String getEmail(){return email;}
	public String getMessage(){return message;}
	public Category getCategory(){return category;}
	
	public Entity getEntity(){
		if(entity == null){
			entity = new Entity(key);
			entity.setProperty(PROPERTY_OWNER,owner);
			entity.setProperty(PROPERTY_NAME,name);
			entity.setProperty(PROPERTY_PHONE,phone);
			entity.setProperty(PROPERTY_EMAIL,email);
			entity.setProperty(PROPERTY_MSG,message);	
			entity.setProperty(PROPERTY_CAT,category);
		}
		
		return entity;
	}
	
	public static boolean Validate(ContactBean bean){
		// TODO
		return false;
	}
}
