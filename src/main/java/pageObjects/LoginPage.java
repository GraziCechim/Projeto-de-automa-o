package pageObjects;

import static org.junit.Assert.assertTrue;
import static utils.Utils.driver;
import static utils.Utils.esperar;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {

	public LoginPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	BasePage bp = new BasePage(driver);

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Email or phone number']")
	private MobileElement campoEmail;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Sign in']")
	private MobileElement botaoSignIn;

	@AndroidFindBy(xpath = "//android.widget.EditText")
	private MobileElement campoPassword;

	@AndroidFindBy(id = "com.microsoft.todos:id/user_name")
	private MobileElement toDoUser;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement linkUseADiferenteAccount;

	@AndroidFindBy(id = "com.microsoft.todos:id/text") // Manage accounts
	private MobileElement linkManageAccounts;

	@AndroidFindBy(id = "com.microsoft.todos:id/sign_out_button") // SIGN OUT
	private MobileElement linkSignOut;

	@AndroidFindBy(id = "android:id/button1") // YES, SIGN OUT
	private MobileElement buttonYesSignOut;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Back']")
	private MobileElement botaoVoltar;

	@AndroidFindBy(id = "com.microsoft.todos:id/back")
	private MobileElement botaoVoltarEdicao;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='CREATE ONE']")
	private MobileElement alertCreateNewAccount;

	public void realizarLogin(String email, String password) throws Exception {
		try {
			usarUmaContaDiferente();
		} catch (Exception e) {
			System.out.println("link não encotrado");
			signoutLogin();
			try {
				usarUmaContaDiferente();
			} catch (Exception e2) {
				System.out.println("link não encotrado, segunda tentativa");
			}
		}

		preencherCampoEmail(email);
		acionarBotaoSignIn();
		preencherCampoPassword(password);
		acionarBotaoSignIn();
	}

	public void realizarLoginSimples(String email, String password) throws Exception {
		preencherCampoEmail(email);
		acionarBotaoSignIn();
		preencherCampoPassword(password);
		acionarBotaoSignIn();
		esperar(4);
	}

	public void signoutLogin() throws Exception {
		bp.clicarNo(toDoUser);
		bp.clicarNo(linkManageAccounts);
		bp.clicarNo(linkSignOut);
		bp.clicarNo(buttonYesSignOut);
		esperar(4);
	}

	public void signoutTarefas() throws Exception {
		bp.clicarNo(botaoVoltar);
		bp.clicarNo(toDoUser);
		bp.clicarNo(linkManageAccounts);
		bp.clicarNo(linkSignOut);
		bp.clicarNo(buttonYesSignOut);
		esperar(4);
	}

	public void signoutTarefasEdicao() throws Exception {
		bp.clicarNo(botaoVoltarEdicao);
		bp.clicarNo(botaoVoltar);
		bp.clicarNo(toDoUser);
		bp.clicarNo(linkManageAccounts);
		bp.clicarNo(linkSignOut);
		bp.clicarNo(buttonYesSignOut);
		esperar(4);
	}

	public void usarUmaContaDiferente() throws Exception {
		bp.clicarNo(linkUseADiferenteAccount);
	}

	public void preencherCampoEmail(String email) throws Exception {
		bp.escreverNo(campoEmail, email);
	}

	public void acionarBotaoSignIn() throws Exception {
		bp.clicarNo(botaoSignIn);
	}

	public void preencherCampoPassword(String password) throws Exception {
		esperar(3);
		bp.escreverNo(campoPassword, password);
	}

	public void validarLogin(String texto) throws Exception {
		bp.validarMensagem(texto, toDoUser);
	}

	public void validarSugestaoDeCriacaoDeNovaConta(String texto) throws Exception {
		assertTrue(alertCreateNewAccount.isEnabled());
	}
}
