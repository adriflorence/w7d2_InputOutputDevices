import behaviours.IInput;
import behaviours.IOutput;
import device_management.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class ComputerTest {

    Monitor monitor;
    Printer printer;
    Mouse mouse;
    Speaker speaker;
    Computer computer;
    Keyboard keyboard;

    @Before
    public void before() {
        monitor = new Monitor(22, 786432);
        printer = new Printer("Epson", "Stylus", 120, 4);
        mouse = new Mouse("Logitech","wireless", 3);
        speaker = new Speaker(100);
        computer = new Computer(8, 512, printer, mouse);
        keyboard = new Keyboard("Logitech","wireless", "qwerty");
    }

    @Test
    public void hasRam() {
        assertEquals(8, computer.getRam());
    }

    @Test
    public void hasHddSize() {
        assertEquals(512, computer.getHddSize());
    }

    @Test
    public void hasOutputDevice() {
        IOutput outputDevice = computer.getOutputDevice();
        assertNotNull(outputDevice);
    }

    @Test
    public void canOutputData() {
        assertEquals("space invaders is now on screen", computer.outputData("space invaders"));
    }

    @Test
    public void canOutputDataViaPrinter() {
        assertEquals("printing: space invaders", computer.outputData("space invaders"));
    }

    @Test
    public void canOutputDataViaSpeaker() {
        Speaker speaker = new Speaker(100);
        computer = new Computer(8, 512, speaker, keyboard);
        assertEquals("playing: invaders must die!", computer.outputData("invaders must die!"));
    }

    @Test
    public void canChangeOutputDevice() {

        // STRATEGY PATTERN
        Speaker speaker = new Speaker(100);
        computer = new Computer(8, 512, speaker, keyboard);
        printer = new Printer("Epson", "Stylus", 120, 4);
        computer.setOutputDevice(printer);
        assertEquals("printing: invaders must die!", computer.outputData("invaders must die!"));
    }


    /// INPUT

    @Test
    public void hasInputDevice() {
        IInput inputDevice = computer.getInputDevice();
        assertNotNull(inputDevice);
    }


    @Test
    public void canInputDataViaMouse() {
        computer = new Computer(8, 512, speaker, mouse);
        assertEquals("you clicked on the button", computer.sendData("the button"));
    }

    @Test
    public void canInputDataViaKeyboard() {
        computer = new Computer(8, 512, speaker, keyboard);
        assertEquals("you typed words", computer.sendData("words"));
    }

    @Test
    public void canChangeInputDevice() {
        computer = new Computer(8, 512, speaker, keyboard);
        computer.setInputDevice(mouse);
        assertEquals("you clicked on the button", computer.sendData("the button"));
    }


}
