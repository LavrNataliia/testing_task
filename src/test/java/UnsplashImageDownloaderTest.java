import org.example.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class UnsplashImageDownloaderTest {

    private WebDriver driver;
    private UnsplashHomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = PageFactory.initElements(driver, UnsplashHomePage.class);
    }

    @Test
    public void downloadTwentiethImage() {
        homePage.navigateTo();
        HolidaysPage holidaysPage = homePage.clickOnHolidaysTab();
        Assert.assertEquals(holidaysPage.getCurrentUrl(), "https://unsplash.com/t/the-holidays", "URL does not match.");
        ImageDetailsPage imageDetailsPage = holidaysPage.clickOnTwentiethImage();
        Dimension imageSize = imageDetailsPage.getImageSize();
        System.out.println("Image Size: " + imageSize);
        imageDetailsPage.clickDownloadButton();
        Assert.assertTrue(imageSize.width > 100 && imageSize.height > 100, "Image size is smaller than expected.");
        imageDetailsPage.clickCrossButton();
    }

    @Test
    public void downloadTwentiethImageWallpaperTab() {
        homePage.navigateTo();
        WallpapersPage wallpapersPage = homePage.clickOnWallpapersTab();
        Assert.assertEquals(wallpapersPage.getCurrentUrl(), "https://unsplash.com/t/wallpapers", "URL does not match.");
        ImageDetailsPage imageDetailsPage = wallpapersPage.clickOnTwentiethImage();
        Dimension imageSize = imageDetailsPage.getImageSize();
        System.out.println("Image Size: " + imageSize);
        imageDetailsPage.clickDownloadButton();
        Assert.assertTrue(imageSize.width > 100 && imageSize.height > 100, "Image size is smaller than expected.");
        imageDetailsPage.clickCrossButton();
    }

    @Test(priority = 3)
    public void downloadTwentiethImageHealthTab() {
        homePage.navigateTo();
        homePage.scrollListToRight();
        HealthWellnessPage healthWellnessPage = homePage.clickOnHealthTab();
        Assert.assertEquals(healthWellnessPage.getCurrentUrl(), "https://unsplash.com/t/health", "URL does not match.");
        ImageDetailsPage imageDetailsPage = healthWellnessPage.clickOnTwentiethImage();
        Dimension imageSize = imageDetailsPage.getImageSize();
        System.out.println("Image Size: " + imageSize);
        imageDetailsPage.clickDownloadButton();
        Assert.assertTrue(imageSize.width > 100 && imageSize.height > 100, "Image size is smaller than expected.");
        imageDetailsPage.clickCrossButton();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
