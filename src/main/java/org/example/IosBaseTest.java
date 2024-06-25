package org.example;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;



public class IosBaseTest {

    IOSDriver driver;
    AppiumDriverLocalService service;


    @BeforeClass
    public void ConfigarAppium() throws MalformedURLException, URISyntaxException {
        service = new AppiumServiceBuilder()
                //Appium code --> Appium server --> mobile.
                .withAppiumJS(new File("//opt//homebrew//lib//node_modules//appium//index.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4750)
                .build();

        service.start();

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 14 Pro Max");
        options.setApp("/Users/mobile_2/Downloads/ios-uicatalog-master/UIKitCatalog/build/Release-iphonesimulator/UIKitCatalog-iphonesimulator.app");
        options.setPlatformVersion("16.4");
        options.setWdaLocalPort(8150);
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));




        driver = new IOSDriver(new URI("http://127.0.0.1:4750").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    public  void longPressIos(WebElement element){

        Map<String, Object> params = new HashMap<>();

        params.put("element", ((RemoteWebElement)element).getId());
        params.put("duration",5);
        driver.executeScript("mobile:touchAndHold", params);
    }

    public  void  scrollViewIos(WebElement element){
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((RemoteWebElement)element).getId());

        driver.executeScript("mobile:scroll",params);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
        System.out.println("AfterClass");
    }

}


