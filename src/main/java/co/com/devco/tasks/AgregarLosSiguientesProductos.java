package co.com.devco.tasks;

import co.com.devco.interactions.ClickAgregarAlCarrito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.devco.userinterfaces.DemoblazeDetalleProductoPage.BOTON_AGREGAR_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeProductosPage.LINK_PRODUCTO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class AgregarLosSiguientesProductos implements Task {
    private String producto;
    private String cantidad;

    public AgregarLosSiguientesProductos(String cantidad, String producto) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public static Performable alCarrito(String cantidad,String producto) {
        return instrumented(AgregarLosSiguientesProductos.class, cantidad,producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LINK_PRODUCTO.of(producto)),
                ClickAgregarAlCarrito.laSiguienteCantidad(cantidad,producto),
                IngresarAlCarrito.desdeElIndex()
        );
    }
}
