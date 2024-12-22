package MainTest;

import Constants.Constants;
import PageObject.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FAQTest {
    private WebDriver driver;

    @Test
    public void FAQPointOpenTestChrome() {
        driver = new ChromeDriver();
        driver.get(Constants.TEST_URL_MAIN);
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", mainPage.FAQ());
        mainPage.cookieAcceptanceButtonClick();

        for (int i = 0; i < Constants.FAQ_LENGTH; i++) {
            mainPage.FAQPointClick(i);
            Assert.assertTrue(mainPage.FAQPointText(i).isDisplayed());
        }
    }

    @Test
    public void FAQPointOpenTestFirefox() {
        driver = new FirefoxDriver();
        driver.get(Constants.TEST_URL_MAIN);
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", mainPage.FAQ());
        mainPage.cookieAcceptanceButtonClick();

        for (int i = 0; i < Constants.FAQ_LENGTH; i++) {
            mainPage.FAQPointClick(i);
            Assert.assertTrue(mainPage.FAQPointText(i).isDisplayed());
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

