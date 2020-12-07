package com.connected.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.connected.ConnectedServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConnectedServiceApplication.class)
public class ConnectedServiceImplTest {
	
	@Autowired
	private ConnectedService connectedService;
	
	@Test
	public void cityConnected() {
		String connected = connectedService.isConnected("Boston", "Newark");
		assertTrue("yes".equals(connected));
	}
	
	@Test
	public void cityNotConnected() {
		String connected = connectedService.isConnected("Philadelphia", "Albany");
		assertTrue("no".equals(connected));
	}
	
	@Test
	public void cityConnected1() {
		String connected = connectedService.isConnected("Boston", "Philadelphia");
		assertTrue("yes".equals(connected));
	}
}
