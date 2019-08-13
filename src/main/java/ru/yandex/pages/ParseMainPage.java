package ru.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.yandex.tms.TestLinkService;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;


/**
 * Class ParseMainPage.
 */
@SuppressWarnings({"PMD.LawOfDemeter", "PMD.BeanMembersShouldSerialize", "PMD.GuardLogStatement"})
public class ParseMainPage extends AbstractPageObject {

    /**
     * Value LOG.
     */
    private static final Logger LOG = Logger.getLogger(ParseMainPage.class.getName());


    /**
     * Value for FindBy searchField.
     */
    private static final String FIELD_FOR_SEARCH = "input[id='text']";


    /**
     * Value for FindBy searchField.
     */
    private static final String LIST_OF_ELEMENTS = "div[class='popup__content'] li";

    /**
     * Find By.
     */
    @FindBy(how = How.CSS, using = FIELD_FOR_SEARCH)
    @CacheLookup
    private WebElement searchField;

    /**
     * Find By.
     */
    @FindBy(how = How.CSS, using = LIST_OF_ELEMENTS)
    @CacheLookup
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
        searchField.sendKeys(dataForSearch);

        return this;
    }

    /**
     * Method return result after parse. return only string with "°C".
     *
     * @param data the data.
     * @return the result.
     */
    public TestLinkService returnResult(final String data) {
        for (final WebElement element : listOfElements) {
            LOG.info("Information for " + data + " -  " + Arrays.toString(element.getText().split("[^\\d\\°C]+")));
        }
        getDriver().navigate().refresh();

        return new TestLinkService();
    }
}
