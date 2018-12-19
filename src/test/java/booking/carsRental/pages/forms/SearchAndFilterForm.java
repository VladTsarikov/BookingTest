package booking.carsRental.pages.forms;

import booking.carsRental.enums.RentalDateType;
import booking.common.entities.Date;
import booking.common.enums.TimeName;
import booking.common.enums.Chars;
import framework.utils.CustomCalendar;
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
        super(By.id(MAIN_LOCATOR),"Search And Filter Form");
    }

    public SearchAndFilterForm setRentalTime(RentalDateType dateType, Date date){
        int increment = 1;
        String monthAndYearDate =  new StringBuilder(String.valueOf(date.getMonthIndex()+increment))
                .append(Chars.HYPHEN.getCharacter()).append(date.getYear()).toString();
        new Select(By.xpath(String.format(formatTimeLocator,dateType.getShortName(), TimeName.DAY.getName()))
                ,"Days Select").selectByValue(String.valueOf(date.getDay()));
        new Select(By.xpath(String.format(formatTimeLocator,dateType.getShortName(), TimeName.MONTH.getName()))
                ,"Month And Year Select").selectByValue(monthAndYearDate);
        new Select(By.xpath(String.format(formatTimeLocator,dateType.getShortName(), TimeName.HOUR.getName()))
                ,"Hours Select").selectByValue(CustomCalendar.splitTimeString(date.getTime())
                .get(TimeName.HOUR.getName()));
        new Select(By.xpath(String.format(formatTimeLocator,dateType.getShortName(), TimeName.MINUTE.getName()))
                ,"Minutes Select").selectByValue(CustomCalendar.splitTimeString(date.getTime())
                .get(TimeName.MINUTE.getName()));
        return this;
    }

    public void clickSearchButton(){
        btnSearch.click();
    }
}