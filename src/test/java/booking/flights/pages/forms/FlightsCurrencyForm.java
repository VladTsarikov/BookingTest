package booking.flights.pages.forms;

import booking.common.forms.BaseCurrencyForm;
import org.openqa.selenium.By;

public class FlightsCurrencyForm extends BaseCurrencyForm {

    private final static String MAIN_LOCATOR = "//div[@class='all-currencies']";
    private final static String formatCurrencyLocator = "//a[@data-cur='%s']";

    public FlightsCurrencyForm() {
        super(By.xpath(MAIN_LOCATOR),"Flights Currency Form");
    }

    @Override
    protected String getCurrencyLocator() {
        return formatCurrencyLocator;
    }
}