package co.com.davivienda.tasks.front;

import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.logging.Logger;

import static co.com.davivienda.userinterface.ModuloPIM.BOTON_ADD_EMPLEADO;
import static co.com.davivienda.userinterface.PaginaAgregarEmpleado.*;

public class AgregarEmpleado implements Task {
    Logger LOGGER = Logger.getLogger(AgregarEmpleado.class.getName());
    private Faker faker= new Faker();
    private String nombre;
    private String apellido;

    public AgregarEmpleado conNombre(String nombre){
        this.nombre = nombre;
        return this;
    }
    public AgregarEmpleado conApellido(String apellido){
        this.apellido = apellido;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        if(nombre.equals("Aleatorio")){
            nombre=faker.name().firstName();
        }
        if(apellido.equals("Aleatorio")){
            apellido=faker.name().lastName();
        }
        LOGGER.info("Se ingresara el empleado con nombre: "+nombre+" y apellido: "+apellido);
        actor.attemptsTo(
                Click.on(BOTON_ADD_EMPLEADO),
                Enter.theValue(nombre).into(CAMPO_FIRST_NAME),
                Enter.theValue(apellido).into(CAMPO_LAST_NAME),
                Enter.theValue(String.valueOf(1000 + new java.security.SecureRandom().nextInt(9000))).into(CAMPO_EMPLOYEE_ID)
        );
        actor.remember("nombreEmpleado", nombre);
        actor.remember("apellidoEmpleado", apellido);
    }

    public static AgregarEmpleado agregarEmpleado(){
        return new AgregarEmpleado();
    }
}
