import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class PageTestBase {

    WebDriver driver;

    @BeforeClass
    public static void SetInitParametrs() {
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
    }

    public void StartDriver()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
}
