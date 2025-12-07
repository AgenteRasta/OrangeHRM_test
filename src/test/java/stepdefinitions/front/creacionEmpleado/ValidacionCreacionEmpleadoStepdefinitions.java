package stepdefinitions.front.creacionEmpleado;

import co.com.davivienda.models.Empleado;
import co.com.davivienda.questions.ValidacionCreacionEmpleado;
import co.com.davivienda.tasks.front.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import setup.SetUpBack;

import static co.com.davivienda.tasks.front.AbrirPagina.abrirPagina;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.is;

public class ValidacionCreacionEmpleadoStepdefinitions extends SetUpBack {

    private Empleado empleadoTest=new Empleado();
    private Empleado empleadoFront=new Empleado();

    @Before
    public void setUp() {
        initialSetUpFront();
    }

    @When("se inicia sesión como administrador en OrangeHRM")
    public void seIniciaSesiónComoAdministradorEnOrangeHRM() {
        theActorInTheSpotlight().wasAbleTo(abrirPagina());
        theActorInTheSpotlight().attemptsTo(
                IniciarSesionAdmin.iniciarSesionAdmin()
        );
    }
    @When("navega al módulo de {string}")
    public void navegaAlMóduloDe(String modulo) {
        theActorInTheSpotlight().attemptsTo(
                IngresarModulo.ingresarModulo()
                        .aModulo(modulo)
        );
    }
    @When("registra un nuevo empleado con nombre {string} y apellido {string}")
    public void registraUnNuevoEmpleadoConNombreYApellido(String nombre, String apellido) {
        theActorInTheSpotlight().attemptsTo(
                AgregarEmpleado.agregarEmpleado()
                        .conNombre(nombre)
                        .conApellido(apellido)
        );
    }
    @When("sube una foto de perfil válida para el empleado y guarda el registro")
    public void subeUnaFotoDePerfilVálidaParaElEmpleadoYGuardaElRegistro() {
        theActorInTheSpotlight().attemptsTo(
                SubirFotoEmpleado.subirFotoEmpleado()
                        .conArchivo("fotoEmpleado.png")
        );
    }

    @When("busca al empleado recién creado por nombre completo")
    public void BuscaAlEmpleadoReciénCreadoPorNombreCompleto() {
        empleadoTest.setNombre(theActorInTheSpotlight().recall("nombreEmpleado"));
        empleadoTest.setApellido(theActorInTheSpotlight().recall("apellidoEmpleado"));
        theActorInTheSpotlight().attemptsTo(
                BuscarEmpleado.buscarEmpleado()
                        .conNombre(empleadoTest.getNombre())
                        .conApellido(empleadoTest.getApellido())
        );
        empleadoFront.setNombre(theActorInTheSpotlight().recall("nombreEmpleadoFront"));
        empleadoFront.setApellido(theActorInTheSpotlight().recall("apellidoEmpleadoFront"));
    }
    @Then("el sistema muestra la información básica del empleado de manera correcta")
    public void elSistemaMuestraLaInformaciónBásicaDelEmpleadoDeManeraCorrecta() {
        theActorInTheSpotlight().should(
                seeThat(ValidacionCreacionEmpleado.comparar(empleadoTest, empleadoFront), is(true))
        );
    }

    @After
    public void finish(){
        quitarDriver();
    }
}
