package Pages.HeaderAlrosa;
import Pages.PartnersAlrosa.PartnersAlrosa;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class HeaderAlrosa {
    private WebDriver driver;
    private Pages.HeaderAlrosa.UtilHeader utils;

    //инициализируем драйвер и страницу
    public HeaderAlrosa(WebDriver driver) {
        this.driver = driver;
        utils = new Pages.HeaderAlrosa.UtilHeader(driver);
    }

    //собираем методы

    @Step("Проверка перехода на Юридическим лицам и логотип, en")
    public void сlickHeaderEn() {
        utils.clickEn();
        utils.clickPartnersHeader(); //кликабельность "Юридическим лицам" в хедере
        utils.clickLogo(); //кликабельность лого
    }

    @Step("Проверка перехода на Юридическим лицам и логотип, ru")
    public void сlickHeaderRu() {
        utils.clickRu();
        utils.clickPartnersHeader(); //кликабельность "Юридическим лицам" в хедере
        utils.clickLogo(); //кликабельность лого
//        for (int numberCurrency = 1; numberCurrency <= 22; numberCurrency ++) {
//            utils.clickChangeCurrency(numberCurrency); //перебираем кликабельность всех валют
//            utils.visibilityOfElementLocated();
//        }
    }

    @Step("Проверка перехода на Юридическим лицам и логотип, cn")
    public void clickHeaderCn() {
        utils.clickCn();
        utils.clickPartnersHeader();
        utils.clickLogo();
    }

    @Step("Получение текста Партнерам в хедере")
    public String getTextPartnerHeader () {
        return utils.getTextPartnerHeader();
    }

    @Step("Получение заголовка на главной странице")
    public String getHeadMainPage () {
        return utils.getHeadMainPage();
    }

    @Step("Получение валюты в хедере")
    public String getTextCurrency () {
        return utils.getTextCurrency();
    }

}
