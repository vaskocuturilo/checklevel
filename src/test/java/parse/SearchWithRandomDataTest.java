package parse;

import org.testng.annotations.DataProvider;
import ru.yandex.base.BaseWeb;
import ru.yandex.pages.ParseMainPage;
import org.testng.annotations.Test;
import testlink.api.java.client.TestLinkAPIException;


public class SearchWithRandomDataTest extends BaseWeb {

    @DataProvider(name = "providerMethod")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"погода"}, {"лото"}, {"липецк"}};
    }

    @Test(description = "Parse information from main page yandex.ru", dataProvider = "providerMethod")
    public void checkHintFromMainSearchPage(String inputDataForSearch) throws TestLinkAPIException {
        ParseMainPage parseMainPage = new ParseMainPage(getDriver());
        parseMainPage.searchWithData(inputDataForSearch)
                .returnResult(inputDataForSearch)
                .addTestLinkResult(SearchWithRandomDataTest.class.getSimpleName());

    }
}
