package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by home on 27.05.2017.
 */
public abstract class BasePage {

    private String currentPage;

    final public String WEB_SITE_NAME = "Some site";

    abstract void init();

    private void mainPageRedirection() {
        System.out.println("You are on Main Page!");
    }

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
