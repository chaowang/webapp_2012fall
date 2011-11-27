package webapp.help.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
		String category = request.getParameter("category");
		category = (category==null?Category.GENERAL:category);
		List<ContactBean> list = model.getContactsDAO().getContacts(category);
		request.setAttribute("list",list);
		request.setAttribute("category", category);
	
		return "home.jsp";
	}

}
