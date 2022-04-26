package com.mainstream.userapp;

import com.mainstream.userapp.service.ClientService;
import com.mainstream.userapp.service.utils.IDNumberValidator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class UserappApplicationTests {

	@Autowired
	private ClientService clientService;

	@Test
	void contextLoads() {
	}

	@Test
	public void TestValidIDNumber(){
		Assert.assertEquals(true, IDNumberValidator.validate("9704285960082"));
	}

	@Test
	public void TestInValidIDNumber(){
		Assert.assertEquals(false, IDNumberValidator.validate("9704285960078"));
	}


}
