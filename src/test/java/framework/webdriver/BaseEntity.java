package framework.webdriver;

import framework.utils.Logger;
import framework.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseEntity {

    private static PropertyReader seleniumProperty = new PropertyReader("selenium.properties");
    protected static WebDriver driver;

    @BeforeMethod
    public static void before(){
        Logger.log("Starting tests...");
        driver = Browser.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(seleniumProperty
                .getProperty("defaultConditionTimeout")), TimeUnit.SECONDS);
        driver.get(seleniumProperty.getProperty("url"));
    }

    @AfterSuite
    public static void after(){
        Logger.log("Ending tests...");
        driver.quit();
    }

    protected void selectLastOpenedWindow(){
        Browser.selectLastWindow();
    }
}