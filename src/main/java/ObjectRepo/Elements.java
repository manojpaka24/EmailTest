package ObjectRepo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ObjectPaths.ElementPath;

public class Elements {
	
	@FindBy(xpath=ElementPath.emailField)
	public WebElement emailTxtBox;
	@FindBy(xpath=ElementPath.pwdField)
	public WebElement passwordTxtBox;
	@FindBy(xpath=ElementPath.nextBtn)
	public WebElement nextButton;
	@FindBy(xpath=ElementPath.signInBtn)
	public WebElement signInButton;
	@FindBy(xpath=ElementPath.inboxLink)
	public WebElement inbox;
	@FindBy(xpath=ElementPath.starredLink)
	public WebElement starred;
	@FindBy(xpath=ElementPath.EmailsSubject)
	public List<WebElement> subject;
	@FindBy(xpath=ElementPath.EmailsBody)
	public List<WebElement> body;
	@FindBy(linkText=ElementPath.singInWithDifferentAccount)
	public WebElement signInWithDifferentAccount;
	@FindBy(linkText=ElementPath.addAccountLinkText)
	public WebElement addAccountLinkText;
	@FindBy(linkText=ElementPath.accountIcon)
	public WebElement accountIcon;	
	@FindBy(xpath=ElementPath.signOut)
	public WebElement signOut;
}
