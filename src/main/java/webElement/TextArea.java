package webElement;

import java.util.Scanner;

/**
 * Created by home on 27.05.2017.
 */
public class TextArea extends WebElement {
    private String name;
    private String text = null;


//    public TextArea(String name) {
//        this.name = name;
//    }

    String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void clear() {
        setText(null);
    }

    void click() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text, please");
        text = sc.nextLine();
        sc.close();
    }



    void readOnly(boolean setResult){
        if(setResult){
            System.out.println("ReadOnly field");
        }
        else{
            System.out.println("You can write here");
        }
    }
}
