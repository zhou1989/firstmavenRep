package com.zdl.hj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class SpringBootApplicationMain {

	public static void main(String[] args) {
			SpringApplication.run(SpringBootApplicationMain.class, args);
			System.out.print( "******the application seccuss on ！！！******");

	}

}
