package AdditionalTest;


import Constants.Constants;
import PageObject.MainPage;
import Util.BaseTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class LogoTest extends BaseTest {

    private final String testBrowser;

    public LogoTest(String testBrowser) {
        this.testBrowser = testBrowser;
    }

    @Parameterized.Parameters(name = "Браузер -- {0}")
    public static Object[][] testData() {
        return new Object[][]{
                {"Chrome"},
                {"Firefox"},
        };
    }

    @Test
    public void testYandexLogo() {
        driver = getDriver(testBrowser, Constants.TEST_URL_MAIN);
        MainPage mainPage = new MainPage(driver);

        mainPage.yandexLogoClick();

        Assert.assertEquals("https://yandex.ru/", driver.getCurrentUrl());
    }

    @Test
    public void testScooterLogo() {
        driver = getDriver(testBrowser, Constants.TEST_URL_MAIN);
        MainPage mainPage = new MainPage(driver);

        mainPage.scooterLogoClick();

        Assert.assertEquals(Constants.TEST_URL_MAIN, driver.getCurrentUrl());
    }

}
