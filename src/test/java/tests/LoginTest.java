package tests;

import manager.MyDataProvider;

import models.User;
import org.testng.Assert;
import org.testng.annotations.*;


//@Listeners(NgListener.class)

public class LoginTest extends TestBase{
    @BeforeMethod
    public void precondition()
    {
        if(!app.getUserHelper().isloginPresent())//esli NET knopki LOGIN to ya zaloginena i nado razloginitsa
        {
       app.getUserHelper().logout();
        }
    }


    @Test(dataProvider = "loginModelDto", dataProviderClass = MyDataProvider.class)
    public void loginSuccess(User user)
    {
       // User user = new User().withEmail("alisiaagranov@gmail.com").withPassword("212229Alisa");
   logger.info("With user ---->"+user.toString());
     app.getUserHelper().openLoginForm();
   //  app.getUserHelper().fillLoginForm("alisiaagranov@gmail.com","212229Alisa");
     app.getUserHelper().fillLoginForm(user);
     app.getUserHelper().submitForm();
    Assert.assertTrue(app.getUserHelper().isLoggedSuccess());
    }



    @Test(dataProvider = "loginDto", dataProviderClass = MyDataProvider.class)
    public void loginSuccess2WithSTR(String email, String password)
    {
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(email,password);
        app.getUserHelper().submitForm();
        Assert.assertTrue(app.getUserHelper().isLoggedSuccess());
    }
    @AfterMethod
public void postcondition()
    {
        app.getUserHelper().clickOkButton();
    }
}

