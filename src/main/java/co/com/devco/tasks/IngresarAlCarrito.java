package co.com.devco.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static co.com.devco.userinterfaces.DemoblazeIndexPage.LINK_CARRITO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class IngresarAlCarrito implements Task {
    public static Performable desdeElIndex() {
        return instrumented(IngresarAlCarrito.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LINK_CARRITO, isEnabled()).forNoMoreThan(Duration.ofSeconds(6)),
                Click.on(LINK_CARRITO)
        );
    }
}
