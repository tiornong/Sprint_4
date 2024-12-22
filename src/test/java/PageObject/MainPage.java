package PageObject;

import Constants.Constants;
import Util.Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {
    private final WebDriver driver;

    // Создаем поля с локаторами всех необходимых элементов на главной странице.
    private final By[] FAQPoints = new By[Constants.FAQ_LENGTH];
    private final By[] FAQTexts = new By[Constants.FAQ_LENGTH];
    private final By yandexLogo = Locator.yandexLogo();
    private final By scooterLogo = Locator.scooterLogo();
    private final By upperOrderButton = Locator.orderButton(true);
    private final By bottomOrderButton = Locator.orderButton(false);
    private final By cookieAcceptanceButton = Locator.cookieAcceptanceButton();

    public MainPage(WebDriver driver) {
        this.driver = driver;
        updateFAQLocators();
    }

    // Этот метод добавляет в соответствующие переменные локаторы на ВСЕ пункты/содержимое пунктов FAQ по порядку.
    // Делаю приватным, так как, я считаю, что он не должен вызываться никак иначе, как при инициализации РО.
    private void updateFAQLocators() {
        for (int i = 1; i <= Constants.FAQ_LENGTH; i++){
            FAQPoints[i - 1] = Locator.FAQPoint(i);
            FAQTexts[i - 1] = Locator.FAQText(i);
        }
    }

    public void yandexLogoClick() {
        driver.findElement(yandexLogo).click();
    }

    public void scooterLogoClick() {
        driver.findElement(scooterLogo).click();
    }

    public void FAQPointClick(int number) {
        driver.findElement(FAQPoints[number]).click();
    }

    public WebElement FAQPointText(int number) {
        return driver.findElement(FAQTexts[number]);
    }

    // Специально для проматывания страницы до ЧаВо.
    public WebElement FAQ() {
        return driver.findElement(FAQPoints[0]);
    }

    public void upperOrderButtonClick() {
        driver.findElement(upperOrderButton).click();
    }

    public void lowerOrderButtonClick() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(bottomOrderButton));
        driver.findElement(bottomOrderButton).click();
    }

    public void cookieAcceptanceButtonClick() {
        driver.findElement(cookieAcceptanceButton).click();
    }
}
