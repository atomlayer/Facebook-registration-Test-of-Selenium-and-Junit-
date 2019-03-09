import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//div[@class='_4rbf _53ij']")
    private WebElement emailErrorAlert;

    @FindBy(xpath = "//input[@id=\"pass\"]")
    private WebElement passInput;

    @FindBy(xpath = "//button[@id='loginbutton']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@class=\"_42ft _4jy0 signup_btn _4jy4 _4jy2 selected _51sy\"]")
    private WebElement createNewAccountButton;

    public LoginPage TypeEmail(String email)
    {
        emailInput.sendKeys(email);
        return this;
    }

    public LoginPage TypePass(String pass)
    {
        passInput.sendKeys(pass);
        return this;
    }

    public String GetEmailErrorAlert()
    {
        return emailErrorAlert.getText();
    }

    public LoginPage loginWithInvalidCreds(String email, String pass)
    {
        TypeEmail(email).TypePass(pass).loginButton.click();
        return this;
    }

    public RegistrationPage CreateNewAccount()
    {
        createNewAccountButton.click();

        return new RegistrationPage(driver);
    }

}
