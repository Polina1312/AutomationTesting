package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import webElement.Button;
import webElement.TextArea;

/**
 * Created by home on 27.05.2017.
 */
public class MainPage extends BasePage {

    void init() {

    }

    private WebDriver driver;

    @FindBy(name = "login")
    private TextArea loginField;

    @FindBy(name = "pass")
    private TextArea passwordField;

    @FindBy(xpath = "html/body/div[3]/div[3]/div[3]/div[2]/div[1]/div[3]/form/p/input")
    private Button loginButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(String login) {
        this.loginField.clear();
        this.loginField.setText(login);
    }

    public void enterPassword(String password) {
        this.passwordField.clear();
        this.passwordField.setText(password);
    }

    public void entering(String login, String password){
        enterLogin(login);
        enterPassword(password);
    }

    public MailPage redirection(String login, String password){
        enterLogin(login);
        enterPassword(password);
        loginButton.click();
        return new  MailPage(driver);
    }
}
