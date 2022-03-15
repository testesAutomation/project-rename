package pages;

import org.openqa.selenium.By;
import utils.GeralPage;

import static config.Urls.HML_URL_BASE;
import static utils.DriverHelper.resetDriver;

public class LoginPage extends GeralPage {


    private By lbl_menu = By.cssSelector("div.left-side > button");
    private By btn_concordar_termos = By.id("agree-18");
    private By btn_acessar = By.xpath("//span[contains(.,'ACESSAR')]");
    private By btn_acompanhante = By.cssSelector("#modal-login > div > div > div.modal-body > a:nth-child(1)");
    private By txt_telefone = By.name("phone_email");
    private By txt_senha = By.name("password");
    private By btn_entrar = By.xpath("//button[contains(.,'Entrar')]");
    private By lbl_estou_online = By.xpath("//span[contains(.,'Você está online agora')]");
    private By lbl_usuario_invalido = By.xpath("//div[contains(text(),'Não foi possível realizar o login.')]");
    private By btn_manter_conectado = By.id("remember");


    public void desmarcarOpcaoManterMeConectado(){
        clickAndHighlight(btn_manter_conectado);
    }
    public void validarAcessoSite(){
        expectElementVisible(lbl_estou_online);
    }

    public void validarMensagemUsuarioInvalido(){
        expectElementVisible(lbl_usuario_invalido);
    }


    public void acessarSite(){
        resetDriver(HML_URL_BASE);
    }

    public void efetuarLoginComoAcompanhante(String telefone, String senha) {
        clickAndHighlight(btn_concordar_termos);
        clickAndHighlight(lbl_menu);
        clickAndHighlight(btn_acessar);
        clickAndHighlight(btn_acompanhante);
        sendKeys(txt_telefone,telefone);
        sendKeys(txt_senha,senha);

    }

    public void clicarEntrar(){
        clickAndHighlight(btn_entrar);
    }



}
