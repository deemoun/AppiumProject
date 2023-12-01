package org.deemoun;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class MainPage {
    private final AppiumDriver driver;

    public MainPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void waitForMoment() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void pressButton(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public void pressTextButton() {
        pressButton("//*[@content-desc='Text']");
    }

    public void pressAnimationButton() {
        pressButton("//*[@content-desc='Animation']");
    }

    public boolean checkForContentElement(){
        return driver.findElement(By.xpath("//*[@content-desc='Content']")).isDisplayed();
    }
}
