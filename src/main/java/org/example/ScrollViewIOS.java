package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollViewIOS extends IosBaseTest {
    @Test
    public  void scrollForos() throws InterruptedException {

        WebElement ele =  driver.findElement(AppiumBy.accessibilityId("Web View"));
        scrollViewIos(ele);

        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name ='UIKitCatalog']")).click();
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();


        driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("50");
        driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("120");
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).sendKeys("110");

        String namber =  driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).getText();
        Assert.assertEquals(namber,"110");
    }
}


/*

public class ScrollViewIOS extends IosBaseTest {
    @Test
    public void scrollForos() throws InterruptedException {
        // "Web View" এলিমেন্টটি খুঁজে বের করা
        WebElement ele = driver.findElement(AppiumBy.accessibilityId("Web View"));
        // স্ক্রোল জেস্টার এক্সিকিউট করা
        scrollViewIos(ele);
        // "Web View" এলিমেন্টটি খুঁজে বের করে ক্লিক করা
        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        // ২ সেকেন্ড অপেক্ষা করা
        Thread.sleep(2000);
        // "UIKitCatalog" বাটন এলিমেন্টটি খুঁজে বের করে ক্লিক করা
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name ='UIKitCatalog']")).click();
        // "Picker View" এলিমেন্টটি খুঁজে বের করে ক্লিক করা
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
        // "Red color component value" এলিমেন্টটি খুঁজে বের করে "50" পাঠানো
        driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("50");
        // "Green color component value" এলিমেন্টটি খুঁজে বের করে "120" পাঠানো
        driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("120");
        // "Blue color component value" এলিমেন্টটি খুঁজে বের করে "110" পাঠানো
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).sendKeys("110");
        // "Blue color component value" এলিমেন্ট থেকে টেক্সট নেওয়া
        String number = driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Blue color component value'")).getText();
        // টেক্সট "110" কিনা যাচাই করা
        Assert.assertEquals(number, "110");
    }
}
*/