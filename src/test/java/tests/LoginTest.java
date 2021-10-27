package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest extends TestBase{
    @BeforeMethod
    public void precondition()
    {
        if(!app.getUserHelper().islogInPresent())//esli NET knopki LOGIN to ya zaloginena i nado razloginitsa
        {
       app.getUserHelper().logout();
        }
    }


    @Test
    public void loginSuccess()
    {
        User user = new User().withEmail("alisiaagranov@gmail.com").withPassword("212229Alisa");

     app.getUserHelper().openLoginForm();
   //  app.getUserHelper().fillLoginForm("alisiaagranov@gmail.com","212229Alisa");
     app.getUserHelper().fillLoginForm(user);
     app.getUserHelper().submitForm();
        Assert.assertTrue(app.getUserHelper().isLoggedSuccess());
    }


    @Test
    public void loginSuccess2()
    {
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("alisiaagranov@gmail.com","212229Alisa");
        app.getUserHelper().submitForm();
        Assert.assertTrue(app.getUserHelper().isLoggedSuccess());
    }
    @AfterMethod
public void postcondition()
    {
        app.getUserHelper().clickOkButton();
    }
}

