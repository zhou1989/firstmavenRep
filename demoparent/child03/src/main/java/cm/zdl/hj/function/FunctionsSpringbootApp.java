package cm.zdl.hj.function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FunctionsSpringbootApp {
    public static void main(String[] args) {
        SpringApplication.run(FunctionsSpringbootApp.class, args);
        System.out.print( "******the application seccuss on ！！！******");

    }

}
