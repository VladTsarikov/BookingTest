package framework.webdriver.waitings;

import framework.enums.LogType;
import framework.utils.Logger;
import framework.webdriver.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import java.util.concurrent.TimeUnit;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Waiting {

    public static <T> T waitFor(ExpectedCondition<T> condition) {
        return waitFor(condition, Long.parseLong("15"));
    }

    /**
     * Wait for some object from condition with timeout. Wait until it's not false or null.
     * @param condition Condition for waiting {@link ExpectedCondition}
     * @param timeOutInSeconds Timeout in seconds
     * @param <T> Object for waiting
     * @return Object from condition
     */
    public static <T> T waitFor(ExpectedCondition<T> condition, long timeOutInSeconds) {
        int duration = 300;
        long implicitTimeOut = 0L;
        Browser.getDriver().manage().timeouts().implicitlyWait(implicitTimeOut, TimeUnit.MILLISECONDS);
        Wait<WebDriver> wait = new FluentWait<>((WebDriver) Browser.getDriver())
                .withTimeout(timeOutInSeconds, SECONDS)
                .pollingEvery(duration, TimeUnit.MILLISECONDS);

        try {
            return wait.until(condition);
        } catch (Exception | AssertionError e) {
            Logger.log(LogType.DEBUG, e);
        } finally {
            Browser.getDriver().manage().timeouts().implicitlyWait(Long.parseLong(Browser
                    .getDefaultConditionTimeout()), SECONDS);
        }
        return null;
    }

    public static void waitForPageIsReady(){
        WebDriverWait wait = new WebDriverWait(Browser.getDriver(), Long.parseLong(Browser
                .getDefaultConditionTimeout()));
        wait.until(Condition.documentNotActiveCondition());
        wait.until(Condition.JQueryLoadCondition());
        wait.until(Condition.JStoLoadCondition());
    }
}