package steps;

import static utils.Utils.driver;


import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjects.LoginPage;

public class LoginSteps {

	LoginPage lp = new LoginPage(driver);

	@Dado("que o usuario esteja logado")
	public void queOUsuarioEstejaLogago() throws Exception {
		lp.validarLogin("To Do user");
	}

	@Quando("inserir o email {string}")
	public void oUsuarioInserirOEmail(String email) throws Exception {
		try {
			lp.usarUmaContaDiferente();
		} catch (Exception e) {
			System.out.println("link não encotrado");
		}
		lp.preencherCampoEmail(email);
	}

	@Quando("clicar no botao Sign in")
	public void clicarNoBotaoSignIn() throws Exception {
		lp.acionarBotaoSignIn();
	}

	@Quando("inserir a senha {string}")
	public void inserirASenha(String password) throws Exception {
		lp.preencherCampoPassword(password);
	}

	@Quando("clicar no botao sign in novamente")
	public void clicarNoBotaoSignInNovamente() throws Exception {
		lp.acionarBotaoSignIn();
	}

	@Entao("e realizado o login exibindo a mensagem {string}")
	public void eRealizadoOLoginExibindoAMensagem(String texto) throws Exception {
		lp.validarLogin(texto);
	}
	
	@Entao("e solicitado o login com uma conta microsoft ou criacao de uma nova, emitindo a mensagem {string}")
	public void novaContaMicroSoft(String texto) throws Exception {
		lp.validarSugestaoDeCriacaoDeNovaConta(texto);
	}
	
	
	

}
