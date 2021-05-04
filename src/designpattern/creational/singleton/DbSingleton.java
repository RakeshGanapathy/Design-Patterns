package designpattern.creational.singleton;

public class DbSingleton {

	private static volatile DbSingleton instance;

	private DbSingleton() {
		if (instance != null) {
			throw new RuntimeException("use get instance method to create");
		}
	}

	public static DbSingleton getInstance() {
		// lazy instantiation
		if (instance == null) {
			// thread safe check
			synchronized (DbSingleton.class) {
				if (instance == null) {
					instance = new DbSingleton();
				}
			}
		}
		return instance;
	}
}

class Implementation {
	public static void main(String[] args) {
		System.out.println("main method");
		DbSingleton ref = DbSingleton.getInstance();
		System.out.println(ref);
		DbSingleton ref1 = DbSingleton.getInstance();
		System.out.println(ref1);
	}
}