package core.steps;

import core.CoreTestConfig;
import core.CoreTestContext;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

//@ContextConfiguration(classes = {CoreTestConfig.class})
public class CoreSteps {
    CoreTestContext coreTestContext;
    @Value("${inputText}")
    private String inputText;

    public CoreSteps(CoreTestContext coreTestContext) {
        this.coreTestContext = coreTestContext;
    }

    @Then("^output OK$")
    public void output_OK() {
        Assert.assertEquals(coreTestContext.getSomething(),inputText) ;
    }

    @Then("^isAlive (.*)$")
    public void isAlive(String isAliveString) {
        Assert.assertEquals(coreTestContext.isAlive(),Boolean.valueOf(isAliveString)) ;
    }
}
