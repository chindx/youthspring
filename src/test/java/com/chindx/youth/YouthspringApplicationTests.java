package com.chindx.youth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chindx.youth.config.BookProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YouthspringApplicationTests {
	@Autowired
	private BookProperties bookProperties;
	@Test
	public void contextLoads() {
		System.err.println("************************************");
		System.err.println(bookProperties.getName());
		System.err.println(bookProperties.getWriter());
		System.err.println("************************************");
	}
}
