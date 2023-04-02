package Practice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotation {

    @BeforeMethod
    public void beforMTD() {
        System.out.println("this is befor MTD");

    }

    @AfterMethod
    public void AfterMTD() {
        System.out.println("I am after MTD");
        System.out.println("-----------------");
    }

    @Test
    public void test1() {
        System.out.println("this the test1");
    }

    @Test
    public void test2() {
        System.out.println("this is the test2");
    }

    @Test
    public void test3() {
        System.out.println("this is the test3");
    }
}
