import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.concurrent.TimeUnit;

public class LoginPageTest extends PageTestBase{

    private LoginPage loginPage;

    @Before
    public void SetUp()
    {
        StartDriver();
        driver.get("https://www.facebook.com/login/");
        loginPage =new LoginPage(driver);
    }

    @Test
    public void SignUpInvalidDataTest()
    {
        loginPage.loginWithInvalidCreds("eg511351164843sdfg43gs3g6sg836464","2163436436463454gdh");
        String errorMessage = loginPage.GetEmailErrorAlert();
        Assert.assertEquals("Эл. адрес или номер телефона, который вы указали, не соответствует ни одному аккаунту. Зарегистрируйте аккаунт.",errorMessage);
    }

    @Test
    public void SignUpEmptyDataTest()
    {
        loginPage.loginWithInvalidCreds("","");
        String errorMessage = loginPage.GetEmailErrorAlert();
        Assert.assertEquals("Эл. адрес или номер телефона, который вы указали, не соответствует ни одному аккаунту. Зарегистрируйте аккаунт.",errorMessage);
    }

    @Test
    public void RegisterTest()
    {
        RegistrationPage registrationPage = loginPage.CreateNewAccount();
        String createNewAccountLabel =registrationPage.GetCreateNewAccountLabel();
        Assert.assertEquals("Создать новый аккаунт",createNewAccountLabel);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
