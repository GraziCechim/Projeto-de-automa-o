package pageObjects;

import static org.junit.Assert.assertTrue;
import static utils.Utils.driver;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ListaPage {

	public ListaPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	BasePage bp = new BasePage(driver);
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Email or phone number']")
	private MobileElement campoEmail;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Sign in']")
	private MobileElement botaoSignIn;
	
	@AndroidFindBy(id = "com.microsoft.todos:id/create_list_text_view")
	private MobileElement botaoNovaLista;
	
	@AndroidFindBy(id = "com.microsoft.todos:id/edit_text")
	private MobileElement campoNomeLista;
	
	@AndroidFindBy(id = "com.microsoft.todos:id/colors_button")
	private MobileElement botaoCor;
	
	@AndroidFindBy(id = "com.microsoft.todos:id/photos_button")
	private MobileElement botaoFoto;
	
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement botaoCriarLista;
	
	@AndroidFindBy(id = "android:id/button2")
	private MobileElement botaoCancelar;
	
	@AndroidFindBy(id = "com.microsoft.todos:id/collapsing_toolbar")
	private MobileElement labelDeCriacaoDaLista;
	
	
	public void validarCriacaoDeLista() {
		assertTrue(labelDeCriacaoDaLista.isEnabled());
	}
	
	public void criarNoBotaoCriarLista() {
		bp.clicarNo(botaoCriarLista);
	}
	
	public void criarNoBotaoCancelar() {
		bp.clicarNo(botaoCancelar);
	}
	
	
	public void criarNoBotaoFoto() {
		bp.clicarNo(botaoFoto);
	}
	
	public void criarNoBotaoCor() {
		bp.clicarNo(botaoCor);
	}
	
	public void inserirONomeDaLista(String texto) {
		bp.escreverNo(campoNomeLista, texto);
	}
	
	public void criarNovaLista() {
		bp.clicarNo(botaoNovaLista);
	}
	

}
