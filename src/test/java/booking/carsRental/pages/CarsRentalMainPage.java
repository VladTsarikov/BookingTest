package booking.carsRental.pages;

import framework.webdriver.BaseForm;
import framework.webdriver.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CarsRentalMainPage extends BaseForm {

    private final static String MAIN_LOCATOR = "SearchResultsForm";
    private static  @FindBy(how = How.ID, using = "ftsAutocomplete") TextBox txbSearch;
    private static  @FindBy(how = How.ID, using = "formsubmit") Button btnSearch;

    public CarsRentalMainPage() {
        super(By.id(MAIN_LOCATOR),"Cars Rental Main Page");
    }

    public CarsRentalMainPage setLocation(String location){
        txbSearch.setText(location);
        txbSearch.enter();
        return this;
    }

    public void clickSearchButton(){
        btnSearch.clickViaJS();
    }
}