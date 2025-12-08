package co.com.davivienda.tasks.front;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

import java.util.logging.Logger;


public class AbrirPagina implements Task {
    Logger LOGGER = Logger.getLogger(AbrirPagina.class.getName());
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            String urlBase = System.getProperty("webdriver.base.url");
            if (urlBase == null || urlBase.isEmpty()) {
                urlBase = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
            }
            actor.wasAbleTo(
                    Open.url(urlBase)
            );
            LOGGER.info("Se inicia la página correctamente");
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
        }
    }

    public static AbrirPagina abrirPagina() {
        return Tasks.instrumented(AbrirPagina.class);
    }
}
