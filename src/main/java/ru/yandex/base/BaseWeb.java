package ru.yandex.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ru.yandex.utils.PropertiesReader;

import java.util.concurrent.TimeUnit;


/**
 * Class Base web.
 */
public class BaseWeb {

    /**
     * Value threadLocal.
     */
    private final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();
    /**
     * Constant DELAY.
     */
    private static final int DELAY = 10;
    /**
     * driver.
     */
    private WebDriver driver;

    /**
     * getter.
     *
     * @return return driver.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Default constructor.
     */
    public BaseWeb() {
        super();
        //empty
        return;
    }

    /**
     * Method Start.
     *
     * @throws Exception the exception
     */
    @BeforeTest
    public void start() {
        if (threadLocal.get() != null) {
            driver = threadLocal.get();
            return;
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(PropertiesReader.loadProperty("URL"));
        driver.manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS);
        threadLocal.set(driver);
    }

    /**
     * Method Stop.
     */
    @AfterTest
    public void stop() {
        if (driver != null) {
            driver.close();
        }
    }
}
