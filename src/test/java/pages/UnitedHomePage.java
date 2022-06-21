package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UnitedHomePage {

    public UnitedHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@role='tablist']/a")
    public List<WebElement> nagivationMenuItems;

    @FindBy(xpath = "//li[@id='travelTab']/../li")
    public List<WebElement> bookTravelMenuItems;

    @FindBy(xpath = "//input[@id='roundtrip']")
    public WebElement roundTripButton;

    @FindBy(xpath = "//input[@id='roundtrip']/..")
    public WebElement roundTripText;

    @FindBy(xpath = "//input[@id='oneway']")
    public WebElement oneWayButton;

    @FindBy(xpath = "//input[@id='oneway']/..")
    public WebElement oneWayText;

    @FindBy(xpath = "//input[@id='award']")
    public WebElement bookMilesButton;

    @FindBy(xpath = "//label[@for='award']")
    public WebElement bookMilesText;

    @FindBy(xpath = "//input[@id='flexibleDates']")
    public WebElement flexibleButton;

    @FindBy(xpath = "//label[@for='flexibleDates']")
    public WebElement flexibleText;

    /*
    And user enters "Chicago, IL, US (ORD)" to from input box
And user enters "Miami, FL, US (MIA)" to to input box
And user selects "Jan 30" to the dates input box
And user selects "2 Adults" from travelers selector
And user selects "Business or First" from cabin dropdown
And user clicks on "Find Flights" button
Then validate departure equals to "Depart: Chicago, IL, US to Miami, FL, US
     */

    @FindBy(xpath = "//input[@id='bookFlightOriginInput']")
    public WebElement fromInputBox;

    @FindBy(xpath = "//input[@id='bookFlightDestinationInput']")
    public WebElement toInputBox;

    @FindBy(xpath = "//input[@id='DepartDate']")
    public WebElement dateInputBox;

    @FindBy(className = "app-containers-BookCalendar-bookCalendar__nextIconContainer--308a5")
    public WebElement rightArrow;

    @FindBy(xpath = "//td[@aria-label='Monday, January 30, 2023']")
    public WebElement jan30Day;

    @FindBy(xpath = "//div[@id='passengerSelector']/button")
    public WebElement travelerButton;

    @FindBy(xpath = "(//button[text()='+'])[1]")
    public WebElement plusButton;

    @FindBy(id = "cabinType")
    public WebElement typeDropDown;

    @FindBy(id = "cabinType_item-2")
    public WebElement businessOrFirst;

    @FindBy(xpath = "//button[@aria-label='Find flights']")
    public WebElement findFlightsButton;

    @FindBy(xpath = "//h2")
    public WebElement departHeading;



}
