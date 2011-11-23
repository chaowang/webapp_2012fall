package webapp.help.controller;

import javax.servlet.http.HttpServletRequest;

import webapp.help.dao.Model;

public class LoginAction extends Action {
	private String actionName="login.do";
	public LoginAction(Model model) {
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
