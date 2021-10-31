package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public boolean islogInPresent() {
        return isElementPresent(By.xpath("//a[text()=' Log in ']"));
    }


    public void logout() {
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public void openLoginForm() {
        click(By.xpath("//a[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password)
    {
       type(By.id("email"),email);
       type(By.id("password"),password);
    }
    public void fillLoginForm(User user)
    {
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());
    }


    public void submitForm()
    {
        click(By.xpath("//button[@type='submit']"));
    }

    public boolean isLoggedSuccess()
    {
        WebDriverWait wait = new WebDriverWait(wd, 10); //skolko sekund budet zhdat brauser etogo okna
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        return wd.findElement(By.cssSelector(".dialog-container h2")).getText().contains("success");//proverka esli mi zaloginenu u esli est slovo success
    }

    public void clickOkButton() {

        if(isElementPresent(By.xpath("//button[text()='Ok']")))
        {
            click(By.xpath("//button[text()='Ok']"));
        }
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitForm();
        clickOkButton();
        pause(1000);

    }
}
