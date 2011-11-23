package webapp.help.dao;

public class Model {
	private ContactsDAO contactsDAO;
	
	public Model(){
		contactsDAO = new ContactsDAO();
	}
	
	public ContactsDAO getContactsDAO(){ return contactsDAO; }
}
