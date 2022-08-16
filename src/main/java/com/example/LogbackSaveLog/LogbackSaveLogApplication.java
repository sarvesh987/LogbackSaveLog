package com.example.LogbackSaveLog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootApplication
@RestController
public class LogbackSaveLogApplication {

	private static final Logger logger = LoggerFactory.getLogger(LogbackSaveLogApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LogbackSaveLogApplication.class, args);
	}

	@RequestMapping("/")
	public String hello() {
		logger.info("This is sample info message");
		logger.warn("This is sample warn message");
		logger.error("This is sample error message");
		logger.debug("This is sample debug message");


		List<Integer> data = Arrays.asList(1,2,3,4,5);
		logger.info("hello from logback {}",data);

		logger.error("This is a error message ", new  Exception("Testing"));

		MDC.put("user id ","userID");
		IntStream.rangeClosed(1,10).forEach(counter -> {
			logger.info("Counter : - " +counter);
		});

		Logger logger = LoggerFactory.getLogger("TestClass");
		logger.info("hi hello abc pqr xyz");

		int noOfProblems = 5;
		logger.info("we have {} problems",noOfProblems);

		return "Hello abc";
	}
}
