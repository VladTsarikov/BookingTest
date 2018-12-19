package booking.flights.pages;

import booking.common.enums.RegExp;
import booking.flights.enums.*;
import framework.utils.RegExpFinder;
import framework.webdriver.BaseForm;
import framework.webdriver.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainFlightsPage extends BaseForm {

    private final static String MAIN_LOCATOR = "//div[contains(@class,'form-container')]";
    private final static String formatFlightTypeLocator = "//div[contains(@class,'Block')]//label[contains(@id,'%s')]/span";
    private final static String formatWayLocator = "//div[contains(@class,'form-inner')]//input[@name ='%s']";
    private final static String formatDateLocator = "//div[contains(@id,'%s-input')]";
    private final static String formatTimeLocator = "//select[contains(@id,'time%s')]";
    private static  @FindBy(how = How.XPATH, using = "//div[contains(@class,'field')]/button[contains(@class,'search')]") Button btnSearch;

    public MainFlightsPage() {
        super(By.xpath(MAIN_LOCATOR),"Main Flights Page");
    }

    public void selectFlightTypeLabel(FlightType flightType){
        new Label(By.xpath(String.format(formatFlightTypeLocator,flightType.getValue())), String
                .format("Flight Type '%s' Label",flightType)).click();
    }

    public MainFlightsPage setDirection(Direction direction, String text){
        new TextBox(By.xpath(String.format(formatWayLocator,direction.getValue())),"Direction TextBox")
                .setTextByChar(text);
        return this;
    }

    public void clickDate(DateType date){
        new Label(By.xpath(String.format(formatDateLocator,date.getValue())),"Date TextBox").click();
    }

    public void clickSearchButton(){
        btnSearch.clickViaJS();
    }

    public MainFlightsPage selectTime(TimeNumber number, String value){
        String selectValue = RegExpFinder.findByRegularExp(value, RegExp.TIME_FOR_SELECT.getRegExp());
        new Select(By.xpath(String.format(formatTimeLocator,number.getValue())),"Time Select")
                .selectByValue(selectValue);
        return this;
    }
}