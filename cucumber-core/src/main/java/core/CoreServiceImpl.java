package core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@PropertySource("classpath:application.properties")
public class CoreServiceImpl implements CoreService {
    @Value("${inputText}")
    private String inputText;
    @Autowired
    private ApplicationContext ctx;

    public CoreServiceImpl() {
        System.out.println("In contr");
    }

    @PostConstruct
    public void post() {
        System.out.println("Let's inspect the beans provided by Spring Boot:");

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    @Override
    public boolean isAlive() {
        return true;
    }

    @Override
    public String printSomething() {
        System.out.println("Input Message: " + inputText);
        return inputText;
    }

    @Override
    public String getSomething() {
        return inputText;
    }
}
