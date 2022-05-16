package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import static utils.Utils.driver;
import pageObjects.ListaPage;
import pageObjects.LoginPage;

public class ListaSteps {
	
	ListaPage  lp = new ListaPage(driver);
	LoginPage logp = new LoginPage(driver);

	@Dado("a clicar em nova lista")
	public void aClicarEmNovaLista() {
		lp.criarNovaLista();
	}

	@Dado("preencher o campo nome da lista com o valor {string}")
	public void preencherOCampoNomeDaListaComOValor(String texto) {
		lp.inserirONomeDaLista(texto);
	}

	@Dado("escolher primeira cor")
	public void escolherPrimeiraCor() {
		lp.criarNoBotaoCor();
	}

	@Quando("clicar no botao Criar Lista")
	public void clicarNoBotaoCriarLista() {
		lp.criarNoBotaoCriarLista();
	}

	@Entao("a nova lista e criada")
	public void aNovaListaECriada() {
		lp.validarCriacaoDeLista();
	}
	
	@Dado("clicar no botao cancelar")
	public void clicarNoBotaoCancelar() {
		lp.criarNoBotaoCancelar();
	}	

	@Entao("o app retorna para a tela principal")
	public void oAppRetornaParaATelaPrincipal() throws Exception {
		logp.validarLogin("To Do user");  
	}
}
