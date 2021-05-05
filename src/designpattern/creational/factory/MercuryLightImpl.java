package designpattern.creational.factory;

public class MercuryLightImpl implements ISwitch {
	public void switchOn() {
		System.out.println("Mercury light switched on ");

	}

	public void switchOff() {
		System.out.println("Mercury light switched off");
	}
}
