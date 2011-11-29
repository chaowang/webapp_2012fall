package webapp.help.dao;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.users.UserServiceFactory;

import webapp.help.beans.ContactBean;

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
	
	public boolean updateContacts(ContactBean bean,Key key){
		
		datastore = DatastoreServiceFactory.getDatastoreService();
		try {
			Entity entity = datastore.get(key);
						
		
			entity.setProperty(ContactBean.PROPERTY_NAME,bean.getName());
			entity.setProperty(ContactBean.PROPERTY_PHONE,bean.getPhone());
			entity.setProperty(ContactBean.PROPERTY_EMAIL,bean.getEmail());
			entity.setProperty(ContactBean.PROPERTY_MSG,bean.getMessage());  
			entity.setProperty(ContactBean.PROPERTY_CAT,bean.getCategory());
			
			datastore.put(entity);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
    public ContactBean getContact(Key key) throws EntityNotFoundException{
		datastore = DatastoreServiceFactory.getDatastoreService();
		return new ContactBean(datastore.get(key));

    }
    public List<ContactBean> getContacts(String category){
    	ArrayList<ContactBean> list = new ArrayList<ContactBean>();
    	datastore = DatastoreServiceFactory.getDatastoreService();

    	Query query = new Query(ContactBean.kind, 
    			KeyFactory.createKey("User", 
    					UserServiceFactory.getUserService().getCurrentUser().getEmail()));

		query.addFilter(ContactBean.PROPERTY_CAT, Query.FilterOperator.EQUAL, category);
	   

		System.out.println(query.getKind() + " fetching! " + query.toString());
		for(Entity e : datastore.prepare(query).asIterable()){
	    	list.add(new ContactBean(e));
	    }
		
		return list;
	}
    public ContactBean getContact(String email){
    	ContactBean bean = null;
    	datastore = DatastoreServiceFactory.getDatastoreService();

    	Query query = new Query(ContactBean.kind, 
    			KeyFactory.createKey("User", 
    					UserServiceFactory.getUserService().getCurrentUser().getEmail()));

		query.addFilter(ContactBean.PROPERTY_EMAIL, Query.FilterOperator.EQUAL, email);
	   

		System.out.println(query.getKind() + " fetching! " + query.toString());
		for(Entity e : datastore.prepare(query).asIterable()){
			bean = new ContactBean(e);
	    }
		
		return bean;
    }
}
