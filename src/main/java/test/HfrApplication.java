package test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.abdm.hfr","hfr.test","com.abdm.hprData.entity"})
@EntityScan(basePackages = {"com.abdm.hfr.entity", "com.abdm.hprData.entity"})
public class HfrApplication {
    public static void main(String[] args) {
        SpringApplication.run(HfrApplication.class,args);
    }
}
