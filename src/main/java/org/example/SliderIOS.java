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


/*
public class SliderIOS extends IosBaseTest {
    @Test
    public void sliderViewIOS() throws InterruptedException {
        // "AppElem" লেবেল সহ স্লাইডার এলিমেন্টটি খুঁজে বের করা
        WebElement slider = driver.findElement(AppiumBy.iOSClassChain("XCUIElementTypeSlider[`label == 'AppElem'`]"));
        // স্লাইডারটি 0% এ সেট করা
        slider.sendKeys("0%");
        // স্লাইডারের মান 0% কিনা তা যাচাই করা
        Assert.assertEquals("0%", slider.getAttribute("value"));
        // স্লাইডারটি 100% এ সেট করা
        slider.sendKeys("100%");
        // স্লাইডারের মান 100% কিনা তা যাচাই করা
        Assert.assertEquals("100%", slider.getAttribute("value"));
    }
}
 */