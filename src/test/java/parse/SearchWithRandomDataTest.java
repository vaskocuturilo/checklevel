package parse;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import ru.yandex.base.BaseWeb;
import ru.yandex.pages.ParseMainPage;
import org.testng.annotations.Test;


public class SearchWithRandomDataTest extends BaseWeb {

    private static final String TITLE = "Яндекс";

    @DataProvider(name = "providerMethod")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"погода"}, {"лото"}, {"липецк"}};
    }

    @Test(description = "Parse information from main page yandex.ru", dataProvider = "providerMethod")
    public void checkHintFromMainSearchPage(String inputDataForSearch) {
        ParseMainPage parseMainPage = new ParseMainPage(getDriver());
        Assert.assertEquals(parseMainPage.checkTitle(), TITLE);
        parseMainPage.searchWithData(inputDataForSearch);
        parseMainPage.returnResult(inputDataForSearch);
    }
}
