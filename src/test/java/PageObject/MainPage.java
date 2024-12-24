package PageObject;


import Constants.Constants;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MainPage {

    private final WebDriver driver;

    private final By[] FAQPoints = new By[Constants.FAQ_LENGTH];
    private final By[] FAQTexts = new By[Constants.FAQ_LENGTH];

    // Локатор для лого Яндекса
    private final By yandexLogo = By.xpath(".//a[starts-with(@class, 'Header_LogoYandex')]");

    // Локатор для лого Самоката
    private final By scooterLogo = By.xpath(".//a[starts-with(@class, 'Header_LogoScooter')]");

    // Локатор для верхней кнопки "Заказать"
    private final By upperOrderButton = By.xpath(".//div[starts-with(@class, 'Header_Nav')]/button[text()='Заказать']");

    // Локатор для нижней кнопки "Заказать"
    private final By bottomOrderButton = By.xpath(".//div[starts-with(@class, 'Home_FinishButton')]/button");

    // Локатор для кнопки принятия кук
    private final By cookieAcceptanceButton = By.xpath(".//button[starts-with(@class, 'App_CookieButton')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        updateFAQLocators();
    }

    /** Этот метод добавляет в соответствующие переменные локаторы на все пункты/содержимое пунктов FAQ по порядку при инициализации PO*/
    // Делаю приватным, так как, я считаю, что он не должен вызываться никак иначе, как при инициализации РО.
     private void updateFAQLocators() {
        for (int i = 1; i <= Constants.FAQ_LENGTH; i++){
            FAQPoints[i - 1] = By.xpath(String.format(".//div[@class='accordion__item'][%d]//div[@class='accordion__button']", i));
            FAQTexts[i - 1] = By.xpath(String.format(".//div[@class='accordion__item'][%d]//div[@class='accordion__panel']", i));
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
