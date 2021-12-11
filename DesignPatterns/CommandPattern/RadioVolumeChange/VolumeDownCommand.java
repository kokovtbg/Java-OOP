package DesignPatterns.CommandPattern.RadioVolumeChange;

public class VolumeDownCommand implements Command {
    Radio radio;

    public VolumeDownCommand(Radio radio) {
        this.radio = radio;
    }

    @Override
    public void execute() {
        radio.volumeDown();
    }
}
