package webapp.help.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import webapp.help.beans.ContactBean;
import webapp.help.dao.Model;

public class ViewContactAction extends Action {
	public static String actionName = "viewContact.do";
	public ViewContactAction(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return actionName;
	}

	@Override
	public String perform(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String keyStr;
		ContactBean bean;
		Key key;
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors",errors);
		
		keyStr = request.getParameter("keyStr");
		if(keyStr==null){
			errors.add("can not find the contact");
			return "view/Home.jsp";
			
		}
		
		try {
			key = KeyFactory.stringToKey(keyStr);
			bean = model.getContactsDAO().getContact(key);
			request.setAttribute("currContact", bean);
			request.setAttribute("keyStr",keyStr);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			errors.add("can not find the contact");
			return "view/Home.jsp";
		}
		//return "view/Home.jsp";
		List<ContactBean> list = model.getContactsDAO().getContacts(bean.getCategory());
		request.setAttribute("list",list);
		return "view/Home.jsp";
	}

}
