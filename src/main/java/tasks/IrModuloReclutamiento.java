package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static userinterface.PaginaPrincipal.*;



public class IrModuloReclutamiento implements Task {
    public static IrModuloReclutamiento moduloReclutamiento(){

        return Tasks.instrumented(IrModuloReclutamiento.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(MODULO_RECLUTAMIENTO));
        actor.attemptsTo(Click.on(AÑADIR_CANDIDATO));

    }
}
