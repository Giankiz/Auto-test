package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaPerfilCandidato extends PageObject {
    public static Target SL_BTN = Target.the("SL_BTN").located(By.xpath("//div/button[@class='oxd-button oxd-button--medium oxd-button--success']"));
    public static By V_FIRST_NAME = By.xpath("//div/p[@class='oxd-text oxd-text--p']");

}
