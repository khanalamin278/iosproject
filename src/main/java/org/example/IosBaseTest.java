package org.example;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;


public class IosBaseTest {


    IOSDriver driver;
    AppiumDriverLocalService service;

    @BeforeClass //
    public void ConfigarAppium() throws MalformedURLException, URISyntaxException {
        service = new AppiumServiceBuilder()
                //Appium code --> Appium server --> mobile.
                .withAppiumJS(new File("C://Users//hp//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        service.start();
        System.out.println("BeforeClass..");

        XCUITestOptions options = new XCUITestOptions();

        options.setDeviceName("iPhone 14 Pro Max");

        options.setApp("C://Programming//QaWorks//IOSProject//src//main//java//resourses//UIKitCatalog.app");

        options.setPlatformVersion("16.4");
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        driver = new IOSDriver(new URI("http://127.0.0.1:4723").toURL(),options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
        System.out.println("AfterClass");
    }

}


