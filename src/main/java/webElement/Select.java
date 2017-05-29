package webElement;

import java.util.ArrayList;

/**
 * Created by home on 27.05.2017.
 */
public class Select extends WebElement {
    private String name;
    private ArrayList<SelectElement> option= new ArrayList<SelectElement>();

    public ArrayList<SelectElement> getOption() {
        return option;
    }

    public void setOption(ArrayList<SelectElement> option) {
        this.option = option;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Select(String name) {
        this.name = name;
    }

    String getText() {
        return "Select name is: " + this.name;
    }

    void clear() {
        option.clear();
    }

    void click() {
        System.out.println("Select "+name+" is selected");
    }
}
