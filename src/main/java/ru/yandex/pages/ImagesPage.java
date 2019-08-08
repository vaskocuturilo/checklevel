package ru.yandex.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;
import java.util.logging.Logger;

/**
 * The type Images page.
 */
@SuppressWarnings({"PMD.LawOfDemeter", "PMD.BeanMembersShouldSerialize", "PMD.GuardLogStatement"})
public class ImagesPage extends PageObject {
    /**
     * Value IMAGES.
     */
    private static final String IMAGES = "a[data-id='images']";

    /**
     * Value LIST_OF_IMAGES.
     */

    private static final String LIST_OF_IMAGES = "div[id='main'] [style*='padding-top'] a";

    /**
     * Value LOG.
     */
    private static final Logger LOG = Logger.getLogger(ParseMainPage.class.getName());

    /**
     * Find By.
     */
    @FindBy(how = How.CSS, using = IMAGES)
    @CacheLookup
    private WebElement imagesTab;

    /**
     * Find By.
     */
    @FindBy(how = How.CSS, using = LIST_OF_IMAGES)
    @CacheLookup
    private List<WebElement> listOfImages;

    /**
     * Method PageObject.
     *
     * @param webDriver driver.
     */
    public ImagesPage(final WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Method selectImagesTab.
     *
     * @return this.
     */
    public ImagesPage selectImagesTab() {
        this.imagesTab.click();

        verifyImagesLinks();

        return this;
    }

    /**
     * Method verifyImagesLinks.
     */

    private void verifyImagesLinks() {
        for (final WebElement image : listOfImages) {
            isImageBroken(image);
        }
    }

    /**
     * Method isImageBroken.
     *
     * @param listOfImages lis of tests.parse.images.
     */
    private void isImageBroken(final WebElement listOfImages) {
        if (listOfImages.getAttribute("href").equals("0")) {
            LOG.info(listOfImages.getAttribute("outerHTML") + " is broken.");
        }
    }
}

