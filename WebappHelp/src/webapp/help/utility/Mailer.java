package webapp.help.utility;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
            for(ContactBean contact: contacts){
            	msg = new MimeMessage(session);
            
	            msg.setFrom(new InternetAddress(user.getEmail(), user.getNickname()));
	            msg.addRecipient(Message.RecipientType.TO,
	                             new InternetAddress(contact.getEmail(), contact.getName()));
	            msg.setSubject("Your Example.com account has been activated");
	            msg.setText(contact.getMessage() + " I am currently at (" + longitude + "," + latitude + ")");
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
}
