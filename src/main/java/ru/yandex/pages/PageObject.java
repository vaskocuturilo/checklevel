package ru.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Class Page object.
 */
public class PageObject {

    /**
     * Private driver.
     */
    private final WebDriver driver;

    /**
     * getter.
     *
     * @return return. driver
     */
    public final WebDriver getDriver() {
        return driver;
    }

    /**
     * Method PageObject.
     *
     * @param webDriver driver.
     */
    public PageObject(final WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

}
