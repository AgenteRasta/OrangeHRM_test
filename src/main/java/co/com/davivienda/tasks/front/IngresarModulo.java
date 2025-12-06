package co.com.davivienda.tasks.front;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.logging.Logger;

import static co.com.davivienda.userinterface.MenuInicial.seleccionarModulo;

public class IngresarModulo implements Task {
    Logger LOGGER = Logger.getLogger(IngresarModulo.class.getName());
    private String modulo;

    public IngresarModulo aModulo(String modulo){
        this.modulo=modulo;
        return this;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(
                    Click.on(seleccionarModulo(modulo))
            );
            LOGGER.info("Se ingresó al módulo: " + modulo);
        }catch (Exception e){
                LOGGER.warning(e.getMessage());
        }

    }

    public static IngresarModulo ingresarModulo(){
        return new IngresarModulo();
    }
}
