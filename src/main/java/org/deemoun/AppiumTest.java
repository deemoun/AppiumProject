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

//    @Test
//    public void checkNumber(){
//        int a = 5;
//        int b = 5;
//        int c = a + b;
//        assertEquals(10, c);
//    }
    @Test
    public void pressTextButton() {
        // Test Logic Goes Here
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Text\"]")).click();
        driver.navigate().back();
    }

    @Test
    public void pressAnimationButton(){
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Animation\"]"));
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}