package device_management;

import behaviours.IInput;

public class Mouse extends InputDevice implements IInput {

    String make;
    String type; // wireless, corded
    int numberOfButtons;

    public Mouse(String make, String type, int numberOfButtons) {
        super(make, type);
        this.numberOfButtons = numberOfButtons;
    }

    public String move(){
        return "mouse is moved.";
    }

    public String click(){
        return "click.";
    }

    public String sendData(String data) {
        return "you clicked on " + data;
    }
}
