<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if (user != null) {	%>
		<p>You are logged in as <%= user.getNickname() %>. <a href="<%= userService.createLogoutURL("/landing.jsp") %>">logout</a></p>
<%  } else {  %>

		<p>Please <a href="<%= userService.createLoginURL("/viewCategory.do") %>">log in</a></p>
<%  } %>