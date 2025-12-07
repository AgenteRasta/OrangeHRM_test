package runners.front;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
@CucumberOptions(
        glue = "stepdefinitions/front/creacionEmpleado",
        features = "src/test/resources/features/front/ValidacionCreacionEmpleado.feature",
        tags = "@E2E",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class ValidacionCreacionEmpleadoTest {
}
