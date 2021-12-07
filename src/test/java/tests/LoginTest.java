package tests;

import manager.MyDataProvider;
import manager.NgListener;
import models.User;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Listeners(NgListener.class)

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
       // Assert.assertTrue(app.getUserHelper().isLoggedSuccess());
    }


    @DataProvider
public Iterator<Object[]> loginDto()
{
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[]{"alisiaagranov@gmail.com","212229Alisa"});
    list.add(new Object[]{"alisiaagranov@gmail.com","212229Alisa"});
    list.add(new Object[]{"alisiaagranov@gmail.com","212229Alisa"});

    return list.iterator();

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

