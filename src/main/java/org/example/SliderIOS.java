package org.example;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderIOS extends IosBaseTest{
    @Test
    public  void sliderViewIOS() throws InterruptedException {
        WebElement slider =  driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`label == 'AppElem'`]"));
        slider.sendKeys("0%");
        Assert.assertEquals("0%", slider.getAttribute("value"));
        slider.sendKeys("1%");
        Assert.assertEquals("100%", slider.getAttribute("value"));


    }
}
