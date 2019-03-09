import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.util.concurrent.TimeUnit;

public class RegistrationPageTest extends PageTestBase{

    private RegistrationPage registrationPage;

    @Before
    public void SetUp()
    {
        StartDriver();
        driver.get("https://www.facebook.com/r.php?locale=ru_RU");
        registrationPage =new RegistrationPage(driver);
    }

    @Test
    public void RegistrationInvalidDataSetTest()
    {
        registrationPage.RegisterWithInvalidCreds("sdgdrgdsfgfdsb","sdgdgsdgfsg","sdhgs46343434354dfhgf343");
        String errorMessage=registrationPage.GetErrorAlert();
        Assert.assertEquals("Не менее шести цифр, букв и знаков препинания (например, \"!\" или \"&\").",errorMessage);
    }

    @Test
    public void RegistrationEmptyDataSetTest()
    {
        registrationPage.RegisterWithInvalidCreds("","","");
        String errorMessage=registrationPage.GetErrorAlert();
        Assert.assertEquals("Как вас зовут?",errorMessage);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
