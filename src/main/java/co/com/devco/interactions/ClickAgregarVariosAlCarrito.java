package co.com.devco.interactions;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.CANTIDAD_PRODUCTOS_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeCarritoPage.LINK_PRIMER_DELETE_PRODUCTOS_CARRITO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickAgregarVariosAlCarrito implements Interaction {
    private Target productos;

    public ClickAgregarVariosAlCarrito(Target productos) {
        this.productos = productos;
    }

    public static ClickAgregarVariosAlCarrito productos(Target productos){
        return new ClickAgregarVariosAlCarrito(productos);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        productos = CANTIDAD_PRODUCTOS_CARRITO;
        ListOfWebElementFacades deletes = this.productos.resolveAllFor(actor);
        Integer cantidadElementos = deletes.size();

        if(cantidadElementos != 0)
        {
            for (int i = 0; i < cantidadElementos; i++){
                actor.attemptsTo(Click.on(LINK_PRIMER_DELETE_PRODUCTOS_CARRITO));
                WaitUntil.the(LINK_PRIMER_DELETE_PRODUCTOS_CARRITO, isVisible()).forNoMoreThan(Duration.ofSeconds(6));
            }
        }
    }
}
