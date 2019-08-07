package tests;

import org.testng.annotations.DataProvider;
import ru.yandex.base.BaseWeb;
import ru.yandex.pages.ParseMainPage;

public class SearchWithRandomDataTest extends BaseWeb {

    @DataProvider(name = "providerMethod")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"Погода"}, {"Болото"}, {"Липецк"}};
    }

    @org.testng.annotations.Test(description = "Parse information for main page yandex.ru", dataProvider = "providerMethod")
    public void checkHintFromMainSearchPage(String inputDataForSearch) {
        ParseMainPage parseMainPage = new ParseMainPage(getDriver());
        parseMainPage.searchWithData(inputDataForSearch);
        parseMainPage.returnResult(inputDataForSearch);
    }
}
