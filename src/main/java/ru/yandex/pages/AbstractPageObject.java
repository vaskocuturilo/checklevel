package ru.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Class AbstractPageObject.
 */
public abstract class AbstractPageObject {

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
     * Method AbstractPageObject.
     *
     * @param webDriver driver.
     */
    public AbstractPageObject(final WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    /**
     * Method checkTitle.
     *
     * @return title.
     */
    public String checkTitle() {

        return driver.getTitle();
    }

    /**
     * Abstract method abstractPageObject.
     */
    public abstract void abstractPageObject();

}
