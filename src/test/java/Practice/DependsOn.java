package Practice;

import org.testng.annotations.Test;

public class DependsOn {

    @Test
    public void depend() {
        System.out.println("This class is depend on the other one");
    }

    @Test (dependsOnMethods = {"depend"})
    public void iAmDepended() {
        System.out.println(" I am depended to above");
    }
}
