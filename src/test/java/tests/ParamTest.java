package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {
    @Parameters({"Login - value", "Password - value"})
    @Test
    public void paramTest(String login, String psw){
        System.out.println("Login is: " + login);
        System.out.println("Psw is: " + psw);
    }
}
