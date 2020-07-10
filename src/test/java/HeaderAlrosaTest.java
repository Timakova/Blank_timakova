import Pages.HeaderAlrosa.HeaderAlrosa;
import Pages.PartnersAlrosa.PartnersAlrosa;
import Utils.Browser;
import Utils.Global;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.*;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;

@DisplayName("Хедер")
public class HeaderAlrosaTest {

    private static WebDriver driver;
    private HeaderAlrosa headerAlrosa;
    private PartnersAlrosa partnersAlrosa;
    public Global global;

    //Действия перед всеми тест-кейсами
    @BeforeClass
    public static void setUp() {
        driver = new Browser(driver).Chrome();
        driver.manage().window().setSize(new Dimension(1920, 1080)); //Размеры окна браузера
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //Время ожидания действия сценария
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); //Время ожидания загрузки страницы
        driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS); //Время ожидания действия скриптов на странице
    }

    //Действия перед каждым тест-кейсом
    @Before
    public void setUpTwo() {
        driver.get("https://diamonds.alrosa.ru/"); //Открыть в браузере url "https://dostavka.auchan.ru/"
        driver.manage().deleteAllCookies(); //Удалить все куки
        driver.navigate().refresh(); //Обновить страницу
        headerAlrosa = new HeaderAlrosa(driver); //Используемые классы в данном тест-сценарии
        partnersAlrosa = new PartnersAlrosa(driver);
        global = new Global(driver); //Используемые классы в данном тест-сценарии
    }

    //Стандартная функция для того, чтобы делать скриншоты в allure, после каждого сломанного тест-кейса делать скриншот
    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure();
        }
        @Attachment("Скриншот")
        public byte[] makeScreenshotOnFailure() {
            try {
                return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            } catch (WebDriverException e) {
                e.printStackTrace();
            }
            return new byte[0];
        }
    };

    //Тесты
    @Test
    @Link(name = "Ссылка на страницу", url = "https://diamonds.alrosa.ru/") //Добавление в allure ссылки на нужную страницу
    @Severity(SeverityLevel.MINOR) //Критичность тест-сценария для отображении в allure (BLOCKER, CRITICAL,MINOR, NORMAL, TRIVIAL)
    @DisplayName("Проверка хедера en") //Название тест-сценария в allure
    @Owner(value = "Тимакова Т.В.") //Инициалы того, кто написал тест-сценарий
    public void HeaderAlrosaEnTest() {
        headerAlrosa.сlickHeaderEn();
        String textPartnerHeader = headerAlrosa.getTextPartnerHeader();
        Assert.assertEquals("FOR CORPORATE CLIENTS", textPartnerHeader);
        String headMain = headerAlrosa.getHeadMainPage();
        Assert.assertEquals("CHOOSE YOUR DIAMOND'S", headMain);
    }

    @Test
    @Link(name = "Ссылка на страницу", url = "https://diamonds.alrosa.ru/") //Добавление в allure ссылки на нужную страницу
    @Severity(SeverityLevel.MINOR) //Критичность тест-сценария для отображении в allure (BLOCKER, CRITICAL,MINOR, NORMAL, TRIVIAL)
    @DisplayName("Проверка хедера ru") //Название тест-сценария в allure
    @Owner(value = "Тимакова Т.В.") //Инициалы того, кто написал тест-сценарий
    public void HeaderAlrosaRuTest() {
        headerAlrosa.сlickHeaderRu();
        String textPartnerHeader = headerAlrosa.getTextPartnerHeader();
        Assert.assertEquals("ЮРИДИЧЕСКИМ ЛИЦАМ", textPartnerHeader);
        String headMain = headerAlrosa.getHeadMainPage();
        Assert.assertEquals("ВЫБЕРИТЕ ВАШ БРИЛЛИАНТ", headMain);
    }

    @Test
    @Link(name = "Кликните, чтобы перейти на страницу", url = "https://diamonds.alrosa.ru/") //Добавление в allure ссылки на нужную страницу
    @Severity(SeverityLevel.MINOR) //Критичность тест-сценария для отображении в allure (BLOCKER, CRITICAL,MINOR, NORMAL, TRIVIAL)
    @DisplayName("Проверка хедера cn") //Название тест-сценария в allure
    @Owner(value = "Тимакова Т.В.") //Инициалы того, кто написал тест-сценарий
    public void HeaderAlrosaCnTest() {
        headerAlrosa.clickHeaderCn();
        String textPartnerHeader = headerAlrosa.getTextPartnerHeader();
        Assert.assertEquals("法人信息", textPartnerHeader);
        String headMain = headerAlrosa.getHeadMainPage();
        Assert.assertEquals("选择你的钻石", headMain);
    }

    //действия, которые должны выполняться в конце всех тест-сценариев
    @AfterClass
    public static void tearDownClass() {
        driver.quit();//Завершить работу драйвера, т.е. закрытие полностью браузера
    }
}
