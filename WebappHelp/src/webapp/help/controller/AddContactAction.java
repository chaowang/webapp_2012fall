package webapp.help.controller;

import javax.servlet.http.HttpServletRequest;

import webapp.help.beans.ContactBean;
import webapp.help.dao.Model;

public class AddContactAction extends Action {
	public static String actionName="addContact.do";
	public AddContactAction(Model model) {
		super(model);
	}

	@Override
	public String getName() {
		return actionName;
	}

	@Override
	public String perform(HttpServletRequest request) {
		ContactBean bean = ContactBean.createBean(request);
		
		model.getContactsDAO().addContact(bean);		
		return "addContacts.jsp";
	}

}
