package device_management;

import behaviours.IInput;
import behaviours.IOutput;

public class Computer {
    private int ram;
    private int hddSize;
    private IOutput outputDevice;
    private IInput inputDevice;

    public Computer(int ram, int hddSize, IOutput outputDevice, IInput inputDevice) {
        this.ram = ram;
        this.hddSize = hddSize;
        this.outputDevice = outputDevice;
        this.inputDevice = inputDevice;
    }

    public int getRam() {
        return this.ram;
    }

    public int getHddSize() {
        return this.hddSize;
    }

    public IOutput getOutputDevice() {
        return outputDevice;
    }

    public void setOutputDevice(IOutput outputDevice) {
        this.outputDevice = outputDevice;
    }

    public IInput getInputDevice() {
        return inputDevice;
    }

    public void setInputDevice(IInput inputDevice) {
        this.inputDevice = inputDevice;
    }

    public String inputData(String data) {
        return this.inputDevice.sendData(data);
    }

    public String sendData(String data) {
        return this.inputDevice.sendData(data);
    }

    public String outputData(String data) {
        return this.outputDevice.outputData(data);
    }
}
