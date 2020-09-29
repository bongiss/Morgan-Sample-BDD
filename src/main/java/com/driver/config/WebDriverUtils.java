package com.driver.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverUtils {

    public static WebDriver getDriver(){
        ConfigFileReader configFileReader = new ConfigFileReader();
        String browserType = configFileReader.getBrowserType();
        WebDriver driver;


        switch (browserType) {
            case "Chrome" :
                driver = new ChromeDriver();
                break;
            case "IE":
                //to follow
            case "Firefox":
                driver = new FirefoxDriver();
            default:
                driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        return driver;

    }
}
