package hw2.ex1;

import hw2.GeneralTests;
import org.testng.annotations.Test;

public class MainPageTests extends GeneralTests {

    @Test
    public void secondTest() {
        System.out.println("2nd Test here");
    }

    //    @Test(dependsOnMethods = {"simpleTest"})
    @Test
    public void thirdTest() {
        System.out.println("3rd Test here");
    }

}
