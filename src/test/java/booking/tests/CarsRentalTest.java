package booking.tests;

import booking.accommodation.pages.AccommodationMainPage;
import booking.carsRental.enums.*;
import booking.carsRental.pages.*;
import booking.carsRental.pages.forms.*;
import booking.common.enums.*;
import framework.utils.*;
import framework.webdriver.BaseEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CarsRentalTest extends BaseEntity {

    @Test
    public void rentalCarPriceTest(){
        Logger.logStep(1,"OPENING BOOKING.COM...");
        AccommodationMainPage accommodationMainPage = new AccommodationMainPage();

        Logger.logStep(2,"CLICKING ON CARS RENTAL MENU ITEM...");
        accommodationMainPage.mainNavigateMenu.clickMenuItem(MenuItemName.CAR_RENTALS.getName());
        selectLastOpenedWindow();

        Logger.logStep(3,"OPENING RENTAL CARS PAGE AND FINDING LOCATION...");
        CarsRentalMainPage carsRentalMainPage = new CarsRentalMainPage();
        carsRentalMainPage.setLocation("Sheremetyevo Airport (SVO)");
        carsRentalMainPage.clickSearchButton();

        Logger.logStep(4,"OPENING SEARCH CAR PAGE AND SETTING RENTAL TIME...");
        SearchCarPage searchCarPage = new SearchCarPage();
        SearchAndFilterForm searchAndFilterForm = new SearchAndFilterForm();
        searchAndFilterForm.setRentalTime(RentalDateType.PICK_UP,"25", Month.DECEMBER,"2018","11:30");
        searchAndFilterForm.setRentalTime(RentalDateType.DROP_OFF,"26", Month.DECEMBER,"2018","11:30");
        searchAndFilterForm.clickSearchButton();

        Logger.logStep(5,"SETTING CURRENCY 'USD'...");
        searchCarPage.rentalHeaderMenu.clickMenuItem(RentalMenuItemName.CURRENCY);
        RentalCurrencyForm rentalCurrencyForm = new RentalCurrencyForm();
        rentalCurrencyForm.selectCurrency(Currency.USD);

        Logger.logStep(5,"CHOOSING RANDOM CAR TYPE AND SORTING RESULT BY PRICE...");
        searchCarPage.chooseCarType(Random.getRandomNumber(1,7));
        searchCarPage.sortBy(RentalSortCriteria.PRICE);

        Logger.logStep(6,"VERIFYING THAT THE FIRST OFFERED CAR PRICE LESS THAN 130$...");
        Assert.assertTrue(searchCarPage.getCarPrice(1)<130,"Flight time does not match the required");
    }
}