package PageObject;

import Constants.Constants;
import Util.Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {
    private final WebDriver driver;
    private final By nameInput = Locator.nameInput();
    private final By nameInputError = Locator.nameInputError();
    private final By surnameInput = Locator.surnameInput();
    private final By surnameInputError = Locator.surnameInputError();
    private final By addressInput = Locator.addressInput();
    private final By addressInputError = Locator.addressInputError();
    private final By metroStationMenu = Locator.metroStationMenu();
    private final By phoneInput = Locator.phoneInput();
    private final By phoneInputError = Locator.phoneInputError();
    private final By nextButtonFirstOrderForm = Locator.nextButtonFirstOrderForm();
    private final By deliveryDateInput = Locator.deliveryDateInput();
    private final By rentalPeriodMenu = Locator.rentalPeriodMenu();
    private final By[] rentalOptions = new By[Constants.RENTAL_OPTIONS];
    private final By finalOrderButton = Locator.finalOrderButton();
    private final By confirmOrderButton = Locator.confirmOrderButton();
    private final By orderConfirmedWindow = Locator.orderConfirmedWindow();


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Аналогично MainPage.updateFAQLocators, но этот используется в OrderPage.nextButtonFirstOrderFormClick
    private void updateRentalOptionsLocators() {
        for (int i = 0; i < Constants.RENTAL_OPTIONS; i++){
            this.rentalOptions[i] = Locator.rentalPeriodOption(i);
        }
    }

    public void nameInput(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public boolean nameInputErrorMessageCheck() {
        return driver.findElement(nameInputError).isDisplayed();
    }

    public void surnameInput(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
    }

    public boolean surnameInputErrorMessageCheck() {
        return driver.findElement(surnameInputError).isDisplayed();
    }

    public void addressInput(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public boolean addressInputErrorMessageCheck() {
        return driver.findElement(addressInputError).isDisplayed();
    }

    private void metroStationMenuClick() {
        driver.findElement(metroStationMenu).click();
    }

    // Сначала открываем меню выбора станции, затем выбираем, после того, как убеждаемся в появлении станций на экране
    public void metroStationInput(int metroStationIndex) {
        metroStationMenuClick();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(Locator.metroStationInput(0)));
        driver.findElement(Locator.metroStationInput(metroStationIndex)).click();
    }

    public void phoneInput(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public boolean phoneInputErrorMessageCheck() {
        return driver.findElement(phoneInputError).isDisplayed();
    }

    public void nextButtonFirstOrderFormClick() {
        driver.findElement(nextButtonFirstOrderForm).click();
    }

    public void orderDateInput(String orderDate) {
        driver.findElement(deliveryDateInput).sendKeys(orderDate);
        // Убираем всплывающий календарь
        driver.findElement(By.tagName("body")).click();
    }



    // Одновременно обновляем список с локаторами пунктов выпадающего списка.
    public void rentalPeriodMenuClick() {
        driver.findElement(rentalPeriodMenu).click();
        updateRentalOptionsLocators();
    }

    public void rentalOptionInput(int option) {
        driver.findElement(rentalOptions[option]).click();
    }

    public void finalOrderButtonClick() {
        driver.findElement(finalOrderButton).click();
    }

    public void confirmOrderButtonClick() {
        driver.findElement(confirmOrderButton).click();
    }

    public boolean orderConfirmedWindowCheck() {
        return driver.findElement(orderConfirmedWindow).isDisplayed();
    }
}
