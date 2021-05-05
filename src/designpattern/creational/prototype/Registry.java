package designpattern.creational.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {
	private Map<String, Item> cart = new HashMap<>();

	public Registry() {
		loadCart();
	}

	public Item createItem(String type) {
		Item item = null;
		try {
			item = (Item) (cart.get(type)).clone();
		} catch (CloneNotSupportedException ce) {
			ce.printStackTrace();
			System.out.println(ce.getMessage());
		}
		return item;
	}

	private void loadCart() {
		Movie movie = new Movie();
		movie.setTitle("Karnan");
		movie.setPrice(200);
		movie.setRuntime("2 hours");
		cart.put("Movie", movie);
		Book book = new Book();
		book.setTitle("Half");
		book.setPrice(19.99);
		book.setNumberOfPages(334);
		cart.put("Book", book);
	}
}
