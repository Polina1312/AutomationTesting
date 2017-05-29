package webElement;

/**
 * Created by home on 27.05.2017.
 */
public class Link extends WebElement {
    private String name;

    public Link(String name) {
        this.name = name;
    }

    String getText() {
        return this.name;
    }

    void clear() {
        name = null;
    }

    void click() {
        System.out.println("Link was clicked. User was redirected on the " + this.name + " page");
    }
}
