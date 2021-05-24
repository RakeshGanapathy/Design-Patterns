package designpattern.creational.builder;

import java.util.List;
import java.util.Set;

public class Menu {

	public static void main(String[] args) {
		LunchOrderV2 builder = LunchOrderV2.builder().bread("wheat").dressing(Set.of("ghee","moyoneese","honey")).condiments("lettuce").meat(List.of("chicken","mutton","chicken")).build();
		System.out.println(builder.getBread());
		System.out.println(builder.getCondiments());
		System.out.println(builder.getMeat());
		System.out.println(builder.toString());
	}
	
	

}