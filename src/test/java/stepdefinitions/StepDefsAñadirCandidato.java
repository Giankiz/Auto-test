package stepdefinitions;

import questions.ValidarNuevoCandidato;
import tasks.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import java.util.List;
import java.util.Map;

public class StepDefsAñadirCandidato {

    @Before
    public void IniciarEscenario() {OnStage.setTheStage(new OnlineCast());}

    @Dado("que el usuario acceda a la pagina orangehrmlive.com")
    public void abrirPaginaOrangeHRM() {OnStage.theActorCalled("actor").wasAbleTo(AbrirPagina.urlApp());}

    @Y("utilice el rol administrador para iniciar sesión")
    public void IniciarSesion(DataTable credenciales) {
        List<Map<String, String>> rows = credenciales.asMaps(String.class, String.class);
        Map<String, String> info_usuario = rows.get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(IniciarSesion.IniciodeSesion(info_usuario));

    }
    @Cuando("el usuario ingrese al módulo Recruitment y de click en el boton Add")
    public void IrModuloRecruitment() {
        OnStage.theActorInTheSpotlight().attemptsTo(IrModuloReclutamiento.moduloReclutamiento());

    }
    @Y("complete los campos requeridos y haga click en el botón guardar")
    public void CompletarInformacion(DataTable datosCandidato) {
        List<Map<String, String>> rows = datosCandidato.asMaps(String.class, String.class);
        Map<String, String> info_candidato = rows.get(0);
        OnStage.theActorInTheSpotlight().attemptsTo(LlenarFormulario.Formulario(info_candidato));

    }
    @Entonces("se valida la existencia del nuevo candidato")
    public void ValidarInformacion() {
        OnStage.theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        ValidarNuevoCandidato.validar_candidato(),
                        Matchers.startsWith("Juan")
                )
        );
    }
    }




