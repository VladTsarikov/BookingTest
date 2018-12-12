package booking.carsRental.pages.forms;

import booking.carsRental.enums.RentalDateType;
import booking.common.enums.TimeName;
import booking.common.enums.Month;
import booking.flights.enums.Chars;
import framework.webdriver.BaseForm;
import framework.webdriver.elements.Button;
import framework.webdriver.elements.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchAndFilterForm extends BaseForm {

    private final static String MAIN_LOCATOR = "searchAgainTop";
    private static String formatTimeLocator = "//select[contains(@id,'%s%s')]";
    private static  @FindBy(how = How.XPATH, using = "//button[contains(@class,'proceed-btn')]") Button btnSearch;

    public SearchAndFilterForm() {
        super(By.id(MAIN_LOCATOR),"Cars Rental Main Page");
    }

    public void setRentalTime(RentalDateType dateType, String day, Month month, String year, String time){
        int increment = 1;
        int hoursIndex = 0;
        int minutesIndex = 1;
        String monthAndYearDate =  new StringBuilder(String.valueOf(month.getIndex()+increment))
                .append(Chars.HYPHEN.getCharacter()).append(year).toString();
        String[] hoursAndMinutes = time.split(Chars.COLON.getCharacter());
        new Select(By.xpath(String.format(formatTimeLocator,dateType.getShortName(), TimeName.DAY.getName()))
                ,"Days Select").selectByValue(day);
        new Select(By.xpath(String.format(formatTimeLocator,dateType.getShortName(), TimeName.MONTH.getName()))
                ,"Month And Year Select").selectByValue(monthAndYearDate);
        new Select(By.xpath(String.format(formatTimeLocator,dateType.getShortName(), TimeName.HOUR.getName()))
                ,"Hours Select").selectByValue(hoursAndMinutes[hoursIndex]);
        new Select(By.xpath(String.format(formatTimeLocator,dateType.getShortName(), TimeName.MINUTE.getName()))
                ,"Minutes Select").selectByValue(hoursAndMinutes[minutesIndex]);
    }

    public void clickSearchButton(){
        btnSearch.click();
    }
}