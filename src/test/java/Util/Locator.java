package Util;

import org.openqa.selenium.By;


public class Locator {
    /*
    Локатор должен быть:
        1. Необходим для целей проекта.
        2. Понятен стороннему наблюдателю.
        3. Максимально краток.
    */

    // Общий локатор для пунктов FAQ на главной странице.
    public static By FAQPoint(int number) {
        return By.xpath(String.format(".//div[@class='accordion__item'][%d]//div[@class='accordion__button']", number));
        // Попытка сократить до последнего div с индексом привело к утрате уникальности, так что больше не сократить
    }

    // Общий локатор для содержимого пунктов FAQ на главной странице.
    public static By FAQText(int number) {
        return By.xpath(String.format(".//div[@class='accordion__item'][%d]//div[@class='accordion__panel']", number));
        // Попытка сократить до последнего div с индексом привело к утрате уникальности, так что больше не сократить
    }

    // Локатор для кнопки "Заказать"
    // Решил объединить выдачу локаторов для верхней кнопки и нижней,
    // так как нет особого смысла разделять их на два разных, в силу одинакового поведения и функционала.
    public static By orderButton(boolean upper){
        if (upper){
            return By.xpath(".//div[starts-with(@class, 'Header_Nav')]/button[text()='Заказать']");
        }
        return By.xpath(".//div[starts-with(@class, 'Home_FinishButton')]/button");
    }

    // Локатор для поля Имя в первом шаге Формы заказа.
    public static By nameInput(){
        return By.xpath(".//input[@placeholder='* Имя']");
    }

    // Локатор для сообщения об ошибке для поля Имя в первом шаге Формы заказа.
    public static By nameInputError(){
        return By.xpath(".//div[text()='Введите корректное имя']");
    }

    // Локатор для поля Фамилия в первом шаге Формы заказа.
    public static By surnameInput(){
        return By.xpath(".//input[@placeholder='* Фамилия']");
    }

    // Локатор для сообщения об ошибке для поля Фамилия в первом шаге Формы заказа.
    public static By surnameInputError(){
        return By.xpath(".//div[text()='Введите корректную фамилию']");
    }

    // Локатор для поля Адрес в первом шаге Формы заказа.
    public static By addressInput(){
        return By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    }

    // Локатор для сообщения об ошибке для поля Адрес в первом шаге Формы заказа.
    public static By addressInputError(){
        return By.xpath(".//div[text()='Введите корректный адрес']");
    }

    // Локатор для поля Станция метро в первом шаге Формы заказа.
    public static By metroStationMenu(){
        return By.xpath(".//input[@placeholder='* Станция метро']");
    }

    // Локатор для выбора конкретной станции метро по её индексу
    public static By metroStationInput(int metroStationIndex) {
        return By.xpath(String.format(".//li[@data-index='%d']/button", metroStationIndex));
    }


    // Локатор для поля Телефон в первом шаге Формы заказа.\
    public static By phoneInput(){
        return By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    }

    // Локатор для сообщения об ошибке для поля Телефон в первом шаге Формы заказа.
    public static By phoneInputError(){
        return By.xpath(".//div[text()='Введите корректный адрес']");
    }

    // Локатор для кнопки "Далее" в первом шаге Формы заказа.
    public static By nextButtonFirstOrderForm(){
        return By.xpath(".//button[text()='Далее']");
    }

    // Локатор для поля Дата во втором шаге Формы заказа.
    public static By deliveryDateInput(){
        return By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    }

    // Локатор для поля Срок аренды во втором шаге Формы заказа.
    public static By rentalPeriodMenu(){
        return By.xpath(".//div[@class='Dropdown-control']");
    }

    // Локатор для пунктов выпадающего меню поля Срок аренды.
    public static By rentalPeriodOption(int number) {
        return By.xpath(String.format(".//div[@role='option'][%d]", number));
    }

    // Локатор для кнопки "Заказать" во втором шаге Формы заказа.
    public static By finalOrderButton(){
        return By.xpath(".//div[starts-with(@class, 'Order_Buttons')]/button[text()='Заказать']");
    }

    // Локатор для кнопки "Да" в окне подтверждения совершения заказа.
    public static By confirmOrderButton(){
        return By.xpath(".//button[text()='Да']");
    }

    // Локатор для всплывающего окна с информацией об успешном совершении заказа.
    public static By orderConfirmedWindow(){
        return By.xpath(".//div[text()='Заказ оформлен']");
    }

    // Локатор для лого Самоката на главной странице
    public static By scooterLogo(){
        return By.xpath(".//a[starts-with(@class, 'Header_LogoScooter')]");
    }

    // Локатор для лого Яндекса на главной странице
    public static By yandexLogo() {
        return By.xpath(".//a[starts-with(@class, 'Header_LogoYandex')]");
    }

    // Локатор для кнопки "Посмотреть" на странице отслеживания заказа
    public static By orderStatusCheckButton(){
        return By.xpath(".//button[text()='Посмотреть']");
    }

    // Локатор для поля ввода номера заказа на странице отслеживания заказа
    public static By orderTrackNumberInput(){
        return By.xpath(".//input[contains(@class, 'Track_Input')]");
    }

    // Локатор для информации о несуществовании заказа на странице статуса заказа
    public static By notFoundBlock(){
        return By.xpath(".//div[starts-with(@class, 'Track_NotFound')]");
    }

    // Локатор для кнопки принятия кук
    public static By cookieAcceptanceButton(){
        return By.xpath(".//button[starts-with(@class, 'App_CookieButton')]");
    }
}
