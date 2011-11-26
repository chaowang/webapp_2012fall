package webapp.help.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import webapp.help.beans.ContactBean;
import webapp.help.dao.Model;
import webapp.help.utility.Category;

public class ViewCategoryAction extends Action {
	public static String actionName="viewCategory.do";
	
	public ViewCategoryAction(Model model) {
		super(model);
	}

	@Override
	public String getName() {
		return actionName;
	}

	@Override
	public String perform(HttpServletRequest request) {
		HttpSession session     = request.getSession(true); 
		List<ContactBean> list = model.getContactsDAO().getContacts(Category.GENERAL);
		session.setAttribute("contacts",list.get(0));
		
		
		
		request.setAttribute("test3",list.get(0));
		
		System.out.println("retrieved list o size " + list.size());
		
		//request.setAttribute("contact", list.get(0));
		return "viewCategory.jsp";
	}

}
