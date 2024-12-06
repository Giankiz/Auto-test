package userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaPrincipal extends PageObject {
    public static Target MODULO_RECLUTAMIENTO = Target.the("MODULO_RECLUTAMIENTO").located(By.xpath("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']"));
    public static Target AÑADIR_CANDIDATO = Target.the("AÑADIR_CANDIDATO").located(By.xpath("//div/button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
}
