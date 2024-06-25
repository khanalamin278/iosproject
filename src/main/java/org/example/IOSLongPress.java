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

