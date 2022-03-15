package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.LoginPage;

import static utils.DriverHelper.closeDriverWeb;

public class FatalModelSteps {

    LoginPage loginPage = new LoginPage();
    @Dado("que o usuário navega até o site da fatalmodels")
    public void queOUsuárioNavegaAtéOSiteDaFatalmodels() {
        loginPage.acessarSite();
    }

    @Quando("o usuário faz login como ‘acompanhante' usando telefone {string} e senha {string}")
    public void oUsuárioFazLoginComoAcompanhanteUsandoTelefoneESenha(String telefone, String senha) {
        loginPage.efetuarLoginComoAcompanhante(telefone, senha);
    }

    @Então("o login deve ser bem sucedido")
    public void oLoginDeveSerBemSucedido() {
        loginPage.clicarEntrar();
        loginPage.validarAcessoSite();
    }

    @Então("mensagem de senha incorreta deverá ser  apresentada")
    public void mensagemDeSenhaIncorretaDeveráSerApresentada() {
        loginPage.clicarEntrar();
        loginPage.validarMensagemUsuarioInvalido();
    }

    @E("a caixa 'mantenha-me conectado’ desmarcada")
    public void aCaixaMantenhaMeConectadoDesmarcada() {
        loginPage.desmarcarOpcaoManterMeConectado();
    }
}
