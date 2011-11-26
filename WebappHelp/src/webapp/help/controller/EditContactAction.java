package webapp.help.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import webapp.help.beans.ContactBean;
import webapp.help.dao.Model;
import webapp.help.utility.Category;

public class EditContactAction extends Action {
	public static String actionName="editContact.do";
	public EditContactAction(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		return actionName;
	}

	@Override
	public String perform(HttpServletRequest request) {
		String button;
		List<String> errors = new ArrayList<String>();
		request.setAttribute("errors",errors);
		
		button = request.getParameter("button");
		if(button.equals("cancel")){
			return "viewCategory.jsp";
		}else if (button.equals("save")){
			ContactBean bean = ContactBean.createBean(request);
			
			errors.addAll(bean.getValidationErrors());
			if(errors.size()>0){
				return "editContacts.jsp";
			}
			
			Key key = KeyFactory.stringToKey(request.getParameter("keyStr"));
			model.getContactsDAO().updateContacts(bean,key);	
			
			List<ContactBean> list = model.getContactsDAO().getContacts(Category.GENERAL);
			request.setAttribute("list",list);

			return "viewCategory.jsp";
		}
		else{
			errors.add("unknown button");
			return "editContacts.jsp";
			
		}
		
	
	}

}
