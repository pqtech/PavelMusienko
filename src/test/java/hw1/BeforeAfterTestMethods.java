package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BeforeAfterTestMethods {
    Calculator calculator;

    @BeforeClass
    public void before() {
        //        System.out.println("Before Class Method");
        calculator = new Calculator();
    }

    @AfterClass
    public void after() {
        //        System.out.println("After Class Method");
        calculator = null;
    }
}
