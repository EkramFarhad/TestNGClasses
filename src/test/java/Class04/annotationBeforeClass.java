package Class04;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class annotationBeforeClass {
    @BeforeClass
    public void Hello(){
        System.out.println("I am before class");
    }
    @Test
    public void testB(){
        System.out.println("I am testB");
    }
}
