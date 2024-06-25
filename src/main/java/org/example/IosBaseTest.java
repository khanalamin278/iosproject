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
        options.setApp("//Users//mobile_2//Downloads//resources//TestApp3.app");
        //options.setApp("/Users/mobile_2/Downloads/ios-uicatalog-master/UIKitCatalog/build/Release-iphonesimulator/UIKitCatalog-iphonesimulator.app");
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


/*
public class IosBaseTest {

    IOSDriver driver; // IOS ড্রাইভার ডিক্লেয়ার করা হয়েছে
    AppiumDriverLocalService service; // অ্যাপিয়াম সার্ভিস ডিক্লেয়ার করা হয়েছে


    @BeforeClass
    public void ConfigarAppium() throws MalformedURLException, URISyntaxException {
        service = new AppiumServiceBuilder()
                // Appium কোড --> Appium সার্ভার --> মোবাইল.
                .withAppiumJS(new File("//opt//homebrew//lib//node_modules//appium//index.js")) // অ্যাপিয়াম জেএস ফাইলের পাথ সেট করা
                .withIPAddress("127.0.0.1") // আইপি এড্রেস সেট করা
                .usingPort(4750) // পোর্ট নাম্বার সেট করা
                .build(); // সার্ভিস বিল্ড করা হচ্ছে

        service.start(); // সার্ভিস শুরু করা হচ্ছে

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 14 Pro Max"); // ডিভাইসের নাম সেট করা হচ্ছে
        options.setApp("//Users//mobile_2//Downloads//resources//TestApp3.app"); // অ্যাপের পাথ সেট করা হচ্ছে
        //options.setApp("/Users/mobile_2/Downloads/ios-uicatalog-master/UIKitCatalog/build/Release-iphonesimulator/UIKitCatalog-iphonesimulator.app");
        options.setPlatformVersion("16.4"); // প্ল্যাটফর্ম ভার্সন সেট করা হচ্ছে
        options.setWdaLocalPort(8150); // WDA লোকাল পোর্ট সেট করা হচ্ছে
        options.setWdaLaunchTimeout(Duration.ofSeconds(20)); // WDA লঞ্চ টাইমআউট সেট করা হচ্ছে

        driver = new IOSDriver(new URI("http://127.0.0.1:4750").toURL(), options); // IOS ড্রাইভার ইন্সট্যান্সিয়েট করা হচ্ছে
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // ড্রাইভার ইম্প্লিসিট টাইমআউট সেট করা হচ্ছে


    }

    public  void longPressIos(WebElement element){

        Map<String, Object> params = new HashMap<>(); // প্যারামিটার ম্যাপ তৈরি করা হচ্ছে

        params.put("element", ((RemoteWebElement)element).getId()); // এলিমেন্টের আইডি প্যারামিটারে রাখা হচ্ছে
        params.put("duration",5); // দীর্ঘ প্রেসের সময়কাল প্যারামিটারে রাখা হচ্ছে
        driver.executeScript("mobile:touchAndHold", params); // মোবাইল টাচএন্ডহোল্ড জেস্টার এক্সিকিউট করা হচ্ছে
    }

    public  void  scrollViewIos(WebElement element){
        Map<String, Object> params = new HashMap<>(); // প্যারামিটার ম্যাপ তৈরি করা হচ্ছে
        params.put("direction", "down"); // স্ক্রোল ডাইরেকশন নিচের দিকে সেট করা হচ্ছে
        params.put("element", ((RemoteWebElement)element).getId()); // এলিমেন্টের আইডি প্যারামিটারে রাখা হচ্ছে

        driver.executeScript("mobile:scroll",params); // মোবাইল স্ক্রোল জেস্টার এক্সিকিউট করা হচ্ছে
    }

    @AfterClass
    public void tearDown() {
        driver.quit(); // ড্রাইভার বন্ধ করা হচ্ছে
        service.stop(); // সার্ভিস বন্ধ করা হচ্ছে
        System.out.println("AfterClass"); // কনসোলে প্রিন্ট করা হচ্ছে
    }

}

*/
 */


