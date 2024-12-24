package AdditionalTest;


import Constants.Constants;
import PageObject.OrderPage;
import Util.BaseTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import org.assertj.core.api.SoftAssertions;


@RunWith(Parameterized.class)
public class OrderInputTest extends BaseTest {

    private final String testBrowser;

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;

    public OrderInputTest(String browser, String name, String surname, String address, String phone) {
        this.testBrowser = browser;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    @Parameterized.Parameters(name = "Браузер - {0}")
    public static Object[][] orderTestData () {
        return new Object[][] {
                {"Chrome", "Ivan", "Ivanov", "Ivanovo", "Ivanova"},
                {"Firefox", "Ivan", "Ivanov", "Ivanovo", "Ivanova"},
        };
    }

    @Test
    public void OrderDataInputErrorMessagesTest() {
        driver = getDriver(testBrowser, Constants.TEST_URL_ORDER);
        OrderPage orderPage = new OrderPage(driver);

        orderPage.nameInput(name);
        orderPage.surnameInput(surname);
        orderPage.addressInput(address);
        orderPage.phoneInput(phone);

        // Софтассерты используются для того, что бы весь тест не упал из-за единственной ошибки
        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(orderPage.nameInputErrorMessageCheck()).isTrue();
        softly.assertThat(orderPage.surnameInputErrorMessageCheck()).isTrue();
        softly.assertThat(orderPage.addressInputErrorMessageCheck()).isTrue();
        softly.assertThat(orderPage.phoneInputErrorMessageCheck()).isTrue();

        softly.assertAll();
    }

}
