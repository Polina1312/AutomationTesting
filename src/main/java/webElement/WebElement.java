package webElement;

/**
 * Created by home on 27.05.2017.
 */

public abstract class WebElement {

    abstract String getText();

    abstract void clear();

    abstract void click();

    private void info() {
        System.out.println("Information about WebElement: " + getText());
    }
  //  abstract WebElement findElement(By by);
}
