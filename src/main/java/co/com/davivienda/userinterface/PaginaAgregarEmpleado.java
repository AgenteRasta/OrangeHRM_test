package co.com.davivienda.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaAgregarEmpleado extends PageObject {

    public static Target CAMPO_FIRST_NAME = Target.the("Campo para el primer nombre")
            .locatedBy("//input[@placeholder='First Name']");

    public static Target CAMPO_MIDDLE_NAME= Target.the("Campo para el segundo nombre")
            .locatedBy("//input[@placeholder='Middle Name']");

    public static Target CAMPO_LAST_NAME= Target.the("Campo para el primer apellido")
            .locatedBy("//input[@placeholder='Last Name']");

    public static Target BOTON_SUBIR_FOTO= Target.the("Boton para subir la foto del empleado")
            .locatedBy("//button[@class='oxd-icon-button oxd-icon-button--solid-main employee-image-action']");

    public static Target CAMPO_EMPLOYEE_ID= Target.the("Campo para obtener el employee id")
            .locatedBy("(//input[@class='oxd-input oxd-input--active'])[2]");

    public static final Target INPUT_FOTO = Target.the("Subir imagen perfil")
            .locatedBy("//input[@type='file']");

    public static final Target GUARDAR_FOTO = Target.the("Guarda la foto despues de subirla")
            .locatedBy("//button[contains(.,'Save')]");


}
