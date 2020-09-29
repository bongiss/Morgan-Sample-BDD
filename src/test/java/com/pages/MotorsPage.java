package com.pages;

import com.driver.config.ConfigFileReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MotorsPage {
    private WebDriver driver;

    ConfigFileReader configFileReader = new ConfigFileReader();

    @FindBy(xpath="//a[@href='/motors/used-cars']")
    private WebElement usedCarsLink;

    @FindBy(xpath = "//*[@class='motors']")
    private WebElement resultList;

    @FindBy(xpath = "//*[@id='searchString']")
    private WebElement txtSearch;

    @FindBy(xpath = "//*[@type='submit' and @value='Search']")
    private WebElement btnSearch;

    @FindBy(xpath = "//*[@class='tmm-search-card-list-view__card']")
    private WebElement carList;

    @FindBy(xpath = "//*[@class='motors-attribute-label']")
    private WebElement labelNumberPlate;

    @FindBy(xpath = "//*[@class='key-details-attribute-label']")
    private List<WebElement> labelCarDetails;

    @FindBy(xpath = "//*[@class='key-details-attribute-value']")
    private List<WebElement> labelCarDetailsValue;



    //Constructor
    public MotorsPage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    public void clickusedCarsLink() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, configFileReader.getImplicitlyWait());
        wait.until(ExpectedConditions.visibilityOf(usedCarsLink));
        Thread.sleep(3000);
        usedCarsLink.click();
    }

    public void clickAnyCarListing() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, configFileReader.getImplicitlyWait());
        wait.until(ExpectedConditions.visibilityOf(carList));
        Thread.sleep(3000);
        carList.click();
    }

    public Boolean checkListingResult(){
        WebDriverWait wait = new WebDriverWait(driver, configFileReader.getImplicitlyWait());
        try {
            driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
            carList.isDisplayed();
            return true;
        }
        catch (NoSuchElementException e ) {
            return false;
        }
        catch (StaleElementReferenceException f) {
            return false;
        }
    }

    public void searchForCar(String carName){
        txtSearch.sendKeys(carName);
        btnSearch.click();
    }

    public Boolean verifySearchResults(){
        WebDriverWait wait = new WebDriverWait(driver, configFileReader.getImplicitlyWait());
        try {
            driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
            carList.isDisplayed();
            return true;
        }
        catch (NoSuchElementException e ) {
            return false;
        }
        catch (StaleElementReferenceException f) {
            return false;
        }
    }

    public Boolean verifyCarDetailsLabel(String varDetails, int index){
        WebDriverWait wait = new WebDriverWait(driver, configFileReader.getImplicitlyWait());
        try {
            driver.manage().timeouts().implicitlyWait(configFileReader.getImplicitlyWait(), TimeUnit.SECONDS);
            labelCarDetails.get(index).isDisplayed();
            labelCarDetailsValue.get(index).isDisplayed();
            System.out.println(labelCarDetails.get(index).getText() + ": " + labelCarDetailsValue.get(index).getText());
            return true;
        }
        catch (NoSuchElementException e ) {
            return false;
        }
        catch (StaleElementReferenceException f) {
            return false;
        }
    }

}