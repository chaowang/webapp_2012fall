package webapp.help.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import webapp.help.beans.ContactBean;
import webapp.help.dao.Model;
import webapp.help.utility.Category;

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
			request.setAttribute("contact", bean);
			return "addContacts.jsp";
		}
		
		model.getContactsDAO().addContact(bean);	
		
		List<ContactBean> list = model.getContactsDAO().getContacts(Category.GENERAL);
		request.setAttribute("list",list);
		return "/viewCategory.do";
	}

}
