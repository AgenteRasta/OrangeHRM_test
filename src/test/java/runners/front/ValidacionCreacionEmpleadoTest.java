package runners.front;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "stepdefinitions/front/creacionEmpleado",
        features = "src/test/resources/features/front/ValidacionCreacionEmpleado.feature",
        tags = "@E2E",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ValidacionCreacionEmpleadoTestRunner {
}
