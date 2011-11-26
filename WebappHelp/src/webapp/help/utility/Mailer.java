package webapp.help.utility;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import webapp.help.beans.ContactBean;
import java.util.Properties;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

public class Mailer {
	public static boolean sendMesssages(List<ContactBean> contacts, double longitude, double latitude){
		Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        User user = UserServiceFactory.getUserService().getCurrentUser();

        try {
            Message msg;
            Multipart mp;
            MimeBodyPart htmlPart;
            for(ContactBean contact: contacts){
            	mp = new MimeMultipart();
            	htmlPart = new MimeBodyPart();
            	
            	msg = new MimeMessage(session);
            
	            msg.setFrom(new InternetAddress(user.getEmail(), user.getNickname()));
	            msg.addRecipient(Message.RecipientType.TO,
	                             new InternetAddress(contact.getEmail(), contact.getName()));
	            msg.setSubject("I need your help!");
	            
	            msg.setContent(contact.getMessage() + generateMap(longitude, latitude),"text/html");
	            //mp.addBodyPart(htmlPart);
	            //msg.setContent(mp);
	            Transport.send(msg);
            }
        } catch (AddressException e) {
           	return false;
        } catch (MessagingException e) {
        	return false;
        } catch (UnsupportedEncodingException e) {
			return false;
		}
        return true;
	}
	
	public static String generateMap(double longitude, double latitude){
		StringBuffer sb = new StringBuffer();
	
		sb.append("<br><a href=\"http://maps.google.com/maps?q="+latitude+","+longitude+"&amp;ie=UTF8&amp;t=h&amp;z=14&amp;vpsrc=0&amp;ll="+latitude+","+longitude+"&amp;source=embed\" style=\"color:#0000FF;text-align:left\">");
		sb.append("<img src=\"http://maps.googleapis.com/maps/api/staticmap?center="+latitude+","+longitude+"&zoom=14&size=400x400&sensor=false&markers=color:red%7Clable:A%7C"+latitude+","+longitude+"\"/></a>");
		
		return sb.toString();
	}
}


