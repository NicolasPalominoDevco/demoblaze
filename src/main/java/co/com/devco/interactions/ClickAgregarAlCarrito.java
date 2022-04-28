package co.com.devco.interactions;

import co.com.devco.tasks.IngresarAlHome;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static co.com.devco.userinterfaces.DemoblazeDetalleProductoPage.BOTON_AGREGAR_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_CARRITO;
import static co.com.devco.userinterfaces.DemoblazeProductosPage.LINK_PRODUCTO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ClickAgregarAlCarrito implements Interaction {
    private int cantidad;
    private String producto;

    public static WebDriver miNavegador;
    public static WebDriverWait wait = new WebDriverWait(miNavegador,Duration.ofSeconds(6));

    public ClickAgregarAlCarrito(String cantidad, String producto) {
        this.cantidad = Integer.parseInt(cantidad);
        this.producto = producto;
    }

    public static ClickAgregarAlCarrito laSiguienteCantidad(String cantidad, String producto){
        return new ClickAgregarAlCarrito(cantidad,producto);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        /*INTENTÉ SOLUCIONAR LO DE LA ALERTA, PERO ME FALTÓ MAS TIEMPO PARA INVESTIGAR. YA CASI LO TENGO*/

        //System.out.println("AQUI ENTRA");
        /*if(cantidad > 0)
        {
            for (int i = 0; i < cantidad; i++){
                //WaitUntil.the(LINK_CARRITO, isVisible()).forNoMoreThan(Duration.ofSeconds(6));
                actor.attemptsTo(Click.on(BOTON_AGREGAR_CARRITO));
                wait.until(ExpectedConditions.alertIsPresent());
                miNavegador.switchTo().alert().accept();
            }
        }*/
        if(cantidad > 0)
        {
            for (int i = 0; i < cantidad; i++){
                IngresarAlHome.desdeElIndex();
                Click.on(LINK_PRODUCTO.of(producto));
                Click.on(BOTON_AGREGAR_CARRITO);
            }
        }
    }
}
