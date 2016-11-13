package EmailCheck;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ObjectRepo.Elements;

public class checkEmail {
static WebDriver Net;
static int j=1;
static String url = "https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/";
@BeforeTest
public void openBrowser() {
	System.setProperty("webdriver.chrome.driver", "C:/Users/Latha/Desktop/Java/chromedriver_win32/chromedriver.exe");
	Net = new ChromeDriver();
	Net.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	Net.manage().window().maximize();
	Net.get(url);
}
	
	
@Test(dataProvider="emailAccounts")
public void executeEmail(String username, String password) {
	Elements page = PageFactory.initElements(Net, Elements.class);
	page.emailTxtBox.clear();
	page.emailTxtBox.sendKeys(username);
	page.nextButton.click();
	page.passwordTxtBox.sendKeys(password);
	page.signInButton.click();
	String inbox = page.inbox.getText();
	String numOfEmails = inbox.substring(inbox.indexOf("(")+1, inbox.indexOf(")"));
	int k=1; int b=1;
	System.out.println("**********************************************************************************************************************************************************************");
	System.out.println("Inbox Number: " + numOfEmails);
	System.out.println("Number of Emails shown on first page: " + Math.max(page.subject.size(), page.body.size()));
	System.out.println("Subject: " + username);
	for (WebElement el : page.subject) {
		String subj = el.getText();
		System.out.println("Subject: " + subj);
		if(subj.isEmpty() | subj.equals(null) | subj.equals("") | subj.length()==0 ) System.out.println("Found an email with empty subject at position: " + k);
		k++;
	}
	System.out.println("Body: " + username);
	for (WebElement el : page.body) {
		String body = el.getText(); 
		System.out.println("Body: " + body);
		if(body.isEmpty() | body.equals(null) | body.equals("") | body.length()==0 ) System.out.println("Found an email with empty body at position: " + b);
		b++;
	}
	System.out.println("**********************************************************************************************************************************************************************");
	Net.manage().deleteAllCookies();
	Net.navigate().refresh();
	Net.get(url);
	if(j<2) page.signInWithDifferentAccount.click();
	page.addAccountLinkText.click();
	j++;
}


@DataProvider(name="emailAccounts")
public Object[][] emailAccounts() {
	return new Object[][] {
		{"instructgruden1088@gmail.com","student1088"},
		{"instructjake1088@gmail.com","student1088"},
		{"instructgruden1088@gmail.com","student1088"}
	};
}



}

