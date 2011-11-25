package webapp.help.controller;

import javax.servlet.http.HttpServletRequest;

import webapp.help.dao.Model;

public class SendMessageAction extends Action {
	public static String actionName="sendMessage.do";
	public SendMessageAction(Model model) {
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
