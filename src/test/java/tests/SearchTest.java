package tests;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class SearchTest extends TestBase {

    @Test
    public void searchTest() {
        app.search().fillSearchForm("Haifa", "11/25/21", "01/30/22");
        app.getUserHelper().submitForm();
       Assert.assertTrue(app.search().isListOfCarsAppeared());

    }
   // @AfterMethod
   // public void post()
   // {
  //      app.search()
  //  }

}
