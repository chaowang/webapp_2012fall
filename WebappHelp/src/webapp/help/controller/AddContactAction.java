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
		String button;
		ContactBean bean;
		String category = request.getParameter("category");
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors",errors);
		
		button = request.getParameter("button");
		
		if(button.equals("cancel")){
			List<ContactBean> list = model.getContactsDAO().getContacts(category);
			request.setAttribute("list",list);
			request.setAttribute("category", category);
			return "view/Home.jsp";
		}else if (button.equals("save")){
			bean = ContactBean.createBean(request);
			
			errors.addAll(bean.getValidationErrors());
			if(errors.size()>0){
				request.setAttribute("contact", bean);
				request.setAttribute("category", category);
				return "view/add.jsp";
			}
			
			model.getContactsDAO().addContact(bean);
			List<ContactBean> list = model.getContactsDAO().getContacts(bean.getCategory());
			request.setAttribute("list",list);
			request.setAttribute("currContact", bean);
			request.setAttribute("keyStr", bean.getKey());
			request.setAttribute("category", bean.getCategory());
			return "view/Home.jsp";
		}
		else{
			bean = ContactBean.createBean(request);
			errors.add("unknown button");
			request.setAttribute("contact", bean);
			request.setAttribute("category", category);
			return "view/add.jsp";
			
		}
			
		
		
	}

}
