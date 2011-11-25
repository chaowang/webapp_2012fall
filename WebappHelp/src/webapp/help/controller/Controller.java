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
	
	
	public void init() throws ServletException {
		Model model = new Model();
//		Action.add(new AddContactAction(model));
//		Action.add(new EditContactAction(model));
//		Action.add(new DeleteContactAction(model));
//		Action.add(new ViewCategoryAction(model));
//		Action.add(new ViewContactAction(model));
//		Action.add(new SendMessageAction(model));
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	
	//	String nextPage = performTheAction(req);
    //	sendToNextPage(nextPage,req,resp);
		sendToNextPage("guestbook.jsp",req,resp);
	}	
	private String performTheAction(HttpServletRequest request) {
	    HttpSession session     = request.getSession(true);
	    String      servletPath = request.getServletPath();
	    UserService userService = UserServiceFactory.getUserService();
	    User 		user 		= userService.getCurrentUser(); 
	    String      actionName  = getActionName(servletPath);
	    
	    
		return Action.perform(actionName,request);
	}
	private String getActionName(String path) {
        int slash = path.lastIndexOf('/');
        return path.substring(slash+1);
    }
	
	private void sendToNextPage(String nextPage, HttpServletRequest request, HttpServletResponse response) throws IOException{
    	if (nextPage == null) {
    		response.sendError(HttpServletResponse.SC_NOT_FOUND,request.getServletPath());
    		return;
    	}
    	
    	if (nextPage.charAt(0) == '/') {
    		String proto = request.isSecure() ? "https://" : "http://";
			String host  = request.getServerName();
			String port  = ":"+String.valueOf(request.getServerPort());
			if (port.equals(":80")) port = "";
			if (port.equals(":443")) port = "";
			String context = request.getContextPath();
			int lastSlash = context.lastIndexOf('/');
			String prefix = ( lastSlash==0 ? context : context.substring(0,lastSlash) );
			response.sendRedirect(proto+host+port+prefix+nextPage);
			return;
    	}
    	
   		RequestDispatcher d = request.getRequestDispatcher("/view/"+nextPage);
   		try {
			d.forward(request,response);
		} catch (ServletException e) {
			// TODO FIX THIS LATER.
			e.printStackTrace();
		}
    }
}
