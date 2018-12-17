package booking.airportTaxis.pages;

import booking.airportTaxis.enums.TaxisLocationType;
import framework.webdriver.BaseForm;
import framework.webdriver.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainTaxisPage extends BaseForm {

    private final static String MAIN_LOCATOR = "//div[contains(@class,'search-panel')]";
    private final static String formatLocationLocator = "//input[@id='%sLocation']";
    private static  @FindBy(how = How.ID, using = "ftsAutocomplete") TextBox txbSearch;
    private static  @FindBy(how = How.XPATH, using = "//a[contains(@aria-label,'date')]") TextBox lblDate;
    private static  @FindBy(how = How.XPATH, using = "//a[contains(@aria-label,'time')]") TextBox lblTime;
    private static  @FindBy(how = How.XPATH, using = "//select[@id='passengers']") Select selectPassengers;
    private static  @FindBy(how = How.XPATH, using = "//button[contains(@name,'searchButton')]") Button btnSearch;

    public MainTaxisPage() {
        super(By.xpath(MAIN_LOCATOR),"Taxis Main Page");
    }

    public void setLocation(TaxisLocationType locationType, String location){
        new TextBox(By.xpath(String.format(formatLocationLocator,locationType.getName()))
                , String.format("Location '%s' TextBox",locationType.getName())).setText(location).enter();
    }

    public void clickDateLabel(){
        lblDate.click();
    }

    public void clickTimeLabel(){
        lblTime.click();
    }

    public void setPassengersCount(int count){
        selectPassengers.selectByValue(String.valueOf(count));
    }

    public void clickSearchButton(){
        btnSearch.click();
    }
}