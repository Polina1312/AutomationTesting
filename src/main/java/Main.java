import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.io.File;

/**
 * Created by home on 29.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        String iua = "http://www.i.ua";
        File file = new File("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
       WebDriver driver = new ChromeDriver();
       // WebDriver driver = new HtmlUnitDriver();
        driver.get(iua);
        new MainPage(driver);
              //  .entering("login", "password");
        driver.close();
    }
}
