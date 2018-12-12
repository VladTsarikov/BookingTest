package booking.carsRental.pages.menu;

import booking.carsRental.enums.RentalMenuItemName;
import framework.webdriver.elements.Label;
import org.openqa.selenium.By;

public class RentalHeaderMenu {

    private static String formatMenuLabelLocator = "//button[contains(@aria-controls,'%s')]";

    public void clickMenuItem(RentalMenuItemName itemName) {
        new Label(By.xpath(String.format(formatMenuLabelLocator,itemName.getName())),String.format("Menu Item '%s'",itemName))
                .click();
    }
}