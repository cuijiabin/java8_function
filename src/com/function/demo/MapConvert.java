package com.function.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * List 转 map
 */
public class MapConvert {

	public static void main(String[] args) {
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();
		Person person4 = new Person();
		Person person5 = new Person();
		Person person6 = new Person();

		person1.setId(1L);
		person2.setId(2L);
		person3.setId(3L);
		person4.setId(4L);
		person5.setId(5L);
		person6.setId(6L);

		List<Person> list = Arrays.asList(person1,person2,person3,person4,person5,person6);

		Map<Long, Person> map = list.stream().collect(Collectors.toMap(Person::getId, p -> p));

		System.out.println(map);
	}
}
