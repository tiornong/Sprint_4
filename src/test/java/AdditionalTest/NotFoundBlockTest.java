package AdditionalTest;

import Constants.Constants;
import PageObject.TrackingPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NotFoundBlockTest {
    private WebDriver driver;

    @Test
    public void notFoundBlockCheckChrome() {
        driver = new ChromeDriver();
        driver.get(Constants.TEST_URL_TRACK);
        TrackingPage trackingPage = new TrackingPage(driver);

        trackingPage.orderTrackNumberInput(Constants.NON_EXIST_TRACK);
        trackingPage.orderStatusCheckButtonClick();

        Assert.assertTrue(trackingPage.notFoundBlockCheckVisibility());
    }

    @Test
    public void notFoundBlockCheckFirefox() {
        driver = new FirefoxDriver();
        driver.get(Constants.TEST_URL_TRACK);
        TrackingPage trackingPage = new TrackingPage(driver);

        trackingPage.orderTrackNumberInput(Constants.NON_EXIST_TRACK);
        trackingPage.orderStatusCheckButtonClick();

        Assert.assertTrue(trackingPage.notFoundBlockCheckVisibility());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
