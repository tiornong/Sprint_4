package AdditionalTest;


import Constants.Constants;
import PageObject.MainPage;


import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LogoTest {

    private WebDriver driver;

    @Test
    public void testYandexLogoFirefox() {
        driver = new FirefoxDriver();
        driver.get(Constants.TEST_URL_MAIN);
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);

        mainPage.yandexLogoClick();

        Assert.assertEquals("https://yandex.ru/", driver.getCurrentUrl());
    }

    @Test
    public void testYandexLogoChrome() {
        driver = new ChromeDriver();
        driver.get(Constants.TEST_URL_MAIN);
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);

        mainPage.yandexLogoClick();

        Assert.assertEquals("https://yandex.ru/", driver.getCurrentUrl());
    }

    @Test
    public void testScooterLogoFirefox() {
        driver = new FirefoxDriver();
        driver.get(Constants.TEST_URL_MAIN);
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);

        mainPage.scooterLogoClick();

        Assert.assertEquals(Constants.TEST_URL_MAIN, driver.getCurrentUrl());
    }

    @Test
    public void testScooterLogoChrome() {
        driver = new ChromeDriver();
        driver.get(Constants.TEST_URL_MAIN);
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);

        mainPage.scooterLogoClick();

        Assert.assertEquals(Constants.TEST_URL_MAIN, driver.getCurrentUrl());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
