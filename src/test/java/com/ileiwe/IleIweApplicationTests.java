package com.ileiwe;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class IleIweApplicationTests {


//	@Autowired
//	DataSource datasource;
//
//
//	@Value("${test-name}")
//	private String name;
//	@Value("${test-year}")
//	private String currentYear;



//	@Test
//	public void printValues(){
//		assertThat(name).isEqualTo("Jack");
//		assertThat(currentYear).isEqualTo("2020");
//		log.info("Test name -> {}", name);
//		log.info("Test year -> {}", currentYear);
//	}
//
//	@Test
//	public void connectToDatabaseTest(){
//		assertThat(datasource).isNotNull();
//		log.info("DataSource properties -> {} ", datasource);
//
//		try{
//			Connection connection = datasource.getConnection();
//			assertThat(connection).isNotNull();
//			log.info("Database -> {}", connection.getCatalog());
//		} catch(SQLException exception){
//			log.info("An exception occurred -> {}", exception.getMessage());
//		}
//	}





//	@Test
//	void contextLoads() {
//	}

}
