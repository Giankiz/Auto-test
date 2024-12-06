package userinterface;

import net.serenitybdd.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
public class PaginaIniciarSesion extends PageObject {
    public static By NOMBRE_DE_USUARIO = By.name("username");
    public static By CONTRASEÑA = By.name("password");
    public static By BOTON_INICIO_DE_SESION = By.xpath("//div/form/div/button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");

}
