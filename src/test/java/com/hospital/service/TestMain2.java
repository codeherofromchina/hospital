package com.hospital.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain2 {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");

		PatientService bean = applicationContext.getBean(PatientService.class);
	}

}
