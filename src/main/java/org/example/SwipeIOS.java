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


