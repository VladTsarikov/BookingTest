package booking.accommodation.pages.forms;

import booking.common.forms.BaseCurrencyForm;
import org.openqa.selenium.By;

public class AccommodationCurrencyForm extends BaseCurrencyForm {

    private final static String MAIN_LOCATOR = "//div[contains(@id,'currency_foldout')]";
    private final static String formatCurrencyLocator = "//div[contains(@id,'currency')]//div[@class='select_foldout_wrap']//a[@data-currency='%s']";

    public AccommodationCurrencyForm() {
        super(By.xpath(MAIN_LOCATOR),"Currency Form");
    }

    @Override
    protected String getCurrencyLocator() {
        return formatCurrencyLocator;
    }
}