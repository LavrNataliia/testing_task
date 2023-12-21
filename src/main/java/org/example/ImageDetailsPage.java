package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ImageDetailsPage {

    private WebDriver driver;

    public ImageDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Dimension getImageSize() {
        WebElement twentiethElement = driver.findElements(By.cssSelector("figure[itemprop='image']")).get(19);
        return twentiethElement.getSize();
    }

    public void clickDownloadButton() {
        WebElement downloadButton = driver.findElement(By.className("TaWJf"));
        downloadButton.click();
    }

    public void clickCrossButton() {
        WebElement crossButton = driver.findElement(By.className("YcKTH"));
        crossButton.click();
    }
}
