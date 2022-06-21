package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UnitedHomePage;

public class TestCases extends Base{

    /*
    Test Case 1: Validate "Main menu" navigation items
Given user is on "https://www.united.com/en/us"
Then user should see “Main menu” navigation items
|BOOK                	          	  |
|MY TRIPS            	          	  |
|TRAVEL INFO         	  |
|MILEAGEPLUS® PROGRAM|
|DEALS               	          	  |
|HELP                	          	  |

     */

    @Test(priority = 1, description = "Test Case 1: Validate \"Main menu\" navigation items\n")
    public void testNavigationMenuItems(){

        driver.get("https://www.united.com/en/us");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.united.com/en/us");

        String[] navigationMenuItems = {"BOOK", "MY TRIPS",
                "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};

        for (int i = 0; i < navigationMenuItems.length; i++) {
            Assert.assertEquals(navigationMenuItems[i], unitedHomePage.nagivationMenuItems.get(i).getText());
        }
    }

    /*
    Test Case 2: Validate "Book travel menu" navigation items
Given user is on "https://www.united.com/en/us"
Then user should see "Book travel menu" navigation items
|Book             |
|Flight Status|
|Check-in       |
|My trips        |

     */

    @Test(priority = 2, description = " Test Case 2: Validate \"Book travel menu\" navigation items\n")
    public void testBookTravelMenu(){

        driver.get("https://www.united.com/en/us");

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.united.com/en/us");

        String[] bookTravelMenuItems = {"Book", "Flight status",
                "Check-in", "My trips"};

        for (int i = 0; i < bookTravelMenuItems.length; i++) {

            Assert.assertEquals(bookTravelMenuItems[i], unitedHomePage.bookTravelMenuItems.get(i).getText());

        }
    }

    /*
    Test Case 3: Validate "Round-trip" and "One-way" radio buttons
Given user is on "https://www.united.com/en/us"
Then validate "Roundtrip" radio button is displayed, is enabled and is selected

And validate "One-way" radio button is displayed, is enabled but is not selected
When user clicks on "One-way" radio button
Then validate "One-way" radio button is selected while "Roundtrip" radio button is deselected

     */

    @Test(priority = 3, description = "Test Case 3: Validate \"Round-trip\" and \"One-way\" radio buttons\n")
    public void testRadioButtons(){

        driver.get("https://www.united.com/en/us");

        Assert.assertTrue(unitedHomePage.roundTripText.isDisplayed() &&
                unitedHomePage.roundTripText.getText().equals("Roundtrip") &&
                unitedHomePage.roundTripButton.isEnabled() &&
                unitedHomePage.roundTripButton.isSelected());

        Assert.assertTrue(unitedHomePage.oneWayText.isDisplayed() &&
                unitedHomePage.oneWayText.getText().equals("One-way") &&
                unitedHomePage.oneWayButton.isEnabled() &&
                !unitedHomePage.oneWayButton.isSelected());

        unitedHomePage.oneWayButton.click();

        Assert.assertTrue(unitedHomePage.oneWayButton.isSelected() &&
                !unitedHomePage.roundTripButton.isSelected());

    }


    /*
    Test Case 4: Validate "Book with miles" and "Flexible dates" checkboxes
Given user is on "https://www.united.com/en/us"
Then validate "Book with miles" checkbox is displayed, is enabled but is not selected
And validate "Flexible dates" checkbox is displayed, is enabled but is not selected
When user clicks both checkboxes

Then validate both checkboxes are selected

When user clicks on both selected checkboxes again
Then validate both checkboxes are deselected
     */

    @Test(priority = 4, description = "Test Case 3: Validate \"Round-trip\" and \"One-way\" radio buttons\n")
    public void testCheckboxes(){

        driver.get("https://www.united.com/en/us");

        Assert.assertTrue(unitedHomePage.bookMilesText.isDisplayed() &&
                unitedHomePage.bookMilesText.getText().equals("Book with miles") &&
                unitedHomePage.bookMilesButton.isEnabled() &&
                !unitedHomePage.bookMilesButton.isSelected());

        Assert.assertTrue(unitedHomePage.flexibleText.isDisplayed() &&
                unitedHomePage.flexibleText.getText().equals("Flexible dates") &&
                unitedHomePage.flexibleButton.isEnabled() &&
                !unitedHomePage.flexibleButton.isSelected());

        unitedHomePage.bookMilesText.click();
        unitedHomePage.flexibleText.click();

        Assert.assertTrue(unitedHomePage.bookMilesButton.isSelected() &&
                unitedHomePage.flexibleButton.isSelected());

        unitedHomePage.bookMilesText.click();
        unitedHomePage.flexibleText.click();

        Assert.assertTrue(!unitedHomePage.bookMilesButton.isSelected() &&
                !unitedHomePage.flexibleButton.isSelected());

    }

    /*
    Test Case 5: Validate One-way ticket search results "from Chicago, IL, US (ORD) to Miami, FL, US (MIA)”
Given user is on "https://www.united.com/en/us"
When user selects "One-way" ticket radio button


And user enters "Chicago, IL, US (ORD)" to from input box
And user enters "Miami, FL, US (MIA)" to to input box
And user selects "Jan 30" to the dates input box


And user selects "2 Adults" from travelers selector

And user selects "Business or First" from cabin dropdown
And user clicks on "Find Flights" button
Then validate departure equals to "Depart: Chicago, IL, US to Miami, FL, US

     */

    @Test(priority = 5, description = "Test Case 5: Validate One-way ticket search results \"from Chicago, IL, US (ORD) to Miami, FL, US (MIA)”\n")
    public void testOneWaySearchResults(){

        driver.get("https://www.united.com/en/us");

        unitedHomePage.oneWayButton.click();

        unitedHomePage.fromInputBox.clear();

        unitedHomePage.fromInputBox.sendKeys("Chicago, IL, US (ORD)");
        unitedHomePage.toInputBox.sendKeys("Miami, FL, US (MIA)");
        unitedHomePage.dateInputBox.click();

        for(int i = 0; i < 4; i++){
            unitedHomePage.rightArrow.click();
        }

        unitedHomePage.jan30Day.click();

        unitedHomePage.travelerButton.click();

        unitedHomePage.plusButton.click();

        unitedHomePage.typeDropDown.click();

        unitedHomePage.businessOrFirst.click();

        unitedHomePage.findFlightsButton.click();

        Assert.assertEquals(unitedHomePage.departHeading.getText(), "Depart: Chicago, IL, US to Miami, FL, US");







    }



}
