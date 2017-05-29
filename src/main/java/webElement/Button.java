package webElement;

/**
 * Created by home on 27.05.2017.
 */
public class Button extends WebElement {
    private String name;

    public Button(String name) {
        this.name = name;
    }

    String getText() {
        return "Button name is: "+ this.name;
    }

    void clear() {
        this.name = null;
    }

    public void click() {
        System.out.println("Button "+this.name+" is clicked");
    }

    void action(){

    }
}
