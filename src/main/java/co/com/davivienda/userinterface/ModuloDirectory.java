package co.com.davivienda.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ModuloDirectory extends PageObject {

    public static Target CAMPO_NOMBRE_COMPLETO= Target.the("Campo para ingresar el nombre completo").
            locatedBy("//input[@placeholder='Type for hints...']");

    public static Target seleccionarNombre(String nombreCompleto){
        return Target.the("Seleccionar el nombre completo").
                locatedBy("//div[contains(@class,'oxd-autocomplete-dropdown')]//div[text()='"+nombreCompleto+"']");
    }
    public static final Target OPCION_SUGERIDA = Target.the("opción sugerida")
            .located(By.xpath("//div[contains(@class,'oxd-autocomplete-dropdown')]//div[1]"));

    public static Target BOTON_SEARCH= Target.the("Botón para iniciar la búsqueda").
            locatedBy("//button[contains(normalize-space(.),'Search')]");

    public static Target seleccionarEmpleadoBusqueda(String nombreCompleto){
        return Target.the("Seleccionar el empleado buscado").
                locatedBy("//p[contains(normalize-space(.),'"+nombreCompleto+"')]");
    }

    public static Target OBTENER_NOMBRE_EMPLEADO=Target.the("Obtener el nombre del empleado").
            locatedBy("//p[@class='oxd-text oxd-text--p orangehrm-directory-card-header']");
}
