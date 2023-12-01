package org.deemoun;

import com.sun.tools.javac.Main;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AppiumTest {
    private static AppiumDriver driver;
    private MainPage mainPage;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("app", "/Users/deemounus/Desktop/ApiDemos-debug.apk");

        URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(appiumServerURL, caps);
    }

    @Before
    public void initializePageObjects() {
        mainPage = new MainPage(driver);
    }

    @Test
    public void pressTextButton() {
        // Test Logic Goes Here
        mainPage.pressTextButton();
        mainPage.navigateBack();
    }

    @Test
    public void pressAnimationButton() {
        mainPage.waitForMoment();
        mainPage.pressAnimationButton();
    }

    @Test
    public void checkForElement(){
        mainPage.waitForMoment();
        assertTrue("Content element is there", mainPage.checkForContentElement());
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}