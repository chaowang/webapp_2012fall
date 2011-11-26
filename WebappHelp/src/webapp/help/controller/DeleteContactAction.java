package webapp.help.controller;

import java.util.ArrayList;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import webapp.help.beans.ContactBean;
import webapp.help.dao.Model;
import webapp.help.utility.Category;

public class DeleteContactAction extends Action {
	public static String actionName="deleteContact.do";
	public DeleteContactAction(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return actionName;
	}

	@Override
	public String perform(HttpServletRequest request) {
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors",errors);


        String key = request.getParameter("key");
	
        Key toDelete =KeyFactory.stringToKey(key);
        
		model.getContactsDAO().deleteContact(toDelete);

		List<ContactBean> list = model.getContactsDAO().getContacts(Category.GENERAL);
		request.setAttribute("list",list);

		return "viewCategory.jsp";



	}

}
