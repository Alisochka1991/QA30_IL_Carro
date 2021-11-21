package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object[]> loginDto()
    {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"alisiaagranov@gmail.com","212229Alisa"});
        list.add(new Object[]{"alisiaagranov@gmail.com","212229Alisa"});
        list.add(new Object[]{"alisiaagranov@gmail.com","212229Alisa"});

        return list.iterator();


    }


    @DataProvider
    public Iterator<Object[]> loginModelDto()
    {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User().withEmail("alisiaagranov@gmail.com").withPassword("212229Alisa")});
        list.add(new Object[]{new User().withEmail("alisiaagranov@gmail.com").withPassword("212229Alisa")});
        return list.iterator();
    }
}