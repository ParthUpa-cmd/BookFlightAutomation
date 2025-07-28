package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.FlightSearchPage;
import utilities.ConfigReader;
import utilities.DriverManager;

public class FlightSearchSteps {

    private final WebDriver driver;
    private final FlightSearchPage flightSearchPage;


    public FlightSearchSteps() {
        this.driver = DriverManager.getDriver();
        this.flightSearchPage = new FlightSearchPage(driver);
    }


    @Given("User is on the flight booking page")
    public void user_is_on_the_flight_booking_page() {
        driver.get(ConfigReader.getProperty("url"));
    }

    @When("User enters leaving from location")
    public void userEntersLeavingFromLocation() {
        flightSearchPage.clickTravelFrom();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        flightSearchPage.clickTravelFromTextBox();
        flightSearchPage.clearTravelFromTextBox();
        flightSearchPage.enterTravelFrom(ConfigReader.getProperty("leavingFromLocation"));
        flightSearchPage.selectTravelFromChkBox();
    }

    @And("User enters going to location")
    public void userEntersGoingToLocation() {
        flightSearchPage.clickGoingTo();
        flightSearchPage.enterGoingTo(ConfigReader.getProperty("goingToLocation"));
        flightSearchPage.selectGoingToChkBox();
    }

    @And("User Enters travel date")
    public void userEntersTravelDate() {
        flightSearchPage.clickTravelDate();
        flightSearchPage.selectTravelDate(ConfigReader.getProperty("travelDate"));
    }

    @When("User clicks one-way button")
    public void userClicksOneWayButton() {
        flightSearchPage.clickOneWay();
    }

    @And("User adds travelers")
    public void userAddsTravelers() {
        flightSearchPage.clickAddTravelers();
        flightSearchPage.addAdultTravelers(3);
    }

    @Then("User gets total flights")
    public void userGetsTotalFlights() {
        int totalFlights = Integer.parseInt(flightSearchPage.getSearchResultsCount());
        System.out.println("Total Flights are: " + totalFlights);

    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        flightSearchPage.clickSearchButton();
    }
}