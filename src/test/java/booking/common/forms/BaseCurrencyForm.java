package booking.common.forms;

import booking.common.enums.Currency;
import framework.webdriver.BaseForm;
import framework.webdriver.elements.Label;
import org.openqa.selenium.By;

public abstract class BaseCurrencyForm extends BaseForm {

    public BaseCurrencyForm(By locator, String formTitle) {
        super(locator,formTitle);
    }

    public void selectCurrency(Currency currency){
        new Label(By.xpath(String.format(getCurrencyLocator(),currency.toString()))
                ,String.format("Currency '%s' Label",currency.toString())).click();
    }

    protected abstract String getCurrencyLocator();
}