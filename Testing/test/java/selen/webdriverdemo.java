package Testing.test.java.selen;

/**
 * Created by Mari on 26.02.2017.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class webdriverdemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability("marionette", true);
        WebDriver driver = new ChromeDriver();

//        WebDriver driver = new FirefoxDriver();
        // Puts a Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Launch website
//        driver.navigate().to("http://www.calculator.net/percent-calculator.html");
//
//        // Maximize the browser
//        driver.manage().window().maximize();
//
//        // Enter value 10 in the first number of the percent Calculator
//        driver.findElement(By.id("cpar1")).sendKeys("10");
//
//        Thread.sleep(5000);
//
//        // Get the text box from the application
//        String result = driver.findElement(By.id("cpar1")).getAttribute("value");
//
//        // Print a Log In message to the screen
//        System.out.println(" The Result is " + result);


//                //Launch website
//                driver.navigate().to("http://www.calculator.net/mortgage-payoff-calculator.html");
//                driver.manage().window().maximize();
//
//                // Click on Radio Button
//                driver.findElement(By.id("cpayoff1")).click();
//                System.out.println("The Output of the IsSelected " + driver.findElement(By.id("cpayoff1")).isSelected());
//                System.out.println("The Output of the IsEnabled " + driver.findElement(By.id("cpayoff1")).isEnabled());
//                System.out.println("The Output of the IsDisplayed " + driver.findElement(By.id("cpayoff1")).isDisplayed());
        driver.navigate().to("http://www.calculator.net");
        java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Number of Links in the Page is " + links.size());

        for (int i = 1; i<=links.size(); i=i+1) {
            System.out.println("Name of Link# " + i + links.get(i).getText());
        }
        // Close the Browser.
        driver.close();
    }
}