package Class01;

import org.testng.annotations.Test;

public class dependsOn {
    @Test
    public void login() {
       // System.out.println("I am here");
        System.out.println(6/0);
    }

    @Test(dependsOnMethods = {"login"})
    public void DashBoardverfification() {
        System.out.println("after login i am verifying dashboard");
    }
}
