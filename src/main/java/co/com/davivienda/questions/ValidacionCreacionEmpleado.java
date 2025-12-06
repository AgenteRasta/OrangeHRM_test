package co.com.davivienda.questions;

import co.com.davivienda.models.Empleado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.logging.Logger;

public class ValidacionCreacionEmpleado implements Question<Boolean> {

    private static final Logger LOGGER = Logger.getLogger(ValidacionCreacionEmpleado.class.getName());
    private final Empleado esperado;
    private final Empleado actual;

    public ValidacionCreacionEmpleado(Empleado esperado, Empleado actual) {
        this.esperado = esperado;
        this.actual = actual;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        LOGGER.info("Comparando empleado esperado: " + esperado + " con empleado actual: " + actual);
        boolean sonIguales = esperado.equals(actual);
        LOGGER.info("¿Son iguales? " + sonIguales);
        return sonIguales;
    }

    public static ValidacionCreacionEmpleado comparar(Empleado esperado, Empleado actual) {
        return new ValidacionCreacionEmpleado(esperado, actual);
    }
}
