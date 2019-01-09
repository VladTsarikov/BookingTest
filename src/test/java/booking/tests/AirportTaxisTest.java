package booking.tests;

import booking.accommodation.pages.AccommodationMainPage;
import booking.airportTaxis.enums.TaxisLocationType;
import booking.airportTaxis.pages.*;
import booking.airportTaxis.pages.forms.*;
import booking.common.entities.Date;
import booking.common.enums.*;
import framework.utils.Logger;
import framework.webdriver.BaseEntity;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AirportTaxisTest extends BaseEntity {

    private Date date = new Date(2019, Month.JANUARY.getIndex(),25, "04:00");

    @Parameters({"pickUpTaxisLocation","dropOffTaxisLocation", "taxisPassengersCount"})
    @Test
    public void taxisSearchTest(String pickUpTaxisLocation, String dropOffTaxisLocation, int taxisPassengersCount){
        Logger.logStep(1,"OPENING BOOKING.COM AND CLICKING ON AIRPORT TAXIS MENU ITEM...");
        new AccommodationMainPage().mainNavigateMenu.clickMenuItem(MenuItemName.AIRPORT_TAXIS.getName());
        selectLastOpenedWindow();

        Logger.logStep(2,"OPENING AIRPORT TAXIS PAGE AND SETTING SEARCHING INFORMATION...");
        MainTaxisPage mainTaxisPage = new MainTaxisPage();
        mainTaxisPage
                .setLocation(TaxisLocationType.PICK_UP, pickUpTaxisLocation)
                .setLocation(TaxisLocationType.DROP_OFF, dropOffTaxisLocation)
                .clickDateLabel();
        new TaxisCalendarForm().setDate(date);
        mainTaxisPage.clickTimeLabel();
        new TaxisTimeForm().setTime(date.getTime()).clickConfirmButton();
        mainTaxisPage.setPassengersCount(taxisPassengersCount);

        Logger.logStep(3,"SEARCHING TAXIS AND VERIFYING THAT AT LEAST ONE CAR FOUND...");
        mainTaxisPage.clickSearchButton();
        Assert.assertTrue(new FoundTaxisPage().getFoundTaxisCount()>0,"No taxis has not found");
    }
}