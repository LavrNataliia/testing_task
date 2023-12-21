package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UnsplashHomePage {

    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/div/div[3]/div/div[2]/ul/li[3]/a")
    public WebElement holidaysTab;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/div/div[3]/div/div[2]/ul/li[4]/a")
    public WebElement wallpapersTab;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div/div[2]/div/div/div/div[3]/div/div[3]/ul/li[17]/a")
    public WebElement healthTab;

    @FindBy(css = "[title='scroll list to the right']")
    public WebElement scrollListToRight;

    public UnsplashHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateTo() {
        driver.get("https://unsplash.com/");
    }

    public HolidaysPage clickOnHolidaysTab() {
        holidaysTab.click();
        return new HolidaysPage(driver);
    }

    public WallpapersPage clickOnWallpapersTab() {
        wallpapersTab.click();
        return new WallpapersPage(driver);
    }

    public void scrollListToRight() {
        scrollListToRight.click();
    }

    public HealthWellnessPage clickOnHealthTab() {
        healthTab.click();
        scrollListToRight();
        return new HealthWellnessPage(driver);
    }
}

