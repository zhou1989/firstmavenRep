package com.zdl.hj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SpringBootApplicationMain {

	public static void main(String[] args) {
		try{
			SpringApplication.run(SpringBootApplicationMain.class, args);
			System.out.print( "******the application seccuss on ！！！******");
		}catch (Exception e){
			System.out.print( "******djbksvjnkjv******"+e.getMessage());
		}


	}

}
