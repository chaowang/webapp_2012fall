package webapp.help.dao;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import webapp.help.beans.ContactBean;
import webapp.help.utility.Category;

public class ContactsDAO {
	private DatastoreService datastore;
	private UserService userService;
	private User user;
	
	public boolean addContact(ContactBean bean){
		userService = UserServiceFactory.getUserService();
		datastore = DatastoreServiceFactory.getDatastoreService();
        user = userService.getCurrentUser();
        
        datastore.put(bean.getEntity());
        
        return false;
	}

	public boolean deleteContact(Key contactKey){
		datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.delete(contactKey);
		return true;
	}
	
	public boolean updateContacts(ContactBean bean){
		datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(bean.getEntity());
		return true;
	}
	
	public List<ContactBean> getContacts(Category category){
		ArrayList<ContactBean> list = new ArrayList<ContactBean>();
		userService = UserServiceFactory.getUserService();
		datastore = DatastoreServiceFactory.getDatastoreService();
		
		Query query = new Query(ContactBean.kind).
						addFilter(	ContactBean.PROPERTY_CAT, 
									Query.FilterOperator.EQUAL,
									category);
	    for(Entity e : datastore.prepare(query).asIterable()){
	    	list.add(new ContactBean(e));
	    }
		
		return list;
	}
	
	private Entity searchContacts(){
		return null;
	}
}
