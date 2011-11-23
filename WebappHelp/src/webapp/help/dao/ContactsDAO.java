package webapp.help.dao;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import webapp.help.beans.ContactBean;

public class ContactsDAO {
	private DatastoreService datastore;
	private UserService userService;
	private User user;
	
	public boolean addContact(ContactBean bean){
		userService = UserServiceFactory.getUserService();
		datastore = DatastoreServiceFactory.getDatastoreService();
        user = userService.getCurrentUser();
        
        //datastore.put(bean);
        
        return false;
	}

	public boolean deleteContact(Key contactKey){
		return false;
	}
	
	public boolean updateContacts(Key contactKey, ContactBean bean){
		return false;
	}
	
	public List<ContactBean> getContacts(Key categoryKey){
		return null;
	}
}
