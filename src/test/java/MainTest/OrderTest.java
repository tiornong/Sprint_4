package MainTest;


import Constants.Constants;
import PageObject.MainPage;
import PageObject.OrderPage;
import Util.BaseTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final String testBrowser;
    private final boolean isOrderButtonUpper;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final int metroStationIndex;
    private final String deliveryDate;
    private final int rentalPeriod;

    // Параметры и поля разделил по этапам их использования, 1 - для использования на главной странице, 2 - на первом шаге формы заказа, 3 - на втором
    public OrderTest(String testBrowser, boolean isOrderButtonUpper,
                     String name, String surname, String address, String phone, int metroStationIndex,
                     String deliveryDate, int rentalPeriod) {

        this.testBrowser = testBrowser;
        this.isOrderButtonUpper = isOrderButtonUpper;

        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.metroStationIndex = metroStationIndex;

        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
    }

    @Parameterized.Parameters(name = "Браузер - {0}, верхняя кнопка заказа - {1}")
    public static Object[][] orderTestData () {
        return new Object[][] {
                {"Chrome", false, "Иван", "Иванов", "Иваново", "+78005553535", 132, "11.12.2025", 3},
                {"Firefox", true, "Тарас", "Бульба", "Беларусь", "+78477123085", 123, "12.11.2026", 4},
                {"Chrome", false, "Иван", "Иванов", "Иваново", "+78005553535", 132, "11.12.2025", 3},
                {"Firefox", true, "Тарас", "Бульба", "Беларусь", "+78477123085", 123, "12.11.2026", 4},
        };
    }

    @Test
    public void makeOrderTest(){
        driver = getDriver(testBrowser, Constants.TEST_URL_MAIN);
        MainPage mainPage = new MainPage(driver);
        mainPage.cookieAcceptanceButtonClick();

        if (isOrderButtonUpper){
            mainPage.upperOrderButtonClick();
        } else {
            mainPage.lowerOrderButtonClick();
        }
        OrderPage orderPage = new OrderPage(driver);

        // Первый шаг Формы заказа
        orderPage.nameInput(name);
        orderPage.surnameInput(surname);
        orderPage.addressInput(address);
        orderPage.metroStationInput(metroStationIndex);
        orderPage.phoneInput(phone);
        orderPage.nextButtonFirstOrderFormClick();

        // Второй шаг Формы заказа
        orderPage.orderDateInput(deliveryDate);
        orderPage.rentalPeriodMenuClick();
        orderPage.rentalOptionInput(rentalPeriod);
        orderPage.finalOrderButtonClick();
        orderPage.confirmOrderButtonClick();

        Assert.assertTrue(orderPage.orderConfirmedWindowCheck());
    }

}
