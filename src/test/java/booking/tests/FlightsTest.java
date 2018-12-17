package booking.tests;

import booking.accommodation.pages.AccommodationMainPage;
import booking.common.entities.Date;
import booking.common.enums.*;
import booking.flights.pages.forms.FlightsCurrencyForm;
import booking.flights.enums.*;
import booking.flights.pages.*;
import booking.flights.pages.forms.*;
import framework.utils.Logger;
import framework.webdriver.BaseEntity;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightsTest extends BaseEntity {

    private Date firstDate = new Date(2018, Month.DECEMBER.getIndex(),25,"11:00");
    private Date secondDate = new Date(2018, Month.DECEMBER.getIndex(),26, "11:00");
    private Date thirdDate = new Date(2018, Month.DECEMBER.getIndex(),27, "11:00");

    @Parameters({"firstOriginDirection", "firstDestinationDirection"})
    @Test
    public void oneWayFlightsTest(String firstOriginDirection, String firstDestinationDirection){
        Logger.logStep(1,"OPENING BOOKING.COM...");
        AccommodationMainPage accommodationMainPage = new AccommodationMainPage();

        Logger.logStep(2,"CLICKING ON FLIGHTS MENU ITEM...");
        accommodationMainPage.mainNavigateMenu.clickMenuItem(MenuItemName.FLIGHTS.getName());

        Logger.logStep(3,"OPENING FLIGHTS PAGE AND SELECTING ONE WAY FLIGHT TYPE...");
        selectLastOpenedWindow();
        MainFlightsPage mainFlightsPage = new MainFlightsPage();
        mainFlightsPage.selectFlightTypeLabel(FlightType.ONE_WAY);

        Logger.logStep(4,"SETTING FLIGHTS DATE...");
        mainFlightsPage.setDirection(Direction.ORIGIN,firstOriginDirection);
        mainFlightsPage.setDirection(Direction.DESTINATION,firstDestinationDirection);
        mainFlightsPage.clickDate(DateType.DEPART);
        new SingleCalendarForm().setDate(firstDate);

        Logger.logStep(5,"CLICKING SEARCH BUTTON AND OPENING FOUND FLIGHTS PAGE...");
        mainFlightsPage.clickSearchButton();
        FoundFlightsPage foundFlightsPage = new FoundFlightsPage();

        Logger.logStep(6,"SORTING SEARCH AND CHOOSING NECESSARY CURRENCY...");
        foundFlightsPage.sortBy(SortCriteria.CHEAPEST);
        foundFlightsPage.mainHeaderMenu.clickMenuItem(HeaderMenuItem.CURRENCY);
        FlightsCurrencyForm flightsCurrencyForm = new FlightsCurrencyForm();
        flightsCurrencyForm.selectCurrency(Currency.BYN);

        Logger.logStep(7,"VERIFYING THAT THE FIRST FLIGHT IS NOT EXPENSIVE...");
        Assert.assertTrue(foundFlightsPage.getFlightsPrice(1)<360,"Flight price does not match the required");
    }

    @Parameters({"firstOriginDirection","firstDestinationDirection"})
    @Test
    public void roundTripFlightsTest(String firstOriginDirection, String firstDestinationDirection){
        Logger.logStep(1,"OPENING BOOKING.COM...");
        AccommodationMainPage accommodationMainPage = new AccommodationMainPage();

        Logger.logStep(2,"CLICKING ON FLIGHTS MENU ITEM...");
        accommodationMainPage.mainNavigateMenu.clickMenuItem(MenuItemName.FLIGHTS.getName());
        selectLastOpenedWindow();

        Logger.logStep(3,"OPENING FLIGHTS PAGE AND SELECTING ROUND TRIP FLIGHT TYPE...");
        MainFlightsPage mainFlightsPage = new MainFlightsPage();
        mainFlightsPage.selectFlightTypeLabel(FlightType.ROUND_TRIP);

        Logger.logStep(4,"SETTING FLIGHTS DATA...");
        mainFlightsPage.setDirection(Direction.ORIGIN,firstOriginDirection);
        mainFlightsPage.setDirection(Direction.DESTINATION,firstDestinationDirection);
        mainFlightsPage.clickDate(DateType.DEPART);
        new DoubleCalendarForm().setDates(firstDate, secondDate);

        Logger.logStep(5,"CLICKING SEARCH BUTTON AND OPENING FOUND FLIGHTS PAGE...");
        mainFlightsPage.clickSearchButton();
        FoundFlightsPage foundFlightsPage = new FoundFlightsPage();

        Logger.logStep(6,"SORTING SEARCH AND VERIFYING THAT THE FIRST FLIGHT IS QUITE QUICK...");
        foundFlightsPage.sortBy(SortCriteria.QUICKEST);
        Assert.assertTrue(foundFlightsPage.getFlightsDuration(1)<5,"Flight time does not match the required");
    }

    @Parameters({"firstOriginDirection","firstDestinationDirection","secondOriginDirection","secondDestinationDirection"
            , "thirdOriginDirection", "thirdDestinationDirection"})
    @Test
    public void multiCityFlightsTest(String firstOriginDirection, String firstDestinationDirection, String secondOriginDirection
            , String secondDestinationDirection, String thirdOriginDirection, String thirdDestinationDirection){
        Logger.logStep(1,"OPENING BOOKING.COM...");
        AccommodationMainPage accommodationMainPage = new AccommodationMainPage();

        Logger.logStep(2,"CLICKING ON FLIGHTS MENU ITEM...");
        accommodationMainPage.mainNavigateMenu.clickMenuItem(MenuItemName.FLIGHTS.getName());
        selectLastOpenedWindow();

        Logger.logStep(3,"OPENING FLIGHTS PAGE AND SELECTING MULTI CITY FLIGHT TYPE...");
        MainFlightsPage mainFlightsPage = new MainFlightsPage();
        mainFlightsPage.selectFlightTypeLabel(FlightType.MULTI_CITY);

        Logger.logStep(4,"SETTING FLIGHTS DATA...");
        mainFlightsPage.setDirection(Direction.FIRST_ORIGIN,firstOriginDirection);
        mainFlightsPage.setDirection(Direction.FIRST_DESTINATION,firstDestinationDirection);
        mainFlightsPage.setDirection(Direction.NEXT_OIGIN,secondOriginDirection);
        mainFlightsPage.setDirection(Direction.NEXT_DESTINATION,secondDestinationDirection);
        mainFlightsPage.setDirection(Direction.LAST_OIGIN,thirdOriginDirection);
        mainFlightsPage.setDirection(Direction.LAST_DESTINATION,thirdDestinationDirection);
        mainFlightsPage.clickDate(DateType.FIRST_DEPART);
        new SingleCalendarForm().setDate(firstDate);
        mainFlightsPage.clickDate(DateType.NEXT_DEPART);
        new SingleCalendarForm().setDate(secondDate);
        mainFlightsPage.clickDate(DateType.LAST_DEPART);
        new SingleCalendarForm().setDate(thirdDate);
        mainFlightsPage.selectTime(TimeNumber.FIRST_TIME,firstDate.getTime());
        mainFlightsPage.selectTime(TimeNumber.NEXT_TIME,secondDate.getTime());
        mainFlightsPage.selectTime(TimeNumber.LAST_TIME,thirdDate.getTime());

        Logger.logStep(5,"CLICKING SEARCH BUTTON AND OPENING FOUND FLIGHTS PAGE...");
        mainFlightsPage.clickSearchButton();
        FoundFlightsPage foundFlightsPage = new FoundFlightsPage();

        Logger.logStep(7,"VERIFYING THAT AT LEAST ONE FLIGHT FOUND...");
        Assert.assertTrue(foundFlightsPage.getFoundResultCount()>0,"No matching flights found");
    }
}