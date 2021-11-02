package tests;

import manager.CarHelper;
import models.Car;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase {
    @BeforeMethod
    public void precondition()
    {
        if(app.getUserHelper().islogInPresent()){
            app.getUserHelper().login(new User().withEmail("alisiaagranov@gmail.com").withPassword("212229Alisa"));
        }

    }
    @Test
    public void addNewCarPositive()
    {
    int i = (int)((System.currentTimeMillis()/1000)%3600);
    Car car = Car.builder()
            .address("Tel Aviv")
            .model("m5")
            .make("BMW")
            .year("2020")
            .engine("2.3")
            .fuel("Petrol")
            .gear("MT")
            .wD("AWD")
            .doors("4")
            .seats("5")
            .calsS("C")
            .fuelConsumption("6.5")
            .carRegNumber("100-55-"+i)
            .price("55")
            .distanceIncluded("5500")
            .typeFeature("type of")
            .about("Very nice car")
            .build();

    app.getCar().openCarForm();
    app.getCar().fillNewCar(car);
    app.getCar().attachPhoto();
    //app.getUserHelper().pause(1000);
    app.getCar().submitForm2();
    }

}
