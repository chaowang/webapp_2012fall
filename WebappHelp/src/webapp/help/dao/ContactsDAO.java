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
import com.google.appengine.api.datastore.FetchOptions.Builder;

import webapp.help.beans.ContactBean;
import webapp.help.utility.Category;

public class ContactsDAO {
	private DatastoreService datastore;
	
	public boolean addContact(ContactBean bean){
		datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(bean.getEntity());        
        return true;
	}

	public boolean deleteContact(Key key){
		datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.delete(key);
		return true;
	}
	
	public boolean updateContacts(ContactBean bean){
		datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(bean.getEntity());
		return true;
	}
	
	public List<ContactBean> getContacts(String category){
		ArrayList<ContactBean> list = new ArrayList<ContactBean>();
		datastore = DatastoreServiceFactory.getDatastoreService();
		
		Query query = new Query(ContactBean.kind, KeyFactory.createKey("User",  UserServiceFactory.getUserService().getCurrentUser().getEmail()));
					//	addFilter(	ContactBean.PROPERTY_CAT, Query.FilterOperator.EQUAL, category);
	    
		System.out.println(query.getKind() + " fetching! " + query.toString());
		
		for(Entity e : datastore.prepare(query).asIterable()){
	    	list.add(new ContactBean(e));
	    	System.out.println("ding!");
	    }
		
		return list;
	}
}
