package manager;

import org.openqa.selenium.*;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
public class HelperBase {
    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }//konstruktor
 public boolean isElementPresent(By locator)
 {
     return wd.findElements(locator).size()>0;
 }

 public void click(By locator)
 {
     wd.findElement(locator).click();
 }

 public void type(By locator, String text)
 {
     if (text!=null && !text.isEmpty())
     {
         WebElement el = wd.findElement(locator);
         el.click();
         el.clear();
         el.sendKeys(text);
     }
 }

    public void pause(int millis)
    {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    }

