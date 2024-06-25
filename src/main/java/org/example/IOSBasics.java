package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
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
