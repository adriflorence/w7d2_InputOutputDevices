package device_management;

import behaviours.IInput;

public class Keyboard extends InputDevice implements IInput{

    String make;
    String type; // wireless, corded
    String layout; // qwerty, qwertz

    public Keyboard(String make, String type, String layout) {
        super(make, type);
        this.layout = layout;
    }

    public String sendData(String data) {
        return "you typed " + data;
    }
}
