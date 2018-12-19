package booking.carsRental.pages;

import booking.carsRental.enums.RentalSortCriteria;
import booking.carsRental.pages.menu.RentalHeaderMenu;
import booking.common.enums.RegExp;
import framework.utils.RegExpFinder;
import framework.webdriver.BaseForm;
import framework.webdriver.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchCarPage extends BaseForm {

    private final static String MAIN_LOCATOR = "//div[contains(@class,'Categories-row')]";
    private static  @FindBy(how = How.XPATH, using = "//div[contains(@class,'Categories-row')]") Label lblCarsTypeBoxLabel;
    private static String formatCarsTypeLocator = "//a[contains(@class,'Item')]";
    private static String formatSortLabelLocator = "//a[contains(@id,'sort-%s')]";
    private static String formatOfferedCarPriceLocator = "(//div[contains(@class,'ResultDiv')])[%s]//span[contains(@class,'Price-now')]";
    public RentalHeaderMenu rentalHeaderMenu = new RentalHeaderMenu();

    public SearchCarPage() {
        super(By.xpath(MAIN_LOCATOR),"Search Car Page");
    }

    public SearchCarPage chooseCarType(int index){
        int decrement = 1;
        lblCarsTypeBoxLabel.getChildren(By.xpath(formatCarsTypeLocator)).get(index-decrement).click();
        return this;
    }

    public void sortBy(RentalSortCriteria sortCriteria){
        new Label(By.xpath(String.format(formatSortLabelLocator,sortCriteria.getSortType()))
                , String.format("Sort Label '%s'",sortCriteria)).click();
    }

    public double getCarPrice(int carIndex){
        return Double.parseDouble(RegExpFinder.findByRegularExp(new Label(By.xpath(String.format(formatOfferedCarPriceLocator
                , carIndex)),"Car Price Locator").getText(), RegExp.RENTAL_CAR_PRICE.getRegExp()));
    }
}