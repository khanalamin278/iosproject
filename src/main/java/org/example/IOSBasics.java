package org.example;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class IOSBasics extends IosBaseTest {
    @Test
    public void IOSBasicsTest(){
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
    }
}
