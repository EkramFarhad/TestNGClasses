package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviderPractice {
    /* //    Test Scenario:
//    navigate to syntax HRMS
//    login into the webiste using the following credentials and check for correct errors
//    a.username ="Admin"  , password="12345"  ---> Error Message ="Invalid credentials"
//    b.username= "ABCD"   , password ="Hum@nhrm123" -->Error Message ="Invalid credentials"
//    c.username= ""   ,   password ="Hum@nhrm123"   -->Error Message ="Username cannot be empty"
//    d.username= "Admin" ,password= ""  -->Error Message= "Password cannot be empty"*/

    public static WebDriver driver;

    @DataProvider( name = "credentials")
    public Object[][] data(){
        Object[][] loginData = {
                {"Admin","12345","Invalid credential"},
                {"ABC","Hum@nhrm123","Invalid credentials"},
                {"Admin","","Password cannot be empty"},
                {"","Hum@nhrm123","Username cannot be empty"}

        };
        return loginData;
    }


    @Test ()
    public void test1() {
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"txtUsername\"]"));
        userName.sendKeys("Admin");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"txtPassword\"]"));
        password.sendKeys("12345");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();
        WebElement errMessage = driver.findElement(By.xpath("//*[@id='spanMessage']"));
        String theActualMessage = errMessage.getText();
        // System.out.println(theActualMessage);
        String expectedMessage = "Invalid credentials";
        Assert.assertEquals(theActualMessage, expectedMessage);


    }

    @BeforeMethod
    public void browserSetUP() {
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

}
