package designpattern.creational.prototype;

public class ProtoType {

	public static void main(String[] args) {

		// we are not suppose to use new keyword - no hard code creation
		// we going clone the object and reinitialize the values
		Registry registry = new Registry();
		Movie movie = (Movie) registry.createItem("Movie");
		movie.setTitle("Design Patterns");
		System.out.println(movie);
		Movie movie2 = (Movie) registry.createItem("Movie");
		movie.setTitle("Gang of Four Patterns");
		System.out.println(movie2);
		Book book = (Book) registry.createItem("Book");
		book.setTitle("Gang of Four Patterns");
	}

}
