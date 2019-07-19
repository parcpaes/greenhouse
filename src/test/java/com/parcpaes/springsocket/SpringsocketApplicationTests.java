package com.parcpaes.springsocket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.invernadero.SpringsocketApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringsocketApplication.class)
@DataJpaTest
public class SpringsocketApplicationTests {

	@Test
	public void contextLoads() {
	}

}
