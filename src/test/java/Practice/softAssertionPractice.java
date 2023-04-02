package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class softAssertionPractice {

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
    public void testCase() {

        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();
//        get the text error message
        WebElement error = driver.findElement(By.xpath("//span[text()='Username cannot be empty']"));
        String actualErr = error.getText();
        // System.out.println(errorMsg);
        String expectedErr = "Username cannot be empty";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualErr, expectedErr);
        boolean display = loginBtn.isDisplayed();
        System.out.println(" The states of display Login is " + display);
        softAssert.assertTrue(display);
        softAssert.assertAll();

    }
}
