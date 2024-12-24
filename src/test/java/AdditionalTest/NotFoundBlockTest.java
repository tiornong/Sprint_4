package AdditionalTest;


import Constants.Constants;
import PageObject.TrackingPage;
import Util.BaseTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class NotFoundBlockTest extends BaseTest {

    private final String testBrowser;

    public NotFoundBlockTest(String browser) {
        this.testBrowser = browser;
    }

    @Parameterized.Parameters(name = "Браузер - {0}")
    public static Object[][] testData() {
        return new Object[][] {
                {"Chrome"},
                {"Firefox"},
        };
    }

    @Test
    public void notFoundBlockCheck() {
        driver = getDriver(testBrowser, Constants.TEST_URL_TRACK);
        TrackingPage trackingPage = new TrackingPage(driver);

        trackingPage.orderTrackNumberInput(Constants.NON_EXIST_TRACK);
        trackingPage.orderStatusCheckButtonClick();

        Assert.assertTrue(trackingPage.notFoundBlockCheckVisibility());
    }

}
