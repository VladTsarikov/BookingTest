package booking.common.menu;

import framework.webdriver.elements.Label;
import org.openqa.selenium.By;

public class MainNavigateMenu {

    private static String formatMenuLabelLocator = "//div[contains(@class,'product-bar')]/*[contains(@data-ga-track,'%s')]";

    public void clickMenuItem(String itemName) {
        new Label(By.xpath(String.format(formatMenuLabelLocator,itemName)),String.format("Menu Item '%s'",itemName))
                .click();
    }
}