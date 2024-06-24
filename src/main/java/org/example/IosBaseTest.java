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

        options.setApp("C://Programming//QaWorks//khan//src//test//java//resource//ApiDemos-debug.apk");

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



/*
public class BaseTest {

    AndroidDriver driver; // AndroidDriver অবজেক্ট ড্রাইভার হিসেবে সংজ্ঞায়িত করা হচ্ছে
    AppiumDriverLocalService service; // AppiumDriverLocalService অবজেক্ট সার্ভিস হিসেবে সংজ্ঞায়িত করা হচ্ছে

    @BeforeClass // @BeforeClass এনোটেশন দিয়ে নির্দেশিত হচ্ছে যে, এই মেথডটি ক্লাসের সমস্ত টেস্ট চালানোর আগে একবার চালানো হবে
    public void ConfigarAppium() throws MalformedURLException, URISyntaxException { // এই মেথডটি Appium সার্ভার কনফিগার এবং শুরু করার জন্য ব্যবহৃত হচ্ছে
        service = new AppiumServiceBuilder()
                //Appium কোড --> Appium সার্ভার --> মোবাইল.
                .withAppiumJS(new File("C://Users//hp//AppData//Roaming//npm//node_modules//appium//build//lib//main.js")) // Appium সার্ভার চালানোর জন্য AppiumJS ফাইলের লোকেশন নির্ধারণ করা হচ্ছে
                .withIPAddress("127.0.0.1") // লোকালহোস্ট আইপিএড্রেস ব্যবহার করা হচ্ছে
                .usingPort(4723) // পোর্ট 4723 ব্যবহার করা হচ্ছে
                .build(); // সার্ভিস বিল্ড করা হচ্ছে

        service.start(); // সার্ভিস শুরু করা হচ্ছে
        System.out.println("BeforeClass.."); // কনসোলে "BeforeClass.." প্রিন্ট করা হচ্ছে

        UiAutomator2Options options = new UiAutomator2Options(); // UiAutomator2Options অবজেক্ট তৈরি করা হচ্ছে

        options.setDeviceName("Pixel 2 API 34"); // ডিভাইসের নাম সেট করা হচ্ছে

        options.setApp("C://Programming//QaWorks//khan//src//test//java//resource//ApiDemos-debug.apk"); // অ্যাপের লোকেশন সেট করা হচ্ছে

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options); // AndroidDriver ইনিশিয়ালাইজ করা হচ্ছে

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // ড্রাইভারের জন্য ১০ সেকেন্ডের ইমপ্লিসিট ওয়েট টাইমআউট সেট করা হচ্ছে
    }

    public void longPressAction(WebElement webElement) { // একটি উপাদানে লং প্রেস একশন কার্যকর করার মেথড

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) webElement).getId(), "duration", 2000
                )); // লং প্রেস জেসচার কার্যকর করা হচ্ছে, ২০০০ মিলিসেকেন্ডের জন্য
    }

    public void scrolloToAction() { // স্ক্রোল একশন কার্যকর করার মেথড

        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200, // স্ক্রোল জেসচারের প্যারামিটার সেট করা হচ্ছে
                    "direction", "down", // নিচের দিকে স্ক্রোল করা হচ্ছে
                    "percent", 1.0 // স্ক্রোলের শতাংশ নির্ধারণ করা হচ্ছে
            ));

        } while (canScrollMore); // যতক্ষণ স্ক্রোল করা সম্ভব ততক্ষণ স্ক্রোল করা হচ্ছে
    }

    public void swipeToAction(WebElement element, String str) { // একটি উপাদানে সোয়াইপ একশন কার্যকর করার মেথড

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(), // সোয়াইপ জেসচারের জন্য উপাদানের আইডি
                "direction", str, // সোয়াইপের দিক নির্ধারণ করা হচ্ছে
                "percent", 0.50 // সোয়াইপের শতাংশ নির্ধারণ করা হচ্ছে
        ));
    }

    @AfterClass // @AfterClass এনোটেশন দিয়ে নির্দেশিত হচ্ছে যে, এই মেথডটি ক্লাসের সমস্ত টেস্ট চালানোর পরে একবার চালানো হবে
    public void tearDown() {

        driver.quit(); // ড্রাইভার বন্ধ করা হচ্ছে
        service.stop(); // সার্ভিস বন্ধ করা হচ্ছে
        System.out.println("AfterClass"); // কনসোলে "AfterClass" প্রিন্ট করা হচ্ছে
    }

}

 */