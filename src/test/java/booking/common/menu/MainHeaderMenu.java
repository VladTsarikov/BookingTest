package booking.common.menu;

import booking.common.enums.HeaderMenuItem;
import framework.webdriver.elements.Label;
import org.openqa.selenium.By;

public class MainHeaderMenu {

    private static String formatMenuLabelLocator = "//a[contains(@class,'%sPicker')]";

    public void clickMenuItem(HeaderMenuItem itemName) {
        new Label(By.xpath(String.format(formatMenuLabelLocator,itemName.getName())),String.format("Menu Item '%s'",itemName))
                .click();
    }
}