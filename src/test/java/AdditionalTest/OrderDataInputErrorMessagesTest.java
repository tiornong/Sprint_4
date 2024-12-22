package AdditionalTest;

import Constants.Constants;
import PageObject.OrderPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class OrderDataInputErrorMessagesTest {
    private WebDriver driver;

    private final String name;
    private final String surname;
    private final String address;
    private final String phone;

    public OrderDataInputErrorMessagesTest(String name, String surname, String address, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
    }

    // Хоть СЕЙЧАС параметризация не очень нужна, однако, будь доступ к требованиям валидации полей, сюда можно было бы запихать все негативные кейсы
    @Parameterized.Parameters
    public static Object[][] orderTestData () {
        return new Object[][] {
                {"Ivan", "Ivanov", "Ivanovo", "Ivanova"},
        };
    }

    @Test
    public void OrderDataInputErrorMessagesTestFirefox() {
        driver = new FirefoxDriver();
        driver.get(Constants.TEST_URL_ORDER);
        driver.manage().window().maximize();
        OrderPage orderPage = new OrderPage(driver);

        orderPage.nameInput(name);
        orderPage.surnameInput(surname);
        orderPage.addressInput(address);
        orderPage.phoneInput(phone);

        Assert.assertTrue(orderPage.nameInputErrorMessageCheck());
        Assert.assertTrue(orderPage.surnameInputErrorMessageCheck());
        Assert.assertTrue(orderPage.addressInputErrorMessageCheck());
        Assert.assertTrue(orderPage.phoneInputErrorMessageCheck());

    }

    @Test
    public void OrderDataInputErrorMessagesTestChrome() {
        driver = new ChromeDriver();
        driver.get(Constants.TEST_URL_ORDER);
        driver.manage().window().maximize();
        OrderPage orderPage = new OrderPage(driver);

        orderPage.nameInput(name);
        orderPage.surnameInput(surname);
        orderPage.addressInput(address);
        orderPage.phoneInput(phone);

        Assert.assertTrue(orderPage.nameInputErrorMessageCheck());
        Assert.assertTrue(orderPage.surnameInputErrorMessageCheck());
        Assert.assertTrue(orderPage.addressInputErrorMessageCheck());
        Assert.assertTrue(orderPage.phoneInputErrorMessageCheck());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
