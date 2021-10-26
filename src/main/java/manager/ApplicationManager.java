package manager;

import org.openqa.selenium.WebDriver;

public class ApplicationManager {
    WebDriver wd;

    public void init()
    {

    }

    public void stop()
    {
        wd.quit();
    }

}
