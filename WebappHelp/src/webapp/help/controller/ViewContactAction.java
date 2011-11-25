package webapp.help.controller;

import javax.servlet.http.HttpServletRequest;

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
		return "test.jsp";
	}

}
