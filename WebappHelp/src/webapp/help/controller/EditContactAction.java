package webapp.help.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import webapp.help.beans.ContactBean;
import webapp.help.dao.Model;

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
		ContactBean bean = ContactBean.createBean(request);
		ContactBean redundent;
		
		button = request.getParameter("button");
		
		if(button.equals("cancel")){
			List<ContactBean> list = model.getContactsDAO().getContacts(bean.getCategory());
			request.setAttribute("list",list);
			request.setAttribute("currContact",bean);
			request.setAttribute("category",bean.getCategory());
			return "view/Home.jsp";
		}else if (button.equals("save")){
			
			
			errors.addAll(bean.getValidationErrors());
			
			redundent =model.getContactsDAO().getContact(bean.getEmail());
			if(redundent!=null){
				if(!redundent.getKeyStr().equals(bean.getKeyStr())){
					errors.add("the email of the contact is already in your contacts list");
				}
			}
			if(errors.size()>0){
				request.setAttribute("contact", bean);
				return "view/edit.jsp";
			}
			
			Key key = KeyFactory.stringToKey(request.getParameter("keyStr"));
			model.getContactsDAO().updateContacts(bean,key);	
			
			List<ContactBean> list = model.getContactsDAO().getContacts(bean.getCategory());
			request.setAttribute("list",list);
			request.setAttribute("currContact",bean);
			request.setAttribute("category",bean.getCategory());
			
			return "view/Home.jsp";
		}
		else{
			errors.add("unknown button");
			request.setAttribute("contact", bean);
			return "view/edit.jsp";
			
		}
		
	
	}

}
