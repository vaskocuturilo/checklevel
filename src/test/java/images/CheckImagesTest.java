package images;

import org.testng.annotations.Test;
import ru.yandex.base.BaseWeb;
import ru.yandex.pages.ImagesPage;

public class CheckImagesTest extends BaseWeb {

    @Test(description = "Test for check all images on page yandex.ru/images.")
    public void checkImagesExists() {
        ImagesPage imagesPage = new ImagesPage(getDriver());
        imagesPage.selectImagesTab();


    }
}
