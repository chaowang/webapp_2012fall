package webapp.help.controller;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.users.UserServiceFactory;

import webapp.help.dao.Model;

public class LoginAction extends Action {
	public static String actionName="login.do";
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
		return UserServiceFactory.getUserService().createLoginURL(request.getRequestURI());
	}

}
