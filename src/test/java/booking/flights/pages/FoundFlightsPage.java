package booking.flights.pages;

import booking.common.enums.RegExp;
import booking.common.menu.MainHeaderMenu;
import booking.flights.enums.SortCriteria;
import framework.utils.RegExpFinder;
import framework.webdriver.BaseForm;
import framework.webdriver.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;

public class FoundFlightsPage extends BaseForm {

    private final static String MAIN_LOCATOR = "//div[contains(@id,'leftRail')]//div[@class='resultsCount']";
    private static String flightsDurationLocator = "(//div[@class='resultWrapper'])[%s]//div[contains(@class,'duration')]//div[@class='top']";
    private static String flightsPriceLocator = "//a[contains(@id,'price')]/span[contains(@class,'price')]";
    private static String formatSortOptionLocator = "//ul[contains(@id,'dropdownDialogList')]//li[contains(@id,'%s')]";
    private static String flightsLocator = "(//div[@class='resultWrapper'])[%s]";
    private static  @FindBy(how = How.XPATH, using = "//div[contains(@id,'sortType')]/span") ComboBox selectSortBy;
    private static  @FindBy(how = How.XPATH, using = "//div[@class='count']//span[@class='filtered']") Label lblResultCount;
    private static  @FindBy(how = How.XPATH, using = "//div[@id='searchResultsList']") Label lblResultList;
    public MainHeaderMenu mainHeaderMenu = new MainHeaderMenu();

    public FoundFlightsPage() {
        super(By.xpath(MAIN_LOCATOR),"Found Flights Page");
    }

    public FoundFlightsPage sortBy(SortCriteria criteria){
        selectSortBy.click();
        new Label(By.xpath(String.format(formatSortOptionLocator,criteria.getValue())),"Sort Option Label").click();
        return this;
    }

    public int getFlightsPrice(int flightsIndex){
        return Integer.parseInt(RegExpFinder.findByRegularExp(new Label(By.xpath(new StringBuilder(String
                .format(flightsLocator,flightsIndex)).append(flightsPriceLocator)
                .toString()),"Flights Price Locator").getText(), RegExp.ACCOMMODATION_COUNT.getRegExp()));
    }

    public double getFlightsDuration(int flightIndex){
        int minutesPerHour = 60;
        int hours = 0;
        int minutes = 0;
        List<WebElement> durations = lblResultList.getChildren(By.xpath(String.format(flightsDurationLocator,flightIndex)));
        for (WebElement duration : durations) {
            Label lblFlightDuration = new Label(duration);
            hours += Integer.parseInt(RegExpFinder.findByRegularExp(lblFlightDuration.getText(), RegExp.HOUR.getRegExp()));
            minutes += Integer.parseInt(RegExpFinder.findByRegularExp(lblFlightDuration.getText(), RegExp.MINUTES.getRegExp()));
        }
        return minutes/minutesPerHour + hours;
    }

    public int getFoundResultCount(){
        return Integer.parseInt(lblResultCount.getText());
    }
}