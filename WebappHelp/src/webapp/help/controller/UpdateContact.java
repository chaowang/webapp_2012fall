package webapp.help.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import webapp.help.beans.ContactBean;
import webapp.help.dao.Model;

public class UpdateContact extends Action {
	public static String actionName="updateContact.do";
	public UpdateContact(Model model) {
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
		String keyStr = request.getParameter("keyStr");
		String category = request.getParameter("category");
		
		if(keyStr==null||keyStr.equals("")){
			errors.add("no contact is selected");
			List<ContactBean> list = model.getContactsDAO().getContacts(category);
			request.setAttribute("list",list);
			request.setAttribute("category", category);
			return "view/Home.jsp";
		}
		Key key=KeyFactory.stringToKey(keyStr);
		

		String button;
		button = request.getParameter("button");
		
		if(button.equals("remove")){
		
			model.getContactsDAO().deleteContact(key);
			List<ContactBean> list = model.getContactsDAO().getContacts(category);
			request.setAttribute("list",list);
			request.setAttribute("category", category);

			return "view/Home.jsp";
		}
		else if(button.equals("edit")){
			try {
				
				request.setAttribute("contact", model.getContactsDAO().getContact(key));
				return "view/edit.jsp";
			} catch (EntityNotFoundException e) {
				// TODO Auto-generated catch block
				errors.add(e.toString());
				List<ContactBean> list = model.getContactsDAO().getContacts(category);
				request.setAttribute("list",list);
				request.setAttribute("category", category);
				return "view/Home.jsp";
			}
			
		}
		else{
			errors.add("unknown action");
			List<ContactBean> list = model.getContactsDAO().getContacts(category);
			request.setAttribute("list",list);
			request.setAttribute("category", category);
			return "view/Home.jsp";
		}



	
		
		
	}

}
