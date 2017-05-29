package webElement;

/**
 * Created by home on 27.05.2017.
 */
public class CheckBoxElement extends WebElement {
    private String name;

    public CheckBoxElement(String name) {
        this.name = name;
    }

    String getText() {
        return "CheckBoxElement name is: " + this.name;
    }
    void clear() {
        name=null;
    }

    void click() {
        System.out.println("Element "+name+" is selected");
    }
}
