package org.example;


import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



public class IOSLongPress extends IosBaseTest {
    @Test
    public void longPressText() throws InterruptedException {

        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
        WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label=='Increment'`][3]"));
        longPressIos(ele);

    }
}


/*
public class IOSLongPress extends IosBaseTest {
    @Test
    public void longPressText() throws InterruptedException {
        // "Steppers" এলিমেন্টটি খুঁজে বের করে ক্লিক করা
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();
        // "Increment" বাটন এলিমেন্টটি খুঁজে বের করা
        WebElement ele = driver.findElement(AppiumBy.iOSClassChain("XCUIElementTypeButton[`label=='Increment'`][3]"));
        // দীর্ঘ প্রেস জেস্টার এক্সিকিউট করা
        longPressIos(ele);
    }
}
 */