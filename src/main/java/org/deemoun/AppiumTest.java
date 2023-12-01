package org.deemoun;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

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

    public void waitForMoment(AppiumDriver driver){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void pressButton(AppiumDriver driver, String xpath){
        driver.findElement(By.xpath(xpath));
    }

    @Test
    public void pressTextButton() {
        // Test Logic Goes Here
        pressButton(driver,"//*[@content-desc='Text']");
        //navigateBack(driver);
    }


    @Test
    public void pressAnimationButton(){
        waitForMoment(driver);
        pressButton(driver,"//*[@content-desc='Animation']");
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}