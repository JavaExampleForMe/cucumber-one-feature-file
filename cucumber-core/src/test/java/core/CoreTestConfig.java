package core;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
@Import({CoreConfig.class})
public class CoreTestConfig {

    @Bean
    public CoreTestContext getCoreTestContext(CoreService coreService) {
        return new CoreTestContextImpl(coreService);
    }

}