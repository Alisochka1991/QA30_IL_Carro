package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{
    @Test
    public void registrationPositiveTest()
    {
        int i =(int)  (System.currentTimeMillis()/1000)%3600;

        User user = new User().withName("Alisa").withLastname("Yoyo").withEmail("alisa"+i+"@gmail.com").withPassword("212229Alisa");
        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().submitForm();
        Assert.assertTrue(app.getUserHelper().isRegistered());
    }

    @Test
    public void registrationNegativeTest()
    {
        int i =(int)  (System.currentTimeMillis()/1000)%3600;

        User user = new User().withName("Alisa").withLastname("Yoyo").withEmail("alisa"+i+"@gmail.com").withPassword("212229Alisa");
        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().submitForm();
        app.getUserHelper().pause(10000);
       // Assert.assertTrue(app.getUserHelper().isRegistered());
    }
}