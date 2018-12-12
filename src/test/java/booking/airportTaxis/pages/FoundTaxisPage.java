package booking.airportTaxis.pages;

import framework.webdriver.BaseForm;
import framework.webdriver.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FoundTaxisPage extends BaseForm {

    private final static String MAIN_LOCATOR = "//div[contains(@data-component-name,'SearchResults')]";
    private static String foundTaxiLocator = "//div[contains(@class,'aside')]";
    private static  @FindBy(how = How.XPATH, using = "//div[contains(@data-component-name,'SearchResults')]/div[contains(@class,'results')]") Label lblResult;

    public FoundTaxisPage() {
        super(By.xpath(MAIN_LOCATOR),"Found Taxis Page");
    }

    public int getFoundTaxisCount(){
        return lblResult.getChildren(By.xpath(foundTaxiLocator)).size();
    }
}