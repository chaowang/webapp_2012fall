package webapp.help.test;

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
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		doGet(req, resp);
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	sendToNextPage("test.jsp",req,resp);
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
    	
   		RequestDispatcher d = request.getRequestDispatcher("/"+nextPage);
   		try {
			d.forward(request,response);
		} catch (ServletException e) {
			// TODO FIX THIS LATER.
			e.printStackTrace();
		}
    }
}
