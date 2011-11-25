package webapp.help.controller;
import java.io.IOException;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import webapp.help.dao.Model;
import com.google.appengine.api.users.User;
@SuppressWarnings("serial")
public class Controller extends HttpServlet {	
	Model model;
	
	@Override
	public void init(){
		model = new Model();
		Action.add(new AddContactAction(model));
		Action.add(new EditContactAction(model));
		Action.add(new DeleteContactAction(model));
		Action.add(new ViewCategoryAction(model));
		
		Action.add(new ViewContactAction(model));
		Action.add(new SendMessageAction(model));
		Action.add(new LoginAction(model));
		System.err.println("initialized .... ");
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String nextPage = performTheAction(req);
		resp.sendRedirect(nextPage);
	}	
	private String performTheAction(HttpServletRequest request) {
	    String      servletPath = request.getServletPath();
	    UserService userService = UserServiceFactory.getUserService();
	    User 		user 		= userService.getCurrentUser(); 
	    String      actionName  = getActionName(servletPath);

	    // first landing
	    if(actionName == null || actionName.length() == 0){
	    	if(user == null){
	    		return "landing.jsp";
	    	}
	    	else{
	    		return "viewCategory.jsp";
	    	}
	    }
	    
	    // trying to access any other page and if not logged in, must log in.
	    if(user == null){
	    	request.setAttribute("redirect", "/"+actionName);
	    	actionName = LoginAction.actionName;
	    }
	    
		return Action.perform(actionName,request);
	}
	
	private String getActionName(String path) {
        int slash = path.lastIndexOf('/');
        return path.substring(slash+1);
    }
}
