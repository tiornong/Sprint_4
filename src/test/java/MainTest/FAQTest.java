package MainTest;


import Constants.Constants;
import PageObject.MainPage;

import Util.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;


@RunWith(Parameterized.class)
public class FAQTest extends BaseTest {

    private final String testBrowser;
    private final int FAQNumber;

    public FAQTest(String testBrowser, int FAQNumber) {
        this.testBrowser = testBrowser;
        this.FAQNumber = FAQNumber;
    }

    @Parameterized.Parameters(name = "Браузер - {0}, пункт ЧаВо - {1}")
    public static Object[][] testData() {
        return new Object[][] {
                {"Chrome", 1},
                {"Chrome", 2},
                {"Chrome", 3},
                {"Chrome", 4},
                {"Chrome", 5},
                {"Chrome", 6},
                {"Chrome", 7},
                {"Firefox", 1},
                {"Firefox", 2},
                {"Firefox", 3},
                {"Firefox", 4},
                {"Firefox", 5},
                {"Firefox", 6},
                {"Firefox", 7},
        };
    }

    @Test
    public void FAQPointOpenTestChrome() {
        driver = getDriver(testBrowser, Constants.TEST_URL_MAIN);
        MainPage mainPage = new MainPage(driver);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", mainPage.FAQ());
        mainPage.cookieAcceptanceButtonClick();

        mainPage.FAQPointClick(FAQNumber);
        Assert.assertTrue(mainPage.FAQPointText(FAQNumber).isDisplayed());
    }

}

