package com.github.amangupta00.demo.springboot;

import com.github.amangupta00.demo.springboot.model.User;
import com.github.amangupta00.demo.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
class DemoSpringBootApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		log.info("{}", userService.getUserForUserId(1));
	}

	@Test
	public void test() {
		List<Integer> ints = List.of(1, 2, 3, 4);
		List<User> users = ints.stream()
				.filter(value -> value % 2 == 0)
				.map(value -> userService.getUserForUserId(value))
				.collect(Collectors.toList());
		log.info("{}", users);
	}
}
