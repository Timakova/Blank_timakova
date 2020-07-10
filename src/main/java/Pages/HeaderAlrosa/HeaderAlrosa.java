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
    @Step("Проверка хедера")
    public void сlickHeaderB2C() {
        utils.clickPartnersHeader(); //кликабельность "Юридическим лицам" в хедере
        utils.clickLogo(); //
//        for (int numberCurrency = 1; numberCurrency <= 22; numberCurrency ++) {
//            utils.clickChangeCurrency(numberCurrency); //перебираем кликабельность всех валют
//            utils.visibilityOfElementLocated();
//        }
    }

    @Step("Получение текста Партнерам в хедере")
    public String getTextPartnerHeader () {
        return utils.getTextPartnerHeader();
    }

    @Step("Получение валюты в хедере")
    public String getTextCurrency () {
        return utils.getTextCurrency();
    }

}
