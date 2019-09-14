package com.parcpaes.springsocket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.invernadero.SpringsocketApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes=SpringsocketApplication.class)
public class SpringsocketApplicationTests {

	@Test
	public void contextLoads() {
	}
}
