package org.deemoun;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.Assert.assertEquals;

/* Примеры других аннотаций в JUnit
    @Test
    @Before
    @After
    @BeforeClass
    @AfterClass
    @Ignore
    @RunWith
    @Parameters
    @ParameterizedTest
    @Test(expected)
    @Test(timeout)
    @Disabled
    @DisplayName
 */

public class AppiumTest {

    private static AppiumDriver driver;

    @BeforeClass
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "emulator-5554");
        caps.setCapability("app", "/Users/deemounus/Desktop/ApiDemos-debug.apk");

        URL appiumServerURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(appiumServerURL, caps);
    }

    public void navigateBack(AppiumDriver driver){
        driver.navigate().back();
    }

    public void pressButton(AppiumDriver driver, String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    @Test
    public void pressTextButton() {
        // Test Logic Goes Here
        pressButton(driver,"//android.widget.TextView[@content-desc=\"Text\"]");
        navigateBack(driver);
    }


    @Test
    public void pressAnimationButton(){
        pressButton(driver,"//android.widget.TextView[@content-desc=\"Animation\"]");
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}