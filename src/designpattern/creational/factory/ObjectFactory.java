package designpattern.creational.factory;

public class ObjectFactory {
	public static ISwitch getLight(String typeOfLight) {
		if(typeOfLight.equalsIgnoreCase("led")) {
			return new LEDLighImpl();
		}
		else if (typeOfLight.equalsIgnoreCase("solar")) {
			return new SolarLightImpl();
		}
		else if(typeOfLight.equalsIgnoreCase("mercury")) {
			return new MercuryLightImpl();
		}
		else {
			throw new RuntimeException("Implementation is not found");
		}
	}
}
