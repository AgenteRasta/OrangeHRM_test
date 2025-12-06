package co.com.davivienda.tasks.front;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;

import java.nio.file.Paths;
import java.util.logging.Logger;

import static co.com.davivienda.userinterface.PaginaAgregarEmpleado.*;

public class SubirFotoEmpleado implements Task {
    Logger LOGGER = Logger.getLogger(SubirFotoEmpleado.class.getName());
    private String nombreArchivo;

    public SubirFotoEmpleado conArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String rutaAbsoluta = Paths.get("src/test/resources/archivos/", nombreArchivo)
                .toAbsolutePath()
                .toString();
        try {
            actor.attemptsTo(
                    SendKeys.of(rutaAbsoluta).into(INPUT_FOTO),
                    Click.on(GUARDAR_FOTO)
            );
            LOGGER.info("Se sube la foto del empleado correctamente.");
        }catch (Exception e){
            LOGGER.warning("Error al subir la foto del empleado: " + e.getMessage());
        }

    }

    public static SubirFotoEmpleado subirFotoEmpleado() {
        return new SubirFotoEmpleado();
    }
}
