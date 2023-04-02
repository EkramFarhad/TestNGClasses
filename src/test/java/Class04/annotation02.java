package Class04;

import org.testng.annotations.*;

public class annotation02 {

    @BeforeTest
    public void beforeTest() {
        System.out.println("i am before test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("I am before class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("I am after class");
    }

    @BeforeMethod
    public void before() {
        System.out.println("i am before method");
    }

    @AfterMethod
    public void after() {
        System.out.println("i am after method");
    }

    @Test
    public void TestA() {

    }

    @Test
    public void TestB() {

    }
}
