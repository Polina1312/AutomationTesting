package webElement;

/**
 * Created by home on 27.05.2017.
 */
public class SelectElement extends WebElement {
    private String name;

    public SelectElement(String name) {
        this.name = name;
    }

    String getText() {
        return "SelectElement name is: " + this.name;
    }
    void clear() {
        name=null;
    }

    void click() {
        System.out.println("SelectElement "+name+" is selected");
    }
}
