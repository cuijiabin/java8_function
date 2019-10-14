package com.function.demo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
		Map<Integer, String> strMap = map.entrySet().stream().collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue().stream().map(Person::getName).collect(Collectors.joining("&"))));
		System.out.println(strMap);
		//map.entrySet().stream().map(e -> e.getKey(), e ->e.getValue().stream().map(Person::getName).collect(Collectors.joining(";")).collect(Collectors.joining(";"));

		Optional<Person> po =pList.stream().filter(p -> p.getId() > 7).sorted((p1, p2) -> p2.getId().compareTo(p1.getId())).findFirst();
		System.out.println(po.isPresent());
	}
}
