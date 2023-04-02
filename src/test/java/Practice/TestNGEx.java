package Practice;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGEx {

    public static WebDriver driver;

    @BeforeMethod
    public void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void logInFunctionality() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("Hum@nhrm123");
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));

        Actions actions = new Actions(driver);
        actions.moveToElement(logIn).perform();
        Thread.sleep(2000);
        logIn.click();

    }

    @Test
    public void passwordTextBoxVerification() {
        WebElement password = driver.findElement(By.xpath("//input[@id = 'txtPassword']"));
        Boolean pass = password.isDisplayed();
        System.out.println(pass);
    }

}
