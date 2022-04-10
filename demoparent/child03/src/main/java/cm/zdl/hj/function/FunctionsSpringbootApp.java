package cm.zdl.hj.function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
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
