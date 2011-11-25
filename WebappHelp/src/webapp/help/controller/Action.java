package webapp.help.controller;

import java.util.Hashtable;
import javax.servlet.http.HttpServletRequest;

import webapp.help.dao.Model;

public abstract class Action {
    public abstract String getName();
    public abstract String perform(HttpServletRequest request);

    private static Hashtable<String,Action> hash = new Hashtable<String,Action>();
    protected Model model;
    
    public Action(Model model){
    	this.model = model;
    }
    
    public static void add(Action a) {
        hash.put(a.getName(),a);
    }

    public static String perform(String name,HttpServletRequest request) {
        Action a = hash.get(name);
        if (a == null) return "error.jsp";
        return a.perform(request);
    }
}
