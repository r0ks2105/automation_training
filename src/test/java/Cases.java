import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Cases extends BaseTest {

    @Test
    public void login(){
        Login login = new Login(driverThreadSafe.get());
        login.signIn();
        Assert.assertEquals(login.pageTitle(), "MY ACCOUNT");
    }
}
