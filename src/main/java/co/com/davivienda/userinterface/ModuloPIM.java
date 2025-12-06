package co.com.davivienda.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class ModuloPIM extends PageObject {

    public static Target BOTON_ADD_EMPLEADO=
            Target.the("Boton para agregar empleado").
                    locatedBy("//button[contains(.,'Add')]");
}
