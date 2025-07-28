package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightSearchPage extends BasePage {
    @FindBy(xpath = "//input[@id='search_type_option_ONEWAY']/following-sibling::label")
    private WebElement rdButtonOneWay;
    @FindBy(xpath = "//button[@data-ui-name='input_location_from_segment_0']")
    private WebElement buttonTravelFrom;
    @FindBy(xpath = "//input[@data-ui-name='input_text_autocomplete']")
    private WebElement txtBoxTravelFrom;
    @FindBy(xpath = "//ul[@id='flights-searchbox_suggestions']")
    private WebElement chkBoxSelectLocation;
    @FindBy(xpath = "//button[@data-ui-name='input_location_to_segment_0']")
    private WebElement buttonGoingTo;
    @FindBy(xpath = "//input[@data-ui-name='input_text_autocomplete']")
    private WebElement txtBoxGoingTo;
    @FindBy(xpath = "//button[@data-ui-name='button_date_segment_0']")
    private WebElement buttonTravelDate;
    @FindBy(xpath = "//button[@title='Add or remove travelers']")
    private WebElement buttonAddTravelers;
    @FindBy(xpath = "//button[@data-ui-name='button_occupancy_adults_plus']")
    private WebElement buttonAddAdults;
    @FindBy(xpath = "//button[@data-ui-name='button_search_submit']")
    private WebElement buttonSearchResults;
    @FindBy(xpath = "//div[@data-testid='search_filters_summary_results_number']")
    private WebElement txtSearchResult;



    public WebElement getDateLocator(String date) {
        String xpath = "//span[contains(@aria-label,'" + date + "')]";
        return driver.findElement(By.xpath(xpath));
    }


    public FlightSearchPage(WebDriver driver) {
        super(driver);
    }

    public void clickOneWay() {
        rdButtonOneWay.click();
    }

    public void clickTravelFrom() {
        buttonTravelFrom.click();
    }

    public void clickTravelFromTextBox() {
        txtBoxTravelFrom.click();
    }

    public void clearTravelFromTextBox() {
        txtBoxTravelFrom.sendKeys(Keys.BACK_SPACE);
    }

    public void enterTravelFrom(String travelFromLocation) {
        txtBoxTravelFrom.sendKeys(travelFromLocation);
    }

    public void selectTravelFromChkBox() {
        chkBoxSelectLocation.click();
    }

    public void clickGoingTo() {
        buttonGoingTo.click();
    }

    public void enterGoingTo(String travelToLocation) {
        txtBoxGoingTo.sendKeys(travelToLocation);
    }

    public void selectGoingToChkBox() {
        chkBoxSelectLocation.click();
    }

    public void clickTravelDate() {
        buttonTravelDate.click();
    }

    public void selectTravelDate(String date) {
        getDateLocator(date).click();
    }

    public void clickAddTravelers() {
        buttonAddTravelers.click();
    }

    public void addAdultTravelers(int count) {
        for (int i = 1; i < count; i++) {
            buttonAddAdults.click();
        }
    }

    public void clickSearchButton()
    {
        buttonSearchResults.click();
    }

    public String getSearchResultsCount()
    {
        String[] str=txtSearchResult.getText().split(" ");
        return str[1];
    }



}
