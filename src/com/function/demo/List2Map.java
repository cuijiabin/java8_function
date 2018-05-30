package com.function.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * List 转 map
 */
public class List2Map {

	private List<Person> pList = Arrays.asList(new Person(1L, "person1", 1),
			new Person(2L, "person2", 2),
			new Person(3L, "person3", 1),
			new Person(4L, "person4", 2),
			new Person(5L, "person5", 2),
			new Person(6L, "person6", 1));

	@Test
	public void genFieldMap() {

		Map<Long, Person> map = pList.stream().collect(Collectors.toMap(Person::getId, p -> p));
		System.out.println(map);
	}

	@Test
	public void genFieldMapList() {

		Map<Integer, List<Person>> map = pList.stream().collect(Collectors.groupingBy(Person::getSex));
		System.out.println(map);
	}
}
