package webapp.help.controller;

import javax.servlet.http.HttpServletRequest;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import webapp.help.dao.Model;
import webapp.help.utility.Category;
import webapp.help.utility.Mailer;

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
		double longitude = Double.parseDouble(request.getParameter("longitude"));
		double latitude = Double.parseDouble(request.getParameter("latitude"));
		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();
		
		System.err.println("lol?");
		Mailer.sendMesssages(model.getContactsDAO().getContacts(Category.GENERAL), longitude, latitude);
		System.err.println(":)");;
		return "/viewCategory.do";
	}

}
