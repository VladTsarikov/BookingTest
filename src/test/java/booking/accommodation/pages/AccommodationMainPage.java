package booking.accommodation.pages;

import booking.common.menu.MainNavigateMenu;
import framework.webdriver.BaseForm;
import framework.webdriver.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccommodationMainPage extends BaseForm {

    private final static String MAIN_LOCATOR = "//div[contains(@class,'postcards-list')]";
    private static String formatPromotionCityLocator = "(//div[contains(@class,'postcard') and contains(@class,'idr')])[%s]";
    private static  @FindBy(how = How.XPATH, using = "//form[@id='frm']//input[@type='search']") TextBox txbSearch;
    private static  @FindBy(how = How.XPATH, using = "//div[contains(@class,'searchbox-submit')]//button[@type='submit']") Button btnSearch;
    public MainNavigateMenu mainNavigateMenu = new MainNavigateMenu();

    public AccommodationMainPage() {
        super(By.xpath(MAIN_LOCATOR),"Accommodation Main Page");
    }

    public void choosePromotionCity(int countryNumber){
        new Label(By.xpath(String.format(formatPromotionCityLocator,countryNumber)),"Promotion City Label").click();
    }

    public void setCityToFind(String city){
        txbSearch.setText(city);
    }

    public void clickSearchButton(){
        btnSearch.click();
    }
}