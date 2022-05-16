package steps;

import static utils.Utils.acessarApp;
import static utils.Utils.driver;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageObjects.LoginPage;



public class Hooks {
		
	@Before(value = "@cenarioSemCadastro")
	public void setUp1() throws Exception {
		acessarApp();
	}
	
	@Before(value = "@cenarioComCadastro")
	public void setUp() throws Exception {
		acessarApp();
		LoginPage lp = new LoginPage(driver);
		lp.realizarLogin("testemobile@outlook.com.br","Senhatest");
	}

	@Before(value = "@cenarioComCadastroSimples")
	public void setUp4() throws Exception {
		acessarApp();
		LoginPage lp = new LoginPage(driver);
		lp.realizarLoginSimples("testemobile@outlook.com.br","Senhatest");
	}
	
	
	
	@After(value = "@signout")
	public void tearDown0(Scenario cenario) {
		utils.Utils.gerarScreenShot(cenario);
		driver.quit();
	}
	
	@After(value = "@signoutLogin")
	public void tearDown(Scenario cenario) throws Exception {
		LoginPage lp = new LoginPage(driver);
		utils.Utils.gerarScreenShot(cenario);
		lp.signoutLogin();
		driver.quit();
	}
	
	@After(value = "@signoutTask")
	public void tearDown1(Scenario cenario) throws Exception {
		LoginPage lp = new LoginPage(driver);
		utils.Utils.gerarScreenShot(cenario);
		lp.signoutTarefas();
		driver.quit();
	}
	
	@After(value = "@signoutEditTask")
	public void tearDown2(Scenario cenario) throws Exception {
		LoginPage lp = new LoginPage(driver);
		utils.Utils.gerarScreenShot(cenario);
		lp.signoutTarefasEdicao();
		driver.quit();
	}
	
	
}
