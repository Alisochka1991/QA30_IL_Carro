package tests;

import jdk.nashorn.internal.runtime.logging.DebugLogger;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.naming.Name;

public class RegistrationTest extends TestBase{
    @Test
    public void registrationPositiveTest()
    {
        int i =(int)  (System.currentTimeMillis()/1000)%3600;

        User user = new User()
                .withName("Alisa")
                .withLastname("Yoyo")
                .withEmail("alisa"+i+"@gmail.com")
                .withPassword("212229Alisa");

        logger.info("Test Registration Positive start with >>>>"+user.getName()+"  &&  "+user.getEmail()+" && "+user.getPassword());
        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm(user);
        app.getUserHelper().submitForm();
        app.getUserHelper().clickPolicy();
        Assert.assertTrue(app.getUserHelper().isRegistered());
    }
}

