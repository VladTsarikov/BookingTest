package booking.tests;

import booking.accommodation.pages.AccommodationMainPage;
import booking.airportTaxis.enums.TaxisLocationType;
import booking.airportTaxis.pages.*;
import booking.airportTaxis.pages.forms.*;
import booking.common.enums.*;
import framework.utils.Logger;
import framework.webdriver.BaseEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AirportTaxisTest extends BaseEntity {

    @Test
    public void taxisSearchTest(){
        Logger.logStep(1,"OPENING BOOKING.COM...");
        AccommodationMainPage accommodationMainPage = new AccommodationMainPage();

        Logger.logStep(2,"CLICKING ON AIRPORT TAXIS MENU ITEM...");
        accommodationMainPage.mainNavigateMenu.clickMenuItem(MenuItemName.AIRPORT_TAXIS.getName());
        selectLastOpenedWindow();

        Logger.logStep(3,"OPENING AIRPORT TAXIS PAGE AND SETTING SEARCHING INFORMATION...");
        MainTaxisPage mainTaxisPage = new MainTaxisPage();
        mainTaxisPage.setLocation(TaxisLocationType.PICK_UP,"Sheremetyevo International Airport (SVO)");
        mainTaxisPage.setLocation(TaxisLocationType.DROP_OFF,"Moscow Manege, Manege Square, Moscow, Russian Federation");
        mainTaxisPage.clickDateLabel();
        new TaxisCalendarForm().setDate(2018, Month.DECEMBER.getIndex(), 25);
        mainTaxisPage.clickTimeLabel();
        new TaxisTimeForm().setTime("04:00").clickConfirmButton();
        mainTaxisPage.setPassengersCount(5);

        Logger.logStep(4,"SEARCHING TAXIS AND VERIFYING THAT AT LEAST ONE CAR FOUND...");
        mainTaxisPage.clickSearchButton();
        FoundTaxisPage foundTaxisPage = new FoundTaxisPage();
        Assert.assertTrue(foundTaxisPage.getFoundTaxisCount()>0,"No taxis has not found");
    }
}