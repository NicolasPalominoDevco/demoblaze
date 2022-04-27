package co.com.devco.stepdefinitions;

import co.com.devco.tasks.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.devco.userinterfaces.DemoblazeCarritoPage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DemoblazeCarritoStepDefinitions {

// Primer escenario
    @Dado("que {string} se loguea como {string}")
    public void loguin(String actor, String rol) {
        theActorCalled(actor).attemptsTo(
                Abrir.laPagina(),
                Loguearse.como(rol),
                LimpiarCarrito.completamente()
        );
    }

    @Cuando("agrega el {string} al carrito vacio")
    public void agregarObjetoAlCarrito(String producto) {
        theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.elProducto(producto)
        );
    }
    @Entonces("debe ver como unico elemento el {string}")
    public void verificarObjetoCarrito(String producto) {
        theActorInTheSpotlight().attemptsTo(
                Ensure.that(CANTIDAD_PRODUCTOS_CARRITO).values().hasSize(1),
                //Ensure.that(TITULO_PRODUCTO_CARRITO.of(producto)).isEnabled(),
                Ensure.that(TITULO_PRODUCTO_CARRITO.of(producto)).hasText(producto)
        );
    }

//-------------------------------------------------------------------------------
// Segundo escenario
    @Cuando("{string} agrega el {string} al carrito vacio")
    public void agregarObjetoAlCarritoConActor(String actor,String producto) {
        theActorCalled(actor).attemptsTo(
                Abrir.laPagina(),
                LimpiarCarrito.completamente(),
                AgregarAlCarrito.elProducto(producto)
        );
    }

/*
//-------------------------------------------------------------------------------
// Tercer escenario
    @Dado("{string} agrega {string} y {string} al carrito vacio")
    public void agregarDosObjetosAlCarrito(String actor, String producto1, String producto2) {
    theActorCalled(actor).attemptsTo(
            LimpiarCarrito.completamente(),
            AgregarAlCarrito.elProducto(producto1),
            AgregarAlCarrito.elProducto(producto2)
        );
    }

    @Cuando("elimina el {string}")
    public void eliminarObjetoAlCarrito(String producto) {
        theActorInTheSpotlight().attemptsTo(
                EliminarDelCarrito.elProducto(producto)
        );
    }

 */
}
