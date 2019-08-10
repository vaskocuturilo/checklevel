package ru.yandex.base;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import ru.yandex.utils.PropertiesReader;

import java.util.concurrent.TimeUnit;

/**
 * Class Base web.
 */
@SuppressWarnings({"PMD.LawOfDemeter", "PMD.BeanMembersShouldSerialize"})
public class BaseWeb {

    /**
     * Value threadLocal.
     */
    private final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

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
     * @param browser different browser.
     * @throws Exception the exception
     */
    @Parameters({"browser"})
    @BeforeTest()
    public void start(@Optional("chrome") final String browser) {

        if (threadLocal.get() != null) {
            driver = threadLocal.get();
            return;
        }
        if ("chrome".equals(browser)) {
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            ChromeDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            driver = new FirefoxDriver();
        } else {
            throw new IllegalStateException(" Browser " + browser + " not supported in this tests. ");
        }

        driver.get(PropertiesReader.loadProperty("URL"));

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
