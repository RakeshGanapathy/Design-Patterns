package designpattern.creational.factory;

public class LEDLighImpl implements ISwitch {

	public void switchOn() {
		System.out.println("LED light switched on ");

	}

	public void switchOff() {
		System.out.println("LED light switched off");
	}

}
