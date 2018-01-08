package Testing.test.java.selen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by Mari on 26.09.2016.
 */
public class TestT {
    //    @Test(dataProvider = "pageObjects")
//    public void testSearch(final SearchPage searchPage) {
//        searchPage.init(driver);
//        driver.get("http://ya.ru");
//        searchPage.search("Bolek i Lolek");
//    }
//
//    @DataProvider
//    private Object[][] pageObjects() {
//        return new Object[][]{
//                {new SimpleSearchPage()},
//                {new AnnotatedSearchPage()},
//                {new ExtendedSearchPage()},
//                {new SearchPageWithSearchForm()}
//        };
//    }
//
//    private WebDriver driver;
//
//    @BeforeClass
//    public void beforeClass() {
//        driver = new FirefoxDriver();
//    }
//
//    @AfterClass
//    public void afterClass() {
//        driver.quit();
//    }
    public static void main(String[] args) {

//            System.setProperty("webdriver.gecko.driver", "C:/Program Files/Mozilla Firefox/geckodriver-v0.8.0-win32/geckodriver.exe");

//Now you can Initialize marionette driver to launch firefox
//            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//            capabilities.setCapability("marionette", true);
//            WebDriver driver = new FirefoxDriver(capabilities);


        System.setProperty("webdriver.chrome.driver","D:\\IdeaProjects\\TestProjectSelenium\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("marionette", true);
        WebDriver driver = new ChromeDriver(capabilities);

        // Открываем Google
        driver.get("http://www.google.com");

        // Находим по имени поле для ввода
        WebElement element = driver.findElement(By.name("q"));

        // Вводим ключевое слово для поиска
        element.sendKeys("гладиолус");

        // Отправляем форму в которой находится элемент element.
        // WebDriver сам найдет, в какой он форме.
        element.submit();
        WebElement searchbut = driver.findElement(By.name("btnG"));//.click();
        searchbut.click();
        System.out.println("Page title is: " + driver.getTitle());
//            searchButton.click();
        element.submit();
        //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch website
        driver.navigate().to("https://www.google.ru/");

        //Maximize the browser
        driver.manage().window().maximize();

        // Click on Math Calculators
//            driver.findElement(By.xpath(".//*[@id='menu']/div[3]/a")).click();

        // Click on Percent Calculators
//            driver.findElement(By.xpath(".//*[@id='menu']/div[4]/div[3]/a")).click();

        // Enter value 10 in the first number of the percent Calculator
        driver.findElement(By.id("cpar1")).sendKeys("10");

        // Enter value 50 in the second number of the percent Calculator
        driver.findElement(By.id("cpar2")).sendKeys("50");

        // Click Calculate Button
        driver.findElement(By.xpath(".//*[@id='content']/table/tbody/tr[2]/td/input[2]")).click();


        // Get the Result Text based on its xpath
        String result = driver.findElement(By.xpath(".//*[@id='content']/p[2]/font/b")).getText();


        // Print a Log In message to the screen
        System.out.println(" The Result is " + result);

        //Close the Browser.
        driver.close();

    }
}

