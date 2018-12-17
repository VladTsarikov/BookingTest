package booking.accommodation.pages.menu;

import booking.accommodation.enums.UserMenuItemName;
import framework.webdriver.elements.Label;
import org.openqa.selenium.By;

public class UserFomMenu {

    private static String formatMenuLabelLocator = "//div[@id='user_form']//a[contains(@class,'%s')]";

    public void clickMenuItem(UserMenuItemName itemName) {
        new Label(By.xpath(String.format(formatMenuLabelLocator,itemName.getName()))
                ,String.format("Menu Item '%s'",itemName)).click();
    }

    public String getCurrentCurrency(){
        return new Label(By.xpath(String.format(formatMenuLabelLocator,UserMenuItemName.CURRENCY.getName()))
                ,String.format("Menu Item '%s'",UserMenuItemName.CURRENCY.getName())).getText();
    }
}