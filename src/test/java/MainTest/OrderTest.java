package MainTest;


import Constants.Constants;
import PageObject.MainPage;
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
public class OrderTest {
    private WebDriver driver;

    private final boolean isOrderButtonUpper;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final int metroStationIndex;
    private final String deliveryDate;
    private final int rentalPeriod;

    public OrderTest(boolean isOrderButtonUpper, String name, String surname, String address, String phone, int metroStationIndex,  String deliveryDate, int rentalPeriod) {
        this.isOrderButtonUpper = isOrderButtonUpper;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.metroStationIndex = metroStationIndex;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
    }

    @Parameterized.Parameters
    public static Object[][] orderTestData () {
        return new Object[][] {
                {false, "Иван", "Иванов", "Иваново", "+78005553535", 132, "11.12.2025", 3},
                {true, "Тарас", "Бульба", "Беларусь", "+78477123085", 123, "12.11.2026", 4}
        };
    }

    @Test
    public void OrderTestChrome(){
        driver = new ChromeDriver();
        driver.get(Constants.TEST_URL_MAIN);
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        mainPage.cookieAcceptanceButtonClick();

        if (isOrderButtonUpper){
            mainPage.upperOrderButtonClick();
        } else {
            mainPage.lowerOrderButtonClick();
        }
        OrderPage orderPage = new OrderPage(driver);

        orderPage.nameInput(name);
        orderPage.surnameInput(surname);
        orderPage.addressInput(address);
        orderPage.metroStationInput(metroStationIndex);
        orderPage.phoneInput(phone);
        orderPage.nextButtonFirstOrderFormClick();
        orderPage.orderDateInput(deliveryDate);
        orderPage.rentalPeriodMenuClick();
        orderPage.rentalOptionInput(rentalPeriod);
        orderPage.finalOrderButtonClick();
        orderPage.confirmOrderButtonClick();

        Assert.assertTrue(orderPage.orderConfirmedWindowCheck());
    }

    @Test
    public void OrderTestFirefox(){
        driver = new FirefoxDriver();
        driver.get(Constants.TEST_URL_MAIN);
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage(driver);
        mainPage.cookieAcceptanceButtonClick();

        if (isOrderButtonUpper){
            mainPage.upperOrderButtonClick();
        } else {
            mainPage.lowerOrderButtonClick();
        }
        OrderPage orderPage = new OrderPage(driver);

        orderPage.nameInput(name);
        orderPage.surnameInput(surname);
        orderPage.addressInput(address);
        orderPage.metroStationInput(metroStationIndex);
        orderPage.phoneInput(phone);
        orderPage.nextButtonFirstOrderFormClick();

        orderPage.orderDateInput(deliveryDate);
        orderPage.rentalPeriodMenuClick();

        orderPage.rentalOptionInput(rentalPeriod);
        orderPage.finalOrderButtonClick();
        orderPage.confirmOrderButtonClick();

        Assert.assertTrue(orderPage.orderConfirmedWindowCheck());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
