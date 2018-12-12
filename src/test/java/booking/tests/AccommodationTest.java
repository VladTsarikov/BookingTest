package booking.tests;

import booking.accommodation.enums.*;
import booking.accommodation.pages.*;
import booking.accommodation.pages.forms.*;
import booking.common.entities.Date;
import booking.common.enums.*;
import framework.utils.*;
import framework.webdriver.BaseEntity;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AccommodationTest extends BaseEntity {

    private Date checkInDate = new Date(2018, Month.DECEMBER.getIndex(),25);
    private Date checkOutDate = new Date(2018, Month.DECEMBER.getIndex(),28);

    @Parameters({"firstAdultsCount","firstChildrenCount", "firstRoomsCount", "minAllowableSearchCount"})
    @Test
    public void accommodationsCountTest(int firstAdultsCount, int firstChildrenCount
            , int firstRoomsCount, int minAllowableSearchCount){
        Logger.logStep(1,"OPENING BOOKING.COM AND CHOOSING RANDOM PROMOTION CITY...");
        AccommodationMainPage accommodationMainPage = new AccommodationMainPage();
        accommodationMainPage.choosePromotionCity(Random.getRandomNumber(1,5));

        Logger.logStep(2,"OPENING SELECTED CITY PAGE AND CHOOSING REQUIRED DATE...");
        SelectedCityPage selectedCityPage = new SelectedCityPage();
        new AccommodationCalendarForm().setCheckInDate(checkInDate);
        selectedCityPage.clickCheckOutDate();
        new AccommodationCalendarForm().setCheckOutDate(checkOutDate);

        Logger.logStep(3,"CHOOSING ADULTS, CHILDREN AND ROOMS COUNT...");
        selectedCityPage.chooseAdultsCount(firstAdultsCount);
        selectedCityPage.chooseChildrenCount(firstChildrenCount);
        selectedCityPage.chooseRoomsCount(firstRoomsCount);
        selectedCityPage.clickSearchButton();

        Logger.logStep(4,"VERIFYING THAT MORE THAN 20 OFFERS FOUND...");
        Assert.assertTrue(selectedCityPage.getSearchResultAmount() > minAllowableSearchCount
                ,"Search result amount less than necessary");
    }

    @Parameters({"secondAdultsCount", "secondChildrenCount", "secondRoomsCount", "maxAllowablePrice"})
    @Test
    public void accommodationsPriceTest(int secondAdultsCount, int secondChildrenCount
            , int secondRoomsCount, int maxAllowablePrice){
        Logger.logStep(1,"OPENING BOOKING.COM AND CHOOSING CITY...");
        AccommodationMainPage accommodationMainPage = new AccommodationMainPage();
        accommodationMainPage.setCityToFind("Warsaw");
        accommodationMainPage.clickSearchButton();

        Logger.logStep(2,"OPENING SELECTED CITY PAGE AND CHOOSING REQUIRED DATE...");
        SelectedCityPage selectedCityPage = new SelectedCityPage();
        selectedCityPage.clickCheckInDate();
        new AccommodationCalendarForm().setCheckInDate(checkInDate);
        selectedCityPage.clickCheckOutDate();
        new AccommodationCalendarForm().setCheckOutDate(checkOutDate);

        Logger.logStep(3,"CHOOSING ADULTS, CHILDREN AND ROOMS COUNT...");
        selectedCityPage.chooseAdultsCount(secondAdultsCount);
        selectedCityPage.chooseChildrenCount(secondChildrenCount);
        selectedCityPage.chooseRoomsCount(secondRoomsCount);
        selectedCityPage.clickSearchButton();

        Logger.logStep(4,"SETTING NECESSARY CURRENCY...");
        if(!selectedCityPage.userFomMenu.getCurrentCurrency().equals(Currency.BYN.toString())){
            selectedCityPage.userFomMenu.clickMenuItem(UserMenuItemName.CURRENCY);
            new AccommodationCurrencyForm().selectCurrency(Currency.BYN);
        }

        Logger.logStep(5,"FILTERING AND SORTING OFFERS...");
        selectedCityPage.selectPriceFilterCheckBox(PriceFilterIndex.FIRST_FILTER);
        selectedCityPage.sortBy(AccommodationSortType.SCORE_AND_PRICE);

        Logger.logStep(6,"VERIFYING THAT OFFER PRICE LESS THAN 500 BYN...");
        Assert.assertTrue(selectedCityPage.getOfferPrice(1) < maxAllowablePrice
                ,"Offer price is to expensive");
    }
}