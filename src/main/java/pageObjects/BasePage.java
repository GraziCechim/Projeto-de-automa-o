package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.Utils.driver;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {


	public BasePage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clicarNo(MobileElement elemento) {
		elemento.click();	
	}
	
	public void escreverNo(MobileElement elemento, String valor) {
		elemento.sendKeys(valor);	
	}
	
	public void validarMensagem(String valor , MobileElement elemento) {
		assertEquals(valor, elemento.getText());
	}
	
	public void validarElementoNaTela( MobileElement elemento) {
		assertTrue(elemento.isDisplayed());
	}
	
	public void validarMensagemGenerica(String valor) throws Exception {
		MobileElement info = (MobileElement) driver.findElement(MobileBy.xpath("//*[@text='"+valor+"']"));
		
		System.out.println("Infos Tela: " + info.getText());
		assertEquals(valor, info.getText());
	}
	
	public void esperar(int tempo) throws Exception {
		for (int i = 0; i < tempo; i++) {
			Thread.sleep(1000);
		}
	}
	
	public void validarInformacoes(List<String> dados) {
		
		MobileElement infos;
		
		for (String info : dados) {
			
			infos = (MobileElement) driver.findElement(MobileBy.xpath("//*[@text='"+info+"']"));
			System.out.println("Infos Tela: " + infos.getText());
			assertEquals(info, infos.getText());

		}
		
	}
}
