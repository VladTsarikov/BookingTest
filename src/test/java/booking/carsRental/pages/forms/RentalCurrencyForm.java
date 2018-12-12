package booking.carsRental.pages.forms;

import booking.common.forms.BaseCurrencyForm;
import org.openqa.selenium.By;

public class RentalCurrencyForm extends BaseCurrencyForm {
    private final static String MAIN_LOCATOR = "//div[contains(@id,'currency-select')]";
    private final static String formatCurrencyLocator = "//div[contains(@id,'currency-select')]//a[contains(@id,'%s')]";

    public RentalCurrencyForm() {
        super(By.xpath(MAIN_LOCATOR),"Rental Currency Form");
    }

    @Override
    protected String getCurrencyLocator() {
        return formatCurrencyLocator;
    }
}