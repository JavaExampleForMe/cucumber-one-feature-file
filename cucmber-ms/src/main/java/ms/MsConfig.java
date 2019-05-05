package ms;

import core.CoreService;
import core.CoreServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MsConfig {
    @Bean
    public CoreService sampleService() {
        return new CoreServiceImpl();
    }
}
