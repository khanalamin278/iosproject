package org.example;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SwipeIOS extends IosBaseTest {
    @Test
    public void swipeMethod() throws InterruptedException {
        Map<String, Object> params = new HashMap<>();
        params.put("bundleId" , "com.apple.mobileslideshow");
        driver.executeScript("mobile:launchApp" , params);

        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos'")).click();
        List<WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        System.out.println(allPhotos.size());
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeCell[1]")).click();

        for (int i = 0; i < allPhotos.size(); i++) {
            //System.out.println(driver.findElement(AppiumBy.xpath("//XCUIElementTypeNavigationBar")).getAttribute("name"));
            Map<String, Object> params1 = new HashMap<>();
            params1.put("direction" , "left");
            driver.executeScript("mobile:swipe" , params1);
        }
    }
}


/*
public class SwipeIOS extends IosBaseTest {
    @Test
    public void swipeMethod() throws InterruptedException {
        // অ্যাপ চালু করার জন্য প্রয়োজনীয় প্যারামিটার সেট করা
        Map<String, Object> params = new HashMap<>();
        params.put("bundleId", "com.apple.mobileslideshow");
        // অ্যাপ চালু করা
        driver.executeScript("mobile: launchApp", params);
        // "All Photos" লেবেল সহ এলিমেন্টটি খুঁজে বের করে ক্লিক করা
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos'")).click();
        // সমস্ত ফটো এলিমেন্টগুলি খুঁজে বের করা
        List<WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("XCUIElementTypeCell"));
        // ফটো গুলির সংখ্যা প্রিন্ট করা
        System.out.println(allPhotos.size());
        // প্রথম ফটো এলিমেন্টটি খুঁজে বের করে ক্লিক করা
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeCell[1]")).click();

        // সমস্ত ফটো স্লাইড করার জন্য লুপ চালানো
        for (int i = 0; i < allPhotos.size(); i++) {
            // স্লাইড করার জন্য প্যারামিটার সেট করা
            Map<String, Object> params1 = new HashMap<>();
            params1.put("direction", "left");
            // বামে স্লাইড করা
            driver.executeScript("mobile: swipe", params1);
        }
    }
}
 */

