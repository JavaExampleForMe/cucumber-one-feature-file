package ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import(MsTestConfig.class)
public class MsTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsTestApplication.class);
    }

}