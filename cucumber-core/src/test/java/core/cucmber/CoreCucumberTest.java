package core.cucmber;

import core.CoreConfig;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Import;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        glue = {"core.steps"},
        features = "src/test/resources/features/"
)
public class CoreCucumberTest {
}