package ru.yandex.pages;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.tms.TestLinkService;

import java.util.List;
import java.util.logging.Logger;

import static org.testng.Assert.assertEquals;

/**
 * The type Images page.
 */
@SuppressWarnings({"PMD.LawOfDemeter", "PMD.BeanMembersShouldSerialize", "PMD.GuardLogStatement"})
public class ImagesPage extends AbstractPageObject {

    /**
     * CONSTANT DELAY.
     */
    private static final int DELAY = 10;

    /**
     * Value IMAGES.
     */
    private static final String IMAGES = "a[data-id='images']";

    /**
     * Value LIST_OF_IMAGES.
     */
    private static final String LIST_OF_IMAGES = "div[id='main'] [style*='padding-top'] a";

    /**
     * Value VOICE_BUTTON.
     */
    private static final String VOICE_BUTTON = "form[data-lego='react'] span[class*='icon icon_type_voice']";

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
     * Method AbstractPageObject.
     *
     * @param webDriver driver.
     */
    public ImagesPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public void abstractPageObject() {
    }

    /**
     * Method selectImagesTab.
     *
     * @return this.
     */
    public TestLinkService selectImagesTab() {

        imagesTab.click();

        final WebElement voiceElement = (new WebDriverWait(getDriver(), DELAY))
                .until(new ExpectedCondition<WebElement>() {
                    @NullableDecl
                    @Override
                    public WebElement apply(@NullableDecl final WebDriver webDriver) {
                        return webDriver.findElement(By.cssSelector(VOICE_BUTTON));
                    }
                });

        voiceElement.isEnabled();

        verifyImagesLinks();

        return new TestLinkService();
    }

    /**
     * Method checkThatPageIsCompletelyLoaded.
     *
     * @return this.
     */
    public ImagesPage checkThatPageIsCompletelyLoaded() {
        final JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        assertEquals("complete", executor.executeScript("return document.readyState"));
        return this;
    }

    /**
     * Method verifyImagesLinks.
     */

    private void verifyImagesLinks() {
        for (final WebElement image : listOfImages) {
            isImagesBroken(image);
        }
    }

    /**
     * Method isImagesBroken.
     *
     * @param listOfImages lis of tests.parse.images.
     */
    private void isImagesBroken(final WebElement listOfImages) {
        if (listOfImages.getAttribute("href").equals("0")) {
            LOG.info(listOfImages.getAttribute("outerHTML") + " is broken.");
        }
    }
}

