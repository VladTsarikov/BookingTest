package booking.accommodation.pages;

import booking.accommodation.enums.*;
import booking.accommodation.enums.PriceFilterIndex;
import booking.accommodation.pages.menu.UserFomMenu;
import booking.common.enums.RegExp;
import framework.utils.RegExpFinder;
import framework.webdriver.BaseForm;
import framework.webdriver.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SelectedCityPage extends BaseForm {

    private final static String MAIN_LOCATOR = "//div[contains(@id,'hotellist_inner')]";
    private final static String formatPriceFilterLocator = "//div[@id='filter_price']//a[@data-id='%s']";
    private final static String formatSortTypeLocator = "//div[@id='sort_by']//li[contains(@class,'%s')]";
    private final static String formatPriceInfoLocator = "(//div[contains(@class,'item_content')])[%s]//div[contains(@class,'totalPrice')]";
    private static  @FindBy(how = How.XPATH, using = "//div[contains(@class,'checkin-field')]/div[contains(@class,'date')]") ComboBox cmbCheckInDate;
    private static  @FindBy(how = How.XPATH, using = "//div[contains(@class,'checkout-field')]/div[contains(@class,'date')]") ComboBox cmbCheckOutDate;
    private static  @FindBy(how = How.ID, using = "group_adults") Select selectAdultsCount;
    private static  @FindBy(how = How.ID, using = "group_children") Select selectChildrenCount;
    private static  @FindBy(how = How.ID, using = "no_rooms") Select selectRoomCount;
    private static  @FindBy(how = How.XPATH, using = "//button[contains(@class,'search')]") Button btnSearch;
    private static  @FindBy(how = How.XPATH, using = "//div[@id='right']//div[@role='heading']") Label lblSearchHeading;
    public UserFomMenu userFomMenu = new UserFomMenu();

    public SelectedCityPage() {
        super(By.xpath(MAIN_LOCATOR),"Selected City Page");
    }

    public void clickCheckInDate(){
        cmbCheckInDate.click();
    }

    public void clickCheckOutDate(){
         cmbCheckOutDate.click();
    }

    public void chooseAdultsCount(int count){
        selectAdultsCount.selectByIndex(count-1);
    }

    public void chooseChildrenCount(int count){
        selectChildrenCount.selectByIndex(count);
    }

    public void chooseRoomsCount(int count){
        selectRoomCount.selectByIndex(count-1);
    }

    public void clickSearchButton(){
        btnSearch.click();
    }

    public void selectPriceFilterCheckBox(PriceFilterIndex filterIndex){
        new CheckBox(By.xpath(String.format(formatPriceFilterLocator,filterIndex.getIndex())),"Filter CheckBox").click();
    }

    public int getSearchResultAmount(){
        return Integer.parseInt(RegExpFinder.findByRegularExp(lblSearchHeading.getText()
                , RegExp.ACCOMMODATION_COUNT.getRegExp()).replace(",",""));
    }

    public void sortBy(AccommodationSortType sortType){
        new Label(By.xpath(String.format(formatSortTypeLocator,sortType.getType())),"Sort Label").click();
    }


    public int getOfferPrice(int offerIndex){
        System.out.println(new Label(By.xpath(String.format(formatPriceInfoLocator,offerIndex)),"Price Info Label")
                .getText());
        return Integer.parseInt(RegExpFinder.findByRegularExp(new Label(By.xpath(String.format(formatPriceInfoLocator
                , offerIndex)),"Price Info Label").getText(),RegExp.ACCOMMODATION_PRICE.getRegExp()));
    }
}