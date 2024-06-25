package org.example;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class IOSBasics extends IosBaseTest {
    @Test
    public void IOSBasicsTest(){
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        //driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label=='Text Entry'`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello World");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();

        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[C] 'Confirm'")).click();
        String text= driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[C] 'A message'")).getText();
        System.out.println(text);
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();
    }
}


/*

public class IOSBasics extends IosBaseTest {
    @Test
    public void IOSBasicsTest(){
        // "Alert Views" এলিমেন্টটি খুঁজে বের করে ক্লিক করা
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        // "Text Entry" এলিমেন্টটি খুঁজে বের করে ক্লিক করা
        driver.findElement(AppiumBy.iOSClassChain("XCUIElementTypeStaticText[`label=='Text Entry'`]")).click();
        // টেক্সট এন্ট্রি সেল এলিমেন্টটি খুঁজে বের করে "Hello World" পাঠানো
        driver.findElement(AppiumBy.iOSClassChain("XCUIElementTypeCell")).sendKeys("Hello World");
        // "OK" বাটন এলিমেন্টটি খুঁজে বের করে ক্লিক করা
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
        // "Confirm" এলিমেন্টটি খুঁজে বের করে ক্লিক করা
        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[C] 'Confirm'")).click();
        // "A message" শুরু হওয়া নামের এলিমেন্ট থেকে টেক্সট নেওয়া
        String text = driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[C] 'A message'")).getText();
        System.out.println(text); // প্রিন্ট করা
        // "Confirm" লেবেলযুক্ত এলিমেন্টটি খুঁজে বের করে ক্লিক করা
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();
    }
}
 */