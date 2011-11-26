package webapp.help.controller;

import java.util.ArrayList;
import java.util.List;

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
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors",errors);
		
		ContactBean bean = ContactBean.createBean(request);
		
		errors.addAll(bean.getValidationErrors());
		if(errors.size()>0){
			return "addContacts.jsp";
		}
		
		model.getContactsDAO().addContact(bean);		
		return "veiewCategory.jsp";
	}

}
