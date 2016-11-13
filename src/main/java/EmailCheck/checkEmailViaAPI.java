package EmailCheck;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

public class checkEmailViaAPI {
	
	public static void checkEmail(String host,String storeType,String user,String pwd) throws MessagingException, IOException {
		      Properties pr = new Properties();
		      pr.put("mail.pop3.host", host);
		      pr.put("mail.pop3.port", "995");
		      pr.put("mail.pop3.starttls.enable", "true");
		      Session emailSession = Session.getDefaultInstance(pr);
		      Store store = emailSession.getStore("pop3s");
		      store.connect(host, user, pwd);
		      Folder emailFolder = store.getFolder("INBOX");
		      emailFolder.open(Folder.READ_ONLY);
		      Message[] messages = emailFolder.getMessages();
		      System.out.println("Number of Emails: " + messages.length);
		      for (int a=0; a<messages.length; a++) {
		         Message msg = messages[a];
		         System.out.println("************************************************************************************************************************************************");
		         System.out.println("Email Number: " + (a + 1));
		         System.out.println("Subject: " + msg.getSubject());
		         System.out.println("From: " + msg.getFrom()[0]);
		         System.out.println("Text: " + msg.getContent().toString());
		      }
		      emailFolder.close(false);
		      store.close();
		   }

		   public static void main(String[] args) throws MessagingException, IOException {
		      String host = "pop.gmail.com";
		      String mailStoreType = "pop3";

		      checkEmail(host,mailStoreType,"instructjake1088@gmail.com","student1088");
		   }
			
			static String userName = "";
			static String passWord = "";
	
}
