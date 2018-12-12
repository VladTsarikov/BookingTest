package booking.tests;

import booking.accommodation.enums.*;
import booking.accommodation.pages.*;
import booking.accommodation.pages.forms.*;
import booking.common.enums.*;
import framework.utils.*;
import framework.webdriver.BaseEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccommodationTest extends BaseEntity {

    @Test
    public void accommodationsCountTest(){
        Logger.logStep(1,"OPENING BOOKING.COM AND CHOOSING RANDOM PROMOTION CITY...");
        AccommodationMainPage accommodationMainPage = new AccommodationMainPage();
        accommodationMainPage.choosePromotionCity(Random.getRandomNumber(1,5));

        Logger.logStep(2,"OPENING SELECTED CITY PAGE AND CHOOSING REQUIRED DATE...");
        SelectedCityPage selectedCityPage = new SelectedCityPage();
        new AccommodationCalendarForm().setCheckInDate(2018, Month.DECEMBER.getIndex(),25);
        selectedCityPage.clickCheckOutDate();
        new AccommodationCalendarForm().setCheckOutDate(2018, Month.DECEMBER.getIndex(),28);

        Logger.logStep(3,"CHOOSING ADULTS, CHILDREN AND ROOMS COUNT...");
        selectedCityPage.chooseAdultsCount(2);
        selectedCityPage.chooseChildrenCount(1);
        selectedCityPage.chooseRoomsCount(1);
        selectedCityPage.clickSearchButton();

        Logger.logStep(4,"VERIFYING THAT MORE THAN 20 OFFERS FOUND...");
        Assert.assertTrue(selectedCityPage.getSearchResultAmount()>20,"Search result amount less than necessary");
    }

    @Test
    public void accommodationsPriceTest(){
        Logger.logStep(1,"OPENING BOOKING.COM AND CHOOSING CITY...");
        AccommodationMainPage accommodationMainPage = new AccommodationMainPage();
        accommodationMainPage.setCityToFind("Warsaw");
        accommodationMainPage.clickSearchButton();

        Logger.logStep(2,"OPENING SELECTED CITY PAGE AND CHOOSING REQUIRED DATE...");
        SelectedCityPage selectedCityPage = new SelectedCityPage();
        selectedCityPage.clickCheckInDate();
        new AccommodationCalendarForm().setCheckInDate(2018, Month.DECEMBER.getIndex(),25);
        selectedCityPage.clickCheckOutDate();
        new AccommodationCalendarForm().setCheckOutDate(2018, Month.DECEMBER.getIndex(),28);

        Logger.logStep(3,"CHOOSING ADULTS, CHILDREN AND ROOMS COUNT...");
        selectedCityPage.chooseAdultsCount(2);
        selectedCityPage.chooseChildrenCount(3);
        selectedCityPage.chooseRoomsCount(2);
        selectedCityPage.clickSearchButton();

        Logger.logStep(4,"SETTING NECESSARY CURRENCY...");
        if(!selectedCityPage.userFomMenu.getCurrentCurrency().equals(Currency.BYN.toString())){
            selectedCityPage.userFomMenu.clickMenuItem(UserMenuItemName.CURRENCY);
            new AccommodationCurrencyForm().selectCurrency(Currency.BYN);
        }

        Logger.logStep(4,"FILTERING AND SORTING OFFERS...");
        selectedCityPage.selectPriceFilterCheckBox(PriceFilterIndex.FIRST_FILTER);
        selectedCityPage.sortBy(AccommodationSortType.SCORE_AND_PRICE);

        Logger.logStep(4,"VERIFYING THAT OFFER PRICE LESS THAN 500 BYN...");
        Assert.assertTrue(selectedCityPage.getOfferPrice(1)<500,"Offer price is to expensive");
    }
}