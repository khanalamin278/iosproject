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
