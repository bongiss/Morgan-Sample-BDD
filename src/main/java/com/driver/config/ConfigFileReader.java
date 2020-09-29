package com.driver.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;

    public ConfigFileReader(){

        properties = new Properties();
        String propertyFileName = "config.properties";
        InputStream propertiesStream = ConfigFileReader.class.getClassLoader().getResourceAsStream(propertyFileName);
        if (propertiesStream != null){
            try {
                properties.load(propertiesStream);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        else
            throw new RuntimeException("Property file not on classpath");

    }

    public String getBrowserType(){ return properties.getProperty("test.browser.name");}

//    public String getChromeDriverPath(){ return System.getProperty("user.dir") + properties.getProperty("test.browser.name.chrome.dir");}

    public Long getImplicitlyWait(){ return Long.parseLong(properties.getProperty("test.implicitly.wait"));}

    public String getTestEnv(){return properties.getProperty("test.environment");}

    public String getUsername(){return  properties.getProperty("test.user.name");}
    public String getPassword(){return properties.getProperty("test.user.password");}

}
