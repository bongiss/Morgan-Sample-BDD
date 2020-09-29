package com.pages;

import com.driver.config.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    ConfigFileReader configFileReader = new ConfigFileReader();

    private String pageUrl = configFileReader.getTestEnv();

    //Locators

    @FindBy(xpath="//*[@class=\"site-header-logo\"]")
    private WebElement tradeMeLogo;

    @FindBy(xpath="//*[@id=\"SearchTabs1_MotorsLink\"]")
    private WebElement motorsButton;

    @FindBy(xpath="//a[@id='SiteHeader_SideBar_AttributeSearch_SearchHeader' and @href='/motors']")
    private WebElement motorsLogo;



    //Constructor
    public HomePage(WebDriver driver){

        this.driver=driver;
        PageFactory.initElements(driver, this);
        driver.get(pageUrl);

    }

    public void navigate(){
        WebDriverWait wait = new WebDriverWait(driver, configFileReader.getImplicitlyWait());
        wait.until(ExpectedConditions.visibilityOf(tradeMeLogo));

    }

    public void clickMotorsBtn(){
        motorsButton.click();
        WebDriverWait wait = new WebDriverWait(driver, configFileReader.getImplicitlyWait());
        wait.until(ExpectedConditions.visibilityOf(motorsLogo));
    }
}