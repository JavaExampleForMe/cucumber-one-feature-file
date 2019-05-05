package ms;

import core.CoreService;
import core.CoreTestConfig;
import core.CoreTestContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Import({CoreTestConfig.class})
public class MsTestConfig implements WebMvcConfigurer {


    @Bean
    MsTestController msTestController(CoreTestContext testContext) {
        return new MsTestController(testContext);
    }

    @Primary
    @Bean
    CoreTestContext testContext() {


        return new CoreTestContext() {

            public RestTemplate restTemplate = new RestTemplate();
            private String url = "localhost:12345/Sample";
            private String testUrl = "localhost:12346/Sample";

            @Override
            public boolean isAlive() {
                String forObject = (String) restTemplate.getForObject(testUrl + "/isAlive", String.class);
                return Boolean.valueOf(forObject);
            }

            @Override
            public String printSomething() {
                String forObject = (String) restTemplate.getForObject(testUrl + "/printSomething", String.class);
                return forObject;
            }

            @Override
            public String getSomething() {
                String forObject = (String) restTemplate.getForObject(testUrl + "/getSomething", String.class);
                return forObject;
            }
        };
    }
}
