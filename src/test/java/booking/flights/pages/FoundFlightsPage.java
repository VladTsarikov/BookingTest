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
    private static String flightsDurationLocator = "//div[contains(@class,'duration')]//div[@class='top']";
    private static String flightsPriceLocator = "//a[contains(@id,'price')]/span[contains(@class,'price')]";
    private static String formatSortOptionLocator = "//ul[contains(@id,'dropdownDialogList')]//li[contains(@id,'%s')]";
    private static String flightsLocator = "(//div[contains(@class,'Flights-Results')]//div[@class='resultWrapper'])[%s]";
    private static  @FindBy(how = How.XPATH, using = "//div[contains(@id,'sortType')]/span") ComboBox selectSortBy;
    private static  @FindBy(how = How.XPATH, using = "//div[@class='count']//span[@class='filtered']") Label lblResultCount;
    public MainHeaderMenu mainHeaderMenu = new MainHeaderMenu();

    public FoundFlightsPage() {
        super(By.xpath(MAIN_LOCATOR),"Found Flights Page");
    }

    public void sortBy(SortCriteria criteria){
        selectSortBy.click();
        new Label(By.xpath(String.format(formatSortOptionLocator,criteria.getValue())),"Sort Option Label").click();
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
        List<WebElement> durations = new Label(By.xpath(String.format(flightsLocator,flightIndex)),"Flight Label")
                .getChildren(By.xpath(flightsDurationLocator));
        for (WebElement duration : durations) {
            hours += Integer.parseInt(RegExpFinder.findByRegularExp(duration.getText(), RegExp.HOUR.getRegExp()));
            minutes += Integer.parseInt(RegExpFinder.findByRegularExp(duration.getText(), RegExp.MINUTES.getRegExp()));
        }
        return minutes/minutesPerHour + hours;
    }

    public int getFoundResultCount(){
        return Integer.parseInt(lblResultCount.getText());
    }
}