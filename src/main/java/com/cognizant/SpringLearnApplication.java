package com.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	public static void main(String[] args) throws ParseException {

		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");

		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		LOGGER.info("START");
		Date date =  format.parse("10/05/2021");
		LOGGER.debug("Formatted Date: " +  date);
		LOGGER.info("END");

		displayCountry();

		SpringApplication.run(SpringLearnApplication.class, args);
	}
	public static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		 Object countryList = context.getBean("countryList");
		 LOGGER.debug("Countries: " +  countryList);

	}
}
