package cm.zdl.hj.function;

import cm.zdl.hj.config.CustomConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients
@SpringBootApplication
public class FunctionsSpringbootApp {
    public static void main(String[] args) {
        try{
            SpringApplication.run(FunctionsSpringbootApp.class, args);
            System.out.print( "******the application seccuss on ！！！******");
        }catch (Exception e){
            System.out.print( "[******zdlzdlzdl!!!!!!!!!!!!*cskjbcksdncdkd*****"+e.getMessage()+"*************hdoc**********************]");
        }


    }

}
