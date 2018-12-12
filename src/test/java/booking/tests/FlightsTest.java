package booking.tests;

import booking.accommodation.pages.AccommodationMainPage;
import booking.common.enums.*;
import booking.flights.pages.forms.FlightsCurrencyForm;
import booking.flights.enums.*;
import booking.flights.pages.*;
import booking.flights.pages.forms.*;
import framework.utils.Logger;
import framework.webdriver.BaseEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FlightsTest extends BaseEntity {

    @Test
    public void oneWayFlightsTest(){
        Logger.logStep(1,"OPENING BOOKING.COM...");
        AccommodationMainPage accommodationMainPage = new AccommodationMainPage();

        Logger.logStep(2,"CLICKING ON FLIGHTS MENU ITEM...");
        accommodationMainPage.mainNavigateMenu.clickMenuItem(MenuItemName.FLIGHTS.getName());

        Logger.logStep(3,"OPENING FLIGHTS PAGE AND SELECTING ONE WAY FLIGHT TYPE...");
        selectLastOpenedWindow();
        MainFlightsPage mainFlightsPage = new MainFlightsPage();
        mainFlightsPage.selectFlightTypeLabel(FlightType.ONE_WAY);

        Logger.logStep(4,"SETTING FLIGHTS DATE...");
        mainFlightsPage.setDirection(Direction.ORIGIN,"Minsk (MSQ)");
        mainFlightsPage.setDirection(Direction.DESTINATION," Moscow (DME)");
        mainFlightsPage.clickDate(DateType.DEPART);
        new SingleCalendarForm().setDate(2018, Month.DECEMBER.getIndex(),25);

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

    @Test
    public void roundTripFlightsTest(){
        Logger.logStep(1,"OPENING BOOKING.COM...");
        AccommodationMainPage accommodationMainPage = new AccommodationMainPage();

        Logger.logStep(2,"CLICKING ON FLIGHTS MENU ITEM...");
        accommodationMainPage.mainNavigateMenu.clickMenuItem(MenuItemName.FLIGHTS.getName());
        selectLastOpenedWindow();

        Logger.logStep(3,"OPENING FLIGHTS PAGE AND SELECTING ROUND TRIP FLIGHT TYPE...");
        MainFlightsPage mainFlightsPage = new MainFlightsPage();
        mainFlightsPage.selectFlightTypeLabel(FlightType.ROUND_TRIP);

        Logger.logStep(4,"SETTING FLIGHTS DATA...");
        mainFlightsPage.setDirection(Direction.ORIGIN,"Minsk (MSQ)");
        mainFlightsPage.setDirection(Direction.DESTINATION," Moscow (DME)");
        mainFlightsPage.clickDate(DateType.DEPART);
        new DoubleCalendarForm().setDates(2018, Month.DECEMBER.getIndex(),25, 2018, Month.JANUARY.getIndex(),26);

        Logger.logStep(5,"CLICKING SEARCH BUTTON AND OPENING FOUND FLIGHTS PAGE...");
        mainFlightsPage.clickSearchButton();
        FoundFlightsPage foundFlightsPage = new FoundFlightsPage();

        Logger.logStep(6,"SORTING SEARCH AND VERIFYING THAT THE FIRST FLIGHT IS QUITE QUICK...");
        foundFlightsPage.sortBy(SortCriteria.QUICKEST);
        Assert.assertTrue(foundFlightsPage.getFlightsDuration(1)<3,"Flight time does not match the required");
    }

    @Test
    public void multiCityFlightsTest(){
        Logger.logStep(1,"OPENING BOOKING.COM...");
        AccommodationMainPage accommodationMainPage = new AccommodationMainPage();

        Logger.logStep(2,"CLICKING ON FLIGHTS MENU ITEM...");
        accommodationMainPage.mainNavigateMenu.clickMenuItem(MenuItemName.FLIGHTS.getName());
        selectLastOpenedWindow();

        Logger.logStep(3,"OPENING FLIGHTS PAGE AND SELECTING MULTI CITY FLIGHT TYPE...");
        MainFlightsPage mainFlightsPage = new MainFlightsPage();
        mainFlightsPage.selectFlightTypeLabel(FlightType.MULTI_CITY);

        Logger.logStep(4,"SETTING FLIGHTS DATA...");
        mainFlightsPage.setDirection(Direction.FIRST_ORIGIN,"Minsk (MSQ)");
        mainFlightsPage.setDirection(Direction.FIRST_DESTINATION," Moscow (DME)");
        mainFlightsPage.setDirection(Direction.NEXT_OIGIN," Moscow (DME)");
        mainFlightsPage.setDirection(Direction.NEXT_DESTINATION," Kiev (IEV)");
        mainFlightsPage.setDirection(Direction.LAST_OIGIN," Kiev (IEV)");
        mainFlightsPage.setDirection(Direction.LAST_DESTINATION," Minsk (MSQ)");
        mainFlightsPage.clickDate(DateType.FIRST_DEPART);
        new SingleCalendarForm().setDate(2018, Month.DECEMBER.getIndex(),25);
        mainFlightsPage.clickDate(DateType.NEXT_DEPART);
        new SingleCalendarForm().setDate(2018, Month.DECEMBER.getIndex(),26);
        mainFlightsPage.clickDate(DateType.LAST_DEPART);
        new SingleCalendarForm().setDate(2018, Month.DECEMBER.getIndex(),27);
        mainFlightsPage.selectTime(TimeNumber.FIRST_TIME,"11:00");
        mainFlightsPage.selectTime(TimeNumber.NEXT_TIME,"11:00");
        mainFlightsPage.selectTime(TimeNumber.LAST_TIME,"11:00");

        Logger.logStep(5,"CLICKING SEARCH BUTTON AND OPENING FOUND FLIGHTS PAGE...");
        mainFlightsPage.clickSearchButton();
        FoundFlightsPage foundFlightsPage = new FoundFlightsPage();

        Logger.logStep(7,"VERIFYING THAT AT LEAST ONE FLIGHT FOUND...");
        Assert.assertTrue(foundFlightsPage.getFoundResultCount()>0,"No matching flights found");
    }
}