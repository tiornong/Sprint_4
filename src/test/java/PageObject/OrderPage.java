package PageObject;


import Constants.Constants;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderPage {

    private final WebDriver driver;

    // Локатор для поля Имя в первом шаге Формы заказа
    private final By nameInput = By.xpath(".//input[@placeholder='* Имя']");

    // Локатор для сообщения об ошибке при вводе некорректного значения в поле Имя в первом шаге Формы заказа
    private final By nameInputError = By.xpath(".//div[text()='Введите корректное имя']");

    // Локатор для поля Фамилия в первом шаге Формы заказа
    private final By surnameInput = By.xpath(".//input[@placeholder='* Фамилия']");

    // Локатор для сообщения об ошибке при вводе некорректного значения в поле Фамилия в первом шаге Формы заказа
    private final By surnameInputError = By.xpath(".//div[text()='Введите корректную фамилию']");

    // Локатор для поля Адрес в первом шаге Формы заказа
    private final By addressInput = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // Локатор для сообщения об ошибке при вводе некорректного значения в поле Фамилия в первом шаге Формы заказа
    private final By addressInputError = By.xpath(".//div[text()='Введите корректный адрес']");

    // Локатор для меню выбора станции метров в первом шаге Формы заказа
    private final By metroStationMenu = By.xpath(".//input[@placeholder='* Станция метро']");

    // Локатор для поля Телефон в первом шаге Формы заказа
    private final By phoneInput = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Локатор для сообщения об ошибке при вводе некорректного значения в поле Телефон в первом шаге Формы заказа
    private final By phoneInputError = By.xpath(".//div[text()='Введите корректный адрес']");

    // Локатор для кнопки перехода на второй шаг Формы заказа
    private final By nextButtonFirstOrderForm = By.xpath(".//button[text()='Далее']");

    // Локатор для поля ввода Дата доставки во втором шаге Формы заказа
    private final By deliveryDateInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // Локатор для меню выбора срока аренды во втором шаге Формы заказа
    private final By rentalPeriodMenu = By.xpath(".//div[@class='Dropdown-control']");

    // Список локаторов для всех сроков аренды самоката во втором шаге Формы заказа
    private final By[] rentalOptions = new By[Constants.RENTAL_OPTIONS];

    // Локатор для кнопки завершения заполнения Формы заказа
    private final By finalOrderButton = By.xpath(".//div[starts-with(@class, 'Order_Buttons')]/button[text()='Заказать']");

    // Локатор для кнопки подтверждения совершения заказа
    private final By confirmOrderButton = By.xpath(".//button[text()='Да']");

    // Локатор для уведомления об успешном совершении заказа
    private final By orderConfirmedWindow = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Аналогично MainPage.updateFAQLocators, но этот используется в OrderPage.nextButtonFirstOrderFormClick
    private void updateRentalOptionsLocators() {
        for (int i = 0; i < Constants.RENTAL_OPTIONS; i++){
            this.rentalOptions[i] = By.xpath(String.format(".//div[@role='option'][%d]", i));
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

    /** Происходит открытие меню выбора станции, затем выбор станции, соответствующей metroStationIndex */
    public void metroStationInput(int metroStationIndex) {
        metroStationMenuClick();

        /*
          Выносить metroStationIndex как By[] в поля класса нет смысла из-за потенциального размера этого массива (более 200 элементов).

          Так же, возможна ситуация с варьирующимся во время заказа списком станций (на некоторые станции по каким-либо причинам доставка может отключиться),
          так что здесь имеет смысл искать локатор станции только при открытии меню, в то время, как ЧаВо гораздо более стабильная сущность (к тому же меньшей длины),
          так что локаторы для него мы можем сохранить единожды при инициализации MainPage
        */

        // Для повышения читаемости ожидания -- лесенка
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(String.format(".//li[@data-index='%d']/button", metroStationIndex))));
        driver.findElement(By.xpath(String.format(".//li[@data-index='%d']/button", metroStationIndex))).click();
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

    /** Метод для ввода даты доставки в виде строки. После ввода происходит нажатие в пустоту для исчезновения всплывающего календаря. */
    public void orderDateInput(String orderDate) {
        driver.findElement(deliveryDateInput).sendKeys(orderDate);

        // Убираем всплывающий календарь
        driver.findElement(By.tagName("body")).click();
    }

    /** Метод для открытия меню выбора срока аренды.
     * Одновременно обновляем список с локаторами пунктов выпадающего списка. */
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
