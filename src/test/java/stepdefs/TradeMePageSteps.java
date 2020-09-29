package stepdefs;

import com.driver.config.WebDriverUtils;
import com.pages.HomePage;
import com.pages.MotorsPage;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import cucumber.api.java.After;


import static org.junit.Assert.assertEquals;

public class TradeMePageSteps {

    WebDriver driver = null;

    @Before
    public void setUp(){
        driver = WebDriverUtils.getDriver();

    }

    @Given("^User navigates to TradeMe SandBox Page$")
    public void open_the_browser_and_launch_trademe_sandbox() throws Throwable
    {
        HomePage home = new HomePage(driver);
        home.navigate();
    }

    @When("^User go to used car page$")
    public void navigate_to_used_cars_page() throws Throwable
    {
        HomePage home = new HomePage(driver);
        home.clickMotorsBtn();
        MotorsPage motor = new MotorsPage(driver);
        motor.clickusedCarsLink();
    }

    @When("^User search for car \"(.*)\"$")
    public void search_for_car(String carName){
        HomePage home = new HomePage(driver);
        home.clickMotorsBtn();
        MotorsPage motor = new MotorsPage(driver);
        motor.searchForCar(carName);
    }

    @When("^Click any used car listing$")
    public void click_any_car_listing() throws InterruptedException {
        MotorsPage motor = new MotorsPage(driver);
        motor.clickAnyCarListing();
    }


    @Then("^User checks there is at least one listing in the UsedCars category$")
    public void check_table_results() throws Throwable
    {
        MotorsPage motor = new MotorsPage(driver);
        assertEquals(true, motor.checkListingResult());
    }

    @Then("^User verify there is at least one listing$")
    public void verify_search_results() throws Throwable
    {
        MotorsPage motor = new MotorsPage(driver);
        assertEquals(true, motor.verifySearchResults());
    }

    @Then("^User checks the car details \"(.*)\"$")
    public void verify_car_details(String varCarDetails) throws Throwable
    {
        String[] varDetails = varCarDetails.split(",");
        MotorsPage motor = new MotorsPage(driver);
        for(int i=0; i< varDetails.length; i++){
            assertEquals(true,motor.verifyCarDetailsLabel(varDetails[i], i));
        }
    }

    @After
    public void cleanUp(){
        driver.close();
    }
}