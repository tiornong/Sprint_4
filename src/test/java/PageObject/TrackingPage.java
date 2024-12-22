package PageObject;

import Util.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TrackingPage {
    private final WebDriver driver;
    private final By notFoundBlock = Locator.notFoundBlock();
    private final By orderTrackNumberInput = Locator.orderTrackNumberInput();
    private final By orderStatusCheckButton = Locator.orderStatusCheckButton();

    public TrackingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void orderTrackNumberInput(String orderTrackNumber) {
        driver.findElement(orderTrackNumberInput).sendKeys(orderTrackNumber);
    }

    public void orderStatusCheckButtonClick() {
        driver.findElement(orderStatusCheckButton).click();
    }

    public boolean notFoundBlockCheckVisibility() {
        return driver.findElement(notFoundBlock).isDisplayed();
    }
}
