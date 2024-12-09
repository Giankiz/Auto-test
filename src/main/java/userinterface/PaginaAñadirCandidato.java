package userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class PaginaAñadirCandidato extends PageObject {
    public static By FIRST_NAME = By.name("firstName");
    public static By MIDDLE_NAME = By.name("middleName");
    public static By LAST_NAME = By.name("lastName");
    public static Target VACANTE = Target.the("VACANTE").located(By.xpath("//div/div[@class='oxd-select-text-input']"));
    public static Target CV = Target.the("CV").located(By.xpath("//div/input[@class='oxd-file-input']"));
    public static Target EMAIL = Target.the("EMAIL").located(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(3) > div > div:nth-child(1) > div > div:nth-child(2) > input"));
    public static Target NUMERO_DE_CONTACTO = Target.the("NUMERO_DE_CONTACTO").located(By.cssSelector("#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > form > div:nth-child(3) > div > div:nth-child(2) > div > div:nth-child(2) > input"));
    public static Target PALABRAS_CLAVE = Target.the("PALABRAS_CLAVE").located(By.xpath("//div/div/input[@placeholder='Enter comma seperated words...']"));
    public static Target NOTAS = Target.the("NOTAS").located(By.xpath("//div/div/textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']"));
    public static Target CHECK_BTN = Target.the("CHECK_BTN").located(By.xpath("//div[@class='oxd-checkbox-wrapper']"));
    public static Target SAVE_BTN = Target.the("SAVE_BTN").located(By.xpath("//div/button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));

}
