package ru.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


/**
 * Class ParseMainPage.
 */
@SuppressWarnings({"PMD.LawOfDemeter", "PMD.BeanMembersShouldSerialize", "PMD.GuardLogStatement"})
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
    @FindBy(css = "div[class='popup__content'] li")
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
     * Return result.
     *
     * @param data the data.
     * @return the result.
     */
    public ParseMainPage returnResult(final String data) {
        for (final WebElement element : listOfElements) {
            LOG.info("Information for " + data + " -  " + Arrays.toString(element.getText().split("\\d+\\°C")));
        }
        getDriver().navigate().refresh();

        return this;
    }
}
