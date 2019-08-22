package ru.yandex.tms;

import ru.yandex.pages.ParseMainPage;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

import java.util.logging.Logger;

import static ru.yandex.utils.PropertiesReader.loadProperty;


/**
 * The type Test link.
 */
public class TestLinkService {

    /**
     * Constant LOG.
     */
    private static final Logger LOG = Logger.getLogger(ParseMainPage.class.getName());

    /**
     * Constant PROJECT_NAME.
     */
    private static final String PROJECT_NAME = "Project test";

    /**
     * Constant TEST_PLANE_NAME.
     */
    private static final String TEST_PLANE_NAME = "Test plan";

    /**
     * Constant BUILD_NAME.
     */
    private static final String BUILD_NAME = "Test build name";

    /**
     * Constant TEST_NOTE.
     */
    private static final String TEST_NOTE = "Test note";

    /**
     * Default constructor.
     */
    public TestLinkService() {
        super();
        //empty
        return;
    }

    /**
     * Method Add test link result.
     *
     * @param testCase the test case.
     */
    public static void addTestLinkResult(final String testCase) {

        final TestLinkAPIClient testLinkAPIClient = new TestLinkAPIClient(
                loadProperty("API_KEY"), loadProperty("TEST_LINK_URL"));
        try {
            testLinkAPIClient.reportTestCaseResult(PROJECT_NAME,
                    TEST_PLANE_NAME,
                    testCase,
                    BUILD_NAME,
                    TEST_NOTE,
                    TestLinkAPIResults.TEST_PASSED);
        } catch (TestLinkAPIException e) {
            LOG.info(testCase + " is Failed");
        }
    }
}
