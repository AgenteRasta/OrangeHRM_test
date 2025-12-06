package co.com.proteccion.tasks.frontend;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;


public class OpenMainPage implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.wasAbleTo(
                Open.url("https://vaxtpmde69.proteccion.com.co/portalafiliados/afiliados/certifacil")
        );
    }

    public static OpenMainPage openMainPage() {
        return Tasks.instrumented(OpenMainPage.class);
    }
}
