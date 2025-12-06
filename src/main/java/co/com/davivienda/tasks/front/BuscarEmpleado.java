package co.com.davivienda.tasks.front;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.logging.Logger;

import static co.com.davivienda.userinterface.ModuloDirectory.*;
import static co.com.davivienda.utils.Utils.generarEspera;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarEmpleado implements Task {
    Logger LOGGER = Logger.getLogger(BuscarEmpleado.class.getName());

    private String nombre;
    private String apellido;

    public BuscarEmpleado conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public BuscarEmpleado conApellido(String apellido){
        this.apellido = apellido;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(nombre).into(CAMPO_NOMBRE_COMPLETO)
        );
        generarEspera(5);
        try {
            actor.attemptsTo(
                    Click.on(OPCION_SUGERIDA),
                    Click.on(BOTON_SEARCH),
                    WaitUntil.the(seleccionarEmpleadoBusqueda(nombre.concat(" ").concat(apellido)), isVisible()).forNoMoreThan(15).seconds(),
                    Click.on(seleccionarEmpleadoBusqueda(nombre.concat(" ").concat(apellido)))
            );
            LOGGER.info("Se realiza la busqueda del empleado: ".concat(nombre).concat(" ").concat(apellido));
            String nombreEmpleadoEncontrado= OBTENER_NOMBRE_EMPLEADO.resolveFor(actor).getText();
            LOGGER.info("Empleado encontrado: ".concat(nombreEmpleadoEncontrado));
            String nombreCompleto = nombreEmpleadoEncontrado;
            String[] partes = nombreCompleto.split(" ");
            String nombre = partes[0];
            String apellido = partes.length > 1 ? partes[1] : "";
            actor.remember("nombreEmpleadoFront", nombre);
            actor.remember("apellidoEmpleadoFront", apellido);
        }catch (Exception e){
            LOGGER.warning(e.getMessage());
        }



    }

    public static BuscarEmpleado buscarEmpleado(){
        return new BuscarEmpleado();
    }
}
