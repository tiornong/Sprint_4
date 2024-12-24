package Util;


import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/** Класс-предок для всех прочих тестов */
public class BaseTest {

    protected WebDriver driver;

    /** Метод для получения настроенного вебдрайвера*/
    public WebDriver getDriver(String browser, String link) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get(link);
        return driver;
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
