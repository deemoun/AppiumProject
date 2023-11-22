package org.deemoun;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTest {

    private static AppiumDriver driver;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554"); // Replace with your device name
        caps.setCapability("app", "/Users/deemounus/Desktop/ApiDemos-debug.apk"); // Replace with the path to your app APK

        URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(appiumServerURL, caps);
    }

    @Test
    public void pressTextButton() {
        // Test Logic Goes Here
    driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Text\"]")).click();
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}