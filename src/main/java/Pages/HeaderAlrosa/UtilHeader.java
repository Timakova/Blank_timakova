package Pages.HeaderAlrosa;

import Utils.Global;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilHeader {
    private WebDriver driver;
    public Global global;

    public UtilHeader(WebDriver driver) {
        this.driver = driver;
        global = new Global(driver);
    }
    /* Элементов главной страницы Алросы */
    private By partnerHeader = By.xpath("//div[contains(@class, 'header-main__top-container--b2c')]/p/a"); //"Юридическим лицам" в хедере
    private By logoRu = By.xpath("//a[contains(@class, 'header-main__logo--b2c')]"); //логотип
    private By inputEn = By.xpath("//input[@id='language_en']/following-sibling::label");
    private By inputRu = By.xpath("//input[@id='language_ru']/following-sibling::label");
    private By inputCn = By.xpath("//input[@id='language_cn']/following-sibling::label");
    private By headMainPage = By.xpath("//h2[contains(@class, 'index-section__title--choose-your')]");
    private By currencyHeader = By.xpath("//span[@id='select2-popup_currency-2-container']"); //показ валюты в хедере
    private By currencyChange = By.xpath("//ul[@id='select2-popup_currency-2-results']/li[2]"); //выбор из списка валют "USD"

    @Step("Нахождение элемента для юридических лиц")
    public void clickPartnersHeader () {
        driver.findElement(partnerHeader).click();
    }

    @Step("Получение текста ссылки")
    public String getTextPartnerHeader () {
        return driver.findElement(partnerHeader).getText();
    }

    @Step("Нахождение элемента - логотип")
    public void clickLogo () {
        driver.findElement(logoRu).click();
    }

    @Step("Переход на англоязычную версию Сайта")
    public void clickEn () {
        driver.findElement(inputEn).click();
    }

    @Step("Переход на русскоязычную версию Сайта")
    public void clickRu () {
        driver.findElement(inputRu).click();
    }

    @Step("Переход на китайскую версию Сайта")
    public void clickCn () {
        driver.findElement(inputCn).click();
    }

    @Step("Получение заголовка на главной странице")
    public String getHeadMainPage() {
        return driver.findElement(headMainPage).getText();
    }

    @Step("Изменение валюты в хедере") //название шага в allure
    public void clickChangeCurrency (int numberCurrency) {
        By changeCurrencyNumber = By.xpath(String.format("//ul[@id='select2-popup_currency-2-results']/li[%d]", numberCurrency));
        driver.findElement(currencyHeader).click();
        driver.findElement(changeCurrencyNumber).click();
    }

    @Step("Получение текста валюты")
    public String getTextCurrency () {
        return driver.findElement(currencyHeader).getText();
    }

    //Ожидание отображения элемента
    @Step("Ожидание отображения элемента")
    public void visibilityOfElementLocated() {
        //Ожидание первого элемента в категории
        WebDriverWait wait = new WebDriverWait(driver, 10);//Указывается время ожидания элемента (время прибавляется к "driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS)")
        wait.until(ExpectedConditions.visibilityOfElementLocated(currencyChange));//Ожидание отображение указанного элемента
    }

}
