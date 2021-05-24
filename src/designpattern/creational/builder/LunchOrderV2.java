package designpattern.creational.builder;

import java.util.List;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString

public class LunchOrderV2 {
    
	private  String bread;
	private  String condiments;
	/*
	 * Will not allow duplicate element in the dressing field
	 */
	@Singular("coating") private final Set<String> dressing;
	/*
	 * will allow duplicate element in the meat field
	 */
	@Singular("stuff") private  final List<String> meat;


}
