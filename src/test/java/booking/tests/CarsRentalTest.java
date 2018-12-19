package booking.tests;

import booking.accommodation.pages.AccommodationMainPage;
import booking.carsRental.enums.*;
import booking.carsRental.pages.*;
import booking.carsRental.pages.forms.*;
import booking.common.entities.Date;
import booking.common.enums.*;
import framework.utils.*;
import framework.webdriver.BaseEntity;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CarsRentalTest extends BaseEntity {

    private Date pickUpDate = new Date(2018, Month.DECEMBER.getIndex(),25,"11:30");
    private Date dropOffDate = new Date(2018, Month.DECEMBER.getIndex(),26,"11:30");

    @Parameters({"rentalLocation","maxAllowablePrice"})
    @Test
    public void rentalCarPriceTest(String rentalLocation, int maxAllowablePrice){
        Logger.logStep(1,"OPENING BOOKING.COM AND CLICKING ON CARS RENTAL MENU ITEM...");
        new AccommodationMainPage().mainNavigateMenu.clickMenuItem(MenuItemName.CAR_RENTALS.getName());
        selectLastOpenedWindow();

        Logger.logStep(2,"OPENING RENTAL CARS PAGE AND FINDING LOCATION...");
        new CarsRentalMainPage()
                .setLocation(rentalLocation)
                .clickSearchButton();

        Logger.logStep(3,"OPENING SEARCH CAR PAGE AND SETTING RENTAL TIME...");
        SearchCarPage searchCarPage = new SearchCarPage();
        new SearchAndFilterForm()
                .setRentalTime(RentalDateType.PICK_UP, pickUpDate)
                .setRentalTime(RentalDateType.DROP_OFF, dropOffDate)
                .clickSearchButton();

        Logger.logStep(4,"SETTING CURRENCY 'USD'...");
        searchCarPage.rentalHeaderMenu.clickMenuItem(RentalMenuItemName.CURRENCY);
        new RentalCurrencyForm().selectCurrency(Currency.USD);

        Logger.logStep(5,"CHOOSING RANDOM CAR TYPE AND SORTING RESULT BY PRICE...");
        searchCarPage
                .chooseCarType(Random.getRandomNumber(1,7))
                .sortBy(RentalSortCriteria.PRICE);

        Logger.logStep(6,"VERIFYING THAT THE FIRST OFFERED CAR PRICE LESS THAN 130$...");
        Assert.assertTrue(searchCarPage.getCarPrice(1)<maxAllowablePrice
                ,"Flight time does not match the required");
    }
}