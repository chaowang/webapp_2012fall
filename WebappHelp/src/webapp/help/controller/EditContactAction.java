package webapp.help.controller;

import javax.servlet.http.HttpServletRequest;

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
		// TODO Auto-generated method stub
		return null;
	}

}
