import java.io.IOException;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

/**
 * 
 */

/**
 * @author nalin
 * @since May 21, 2017
 *
 */
public class SendEmail {
	
	//Replace with your own API KEY
	private static final String SendGrid_Api_Key = "SG.8NDrTwafQ9y5Z5PHiHsziA.UMbzjIPq10hJHrNgTLodKXTcaefw-48KoyryP8LGGKM8";
	private static final String FROM = "test@example.com";
	private static final String SUBJECT = "Sending with SendGrid is Fun";
	private static final String TO = "validemail@somedomain.com";
	private static final String BODY = "This is test email using SENDGRID !";
	
	/**
	 * <h1>Main method.</h1>
	 * 
	 * @author nalin
	 * @since May 21, 2017
	 * @param args
	 */
	public static void main(String [] args) {
		try {
			send(FROM, TO, SUBJECT, BODY);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <h1>Sending email using sendgrid API.</h1>
	 * 
	 * @author nalin
	 * @since May 21, 2017
	 * @throws IOException
	 */
	public static void send(String from, String to, String subject, String body) throws IOException{
	    Mail mail = new Mail(new Email(FROM), subject, new Email(TO), new Content("text/plain", BODY));

	    SendGrid sg = new SendGrid(SendGrid_Api_Key);
	    Request request = new Request();
	    try {
	      request.method = Method.POST;
	      request.endpoint = "mail/send";
	      request.body = mail.build();
	      Response response = sg.api(request);
	      System.out.println(response.statusCode);
	      System.out.println(response.body);
	      System.out.println(response.headers);
	    } catch (IOException ex) {
	      throw ex;
	    }
	}
}
