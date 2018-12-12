package booking.airportTaxis.pages.forms;

import booking.common.enums.TimeName;
import framework.utils.CustomCalendar;
import framework.webdriver.BaseForm;
import framework.webdriver.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TaxisTimeForm extends BaseForm {

    private final static String MAIN_LOCATOR = "//header[contains(@class,'time-picker')]";
    private final static String formatTimeLocator = "//select[@id='pickup%s']";
    private static  @FindBy(how = How.XPATH, using = "//button[contains(@class,'confirm')]") Button btnConfirm;

    public TaxisTimeForm() {
        super(By.xpath(MAIN_LOCATOR),"Taxis Time Form");
    }

    public TaxisTimeForm setTime(String time){
        new Select(By.xpath(String.format(formatTimeLocator,TimeName.HOUR.getName())),"Hour Time Select")
                .selectByValue(CustomCalendar.splitTimeString(time).get(TimeName.HOUR.getName()));
        new Select(By.xpath(String.format(formatTimeLocator,TimeName.MINUTE.getName())),"Minute Time Select")
                .selectByValue(CustomCalendar.splitTimeString(time).get(TimeName.MINUTE.getName()));
        return this;
    }

    public void clickConfirmButton(){
        btnConfirm.click();
    }
}