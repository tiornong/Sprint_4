package PageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TrackingPage {
    private final WebDriver driver;
    private final By notFoundBlock = By.xpath(".//div[starts-with(@class, 'Track_NotFound')]");
    private final By orderTrackNumberInput = By.xpath(".//input[contains(@class, 'Track_Input')]");
    private final By orderStatusCheckButton = By.xpath(".//button[text()='Посмотреть']");

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
