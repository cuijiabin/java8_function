package com.function.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 过滤map
 */
public class FilterMap {

	public static void main(String[] args) {
		Map<String, Person> map = new HashMap<>();

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

		map.put("person1", person1);
		map.put("person2", person2);
		map.put("person3", person3);
		map.put("person4", person4);
		map.put("person5", person5);
		map.put("person6", person6);

		List<Long> list = map.values().stream().map(Person::getId).collect(Collectors.toList());

		System.out.println(list);

		List<Person> xlist = new ArrayList<>(map.values());
		xlist.forEach(p ->{System.out.println(p.getId());});
		long count = xlist.stream().filter(p -> p.getId()>4).count();
		System.out.println(count);


		Stream.of("a1", "a2", "a3")
				.findFirst()
				.ifPresent(System.out::println);
		// a1
	}
}
