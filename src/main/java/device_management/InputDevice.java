package device_management;

public abstract class InputDevice {

    private String make;
    private String type;

    public InputDevice(String make, String type) {
        this.make = make;
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public String getType() {
        return type;
    }
}
