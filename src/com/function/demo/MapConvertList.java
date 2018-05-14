package com.function.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapConvertList {

	public static void main(String[] args) {
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();
		Person person4 = new Person();
		Person person5 = new Person();
		Person person6 = new Person();

		person1.setId(1L);
		person1.setName("1111");
		person2.setId(2L);
		person2.setName("222");
		person3.setId(3L);
		person3.setName("333");
		person4.setId(3L);
		person4.setName("444");
		person5.setId(2L);
		person5.setName("555");
		person6.setId(1L);
		person6.setName("666");

		List<Person> list = Arrays.asList(person1,person2,person3,person4,person5,person6);

		Map<Long, List<Person>> map = list.stream().collect(Collectors.groupingBy(Person::getId));

		System.out.println(map);
	}
}
