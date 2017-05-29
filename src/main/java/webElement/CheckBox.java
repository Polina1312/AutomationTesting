package webElement;

import java.util.ArrayList;

/**
 * Created by home on 27.05.2017.
 */
public class CheckBox extends WebElement {
    private String name;
    private ArrayList<CheckBoxElement> elements= new ArrayList<CheckBoxElement>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CheckBoxElement> getElements() {
        return elements;
    }

    public void setElements(ArrayList<CheckBoxElement> elements) {
        this.elements = elements;
    }

    public CheckBox(String name) {
        this.name = name;
    }

    String getText() {
        return "CheckBox name is: " + this.name;
    }

    void clear() {
        elements=null;
    }

    void click() {
        System.out.println("CheckBox "+name+" is selected");
    }
}
