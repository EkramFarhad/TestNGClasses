package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Assertion {

    public static WebDriver driver;

    @BeforeMethod
    public static void setUpBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public static void endBrowser() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    //    testcase
//    enter the username :Admin
//    enter the password :abracadbara
//    click login button
//    verify that the message invalid credentials is displayed
//    verify that password text box is displayed

    @Test
    public void logInFunctionality() {
        driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
        WebElement pass = driver.findElement(By.xpath("//*[@id='txtPassword']"));
        pass.sendKeys("Hum@nhrm1233");
        WebElement logIn = driver.findElement(By.xpath("//*[@id='btnLogin']"));
        logIn.click();
        WebElement error = driver.findElement(By.xpath("//span[@id='spanMessage']"));

        String errorMsg = error.getText();
        String expectedErr = "Invalid credentials";

        //you can do this way too
        // Assert.assertEquals(errorMsg, "Invalid credentials");
        Assert.assertEquals(errorMsg, expectedErr);
        System.out.println("hello just cheking");


        pass = driver.findElement(By.xpath("//*[@id='txtPassword']"));
        boolean passwordDisplay = pass.isDisplayed();
        Assert.assertTrue(passwordDisplay);


    }

}