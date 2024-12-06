package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.Map;

import static userinterface.PaginaIniciarSesion.*;


public class IniciarSesion implements Task {

    public static Map<String, String> infousuario;

    public static IniciarSesion IniciodeSesion (Map < String, String > info_usuario){
        infousuario = info_usuario;
        return Tasks.instrumented(IniciarSesion.class,info_usuario );
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(infousuario.get("usuario")).into(NOMBRE_DE_USUARIO),
                Enter.theValue(infousuario.get("contraseña")).into(CONTRASEÑA),
                Click.on(BOTON_INICIO_DE_SESION)
        );

    }
}

