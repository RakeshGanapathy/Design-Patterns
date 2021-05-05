package designpattern.creational.factory;

import java.util.Scanner;

public class UserImpl {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("enter your choice of Impl");
		System.out.println("1.LED\n2.Mercury\n3.Solar");
		String typeOfLight = scan.next();
		ISwitch sw = ObjectFactory.getLight(typeOfLight);
		sw.switchOff();
		sw.switchOn();

		scan.close();

	}

}
