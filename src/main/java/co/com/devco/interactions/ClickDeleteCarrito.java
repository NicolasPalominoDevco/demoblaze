package co.com.devco.interactions;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickDeleteCarrito implements Interaction {
    private Target producto;

    public ClickDeleteCarrito(Target producto) {
        this.producto = producto;
    }

    public static ClickDeleteCarrito elProducto(Target producto){
        return new ClickDeleteCarrito(producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        producto = CANTIDAD_PRODUCTOS_CARRITO;
        ListOfWebElementFacades deletes = this.producto.resolveAllFor(actor);
        Integer cantidadElementos = deletes.size();

        if(cantidadElementos != 0)
        {
            for (int i = 0; i < cantidadElementos; i++){
                if (producto.equals(TITULO_PRODUCTO_CARRITO))
                {
                    actor.attemptsTo(Click.on(LINK_PRIMER_DELETE_PRODUCTOS_CARRITO));
                    WaitUntil.the(LINK_PRIMER_DELETE_PRODUCTOS_CARRITO, isVisible()).forNoMoreThan(Duration.ofSeconds(6));
                }
            }
        }
    }
}
