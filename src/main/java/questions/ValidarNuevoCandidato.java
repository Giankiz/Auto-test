package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static userinterface.PaginaPerfilCandidato.*;



public class ValidarNuevoCandidato implements Question{
    public static ValidarNuevoCandidato validar_candidato (){

        return new ValidarNuevoCandidato ();

    }


    @Override
    public  Object answeredBy(Actor actor) {

        return actor.asksFor(Text.of(V_FIRST_NAME));
    }
}
