package ms;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/",
        glue = {"core.steps"}
)
public class MSCucumberTest {

    private static ConfigurableApplicationContext appContext;

    @BeforeClass
    public static void open(){
        appContext = SpringApplication.run(MsTestApplication.class, "");
    }
    @AfterClass
    public static void close(){
        appContext.close();
    }
}