package designpattern.creational.factory;

public class SolarLightImpl implements ISwitch {

	public void switchOn() {
		System.out.println("Solar light switched on ");

	}

	public void switchOff() {
		System.out.println("Solar light switched off");
	}
}
