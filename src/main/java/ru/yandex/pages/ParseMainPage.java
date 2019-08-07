package ru.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.logging.Logger;


/**
 * Class ParseMainPage.
 */
public class ParseMainPage extends PageObject {

    /**
     * Value LOG.
     */
    private static final Logger LOG = Logger.getLogger(ParseMainPage.class.getName());

    /**
     * Find By.
     */
    @FindBy(id = "text")
    private WebElement searchField;

    /**
     * Find By.
     */
    @FindBy(css = "div[class='popup__content']")
    private List<WebElement> listOfElements;


    /**
     * Instantiates a new Page object.
     *
     * @param driver the driver
     */
    public ParseMainPage(final WebDriver driver) {
        super(driver);
    }

    /**
     * To do search parse main page.
     *
     * @param dataForSearch the data for search
     * @return the parse main page
     */
    public ParseMainPage searchWithData(final String dataForSearch) {
        this.searchField.sendKeys(dataForSearch);

        return this;
    }

    /**
     * Get result.
     *
     * @param data the data
     * @return the result
     */
    public ParseMainPage returnResult(final String data) {
        LOG.info("Information for " + data + " -  " + listOfElements.get(0).getText());
        getDriver().navigate().refresh();
        return this;
    }
}
