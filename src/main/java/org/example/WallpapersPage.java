package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WallpapersPage {

    private WebDriver driver;

    public WallpapersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public ImageDetailsPage clickOnTwentiethImage() {
        WebElement twentiethElement = driver.findElements(By.cssSelector("figure[itemprop='image']")).get(19);
        twentiethElement.click();
        return new ImageDetailsPage(driver);
    }
}
