import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Date;

public class RegistrationPage extends PageBase {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class=\"mbs _52lq fsl fwb fcb\"]")
    private WebElement createNewAccountLabel;

    @FindBy(xpath = "//input[@id=\"u_0_k\"]")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id=\"u_0_m\"]")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id=\"u_0_p\"]")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@id=\"u_0_12\"]")
    private WebElement registrationButton;

    @FindBy(xpath = "//div[contains(@class,'uiContextualLayerPositioner') and not(contains(@class,'hidden_elem'))]//div[@class=\"_5633 _5634 _53ij\"]")
    private WebElement errorAlert;

    public String GetCreateNewAccountLabel()
    {
        return createNewAccountLabel.getText();
    }

    public String GetErrorAlert()
    {
        return errorAlert.getText();
    }

    public RegistrationPage RegisterWithInvalidCreds(String firstName, String LastName, String email)
    {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(LastName);
        emailInput.sendKeys(email);
        registrationButton.click();
        return this;
    }

}
