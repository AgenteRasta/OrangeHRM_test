package co.com.davivienda.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class MenuInicial extends PageObject {

    public static final Target BOTON_PIN=
            Target.the("Acceder al modulo PIM").
                    locatedBy("//span[text()='PIM']");

    public static Target seleccionarModulo(String modulo){
        return Target.the("Seleccionar modulo " + modulo)
                .locatedBy("//span[text()='"+modulo+"']");
    }


}
