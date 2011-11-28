package webapp.help.controller;

import java.util.ArrayList;
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
		String category;
		List<ContactBean> list;
		
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors",errors);
		
		
		category = request.getParameter("category");
		if(category==null)
		{
			category = Category.GENERAL;
		}
		if(category==null){
			list = model.getContactsDAO().getContacts(Category.GENERAL);
		}
		else if(category.equals("General")){
			list = model.getContactsDAO().getContacts(Category.GENERAL);
		}else if(category.equals("Medical")){
			list = model.getContactsDAO().getContacts(Category.MEDICAL);
		}else if(category.equals("Car")){
			list = model.getContactsDAO().getContacts(Category.CAR);
		}else if(category.equals("Fire")){
			list = model.getContactsDAO().getContacts(Category.FIRE);
		}else{
			errors.add("no such category");
			list = model.getContactsDAO().getContacts(Category.GENERAL);
		}
		
		request.setAttribute("list",list);
		request.setAttribute("category", category);
	
		return "view/Home.jsp";
	}

}
