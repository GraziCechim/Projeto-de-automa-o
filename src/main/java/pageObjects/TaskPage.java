package pageObjects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utils.Utils.*;

import java.util.NoSuchElementException;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TaskPage {

	public TaskPage(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	BasePage bp = new BasePage(driver);

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Tasks']")
	private MobileElement botaoTarefas;

	@AndroidFindBy(id = "com.microsoft.todos:id/new_todo_fab")
	private MobileElement botaoNewToDo;

	@AndroidFindBy(id = "com.microsoft.todos:id/create_task_edit_text")
	private MobileElement campoAddATask;

	@AndroidFindBy(id = "com.microsoft.todos:id/create_task_image_button")
	private MobileElement botaoCreateTask;

	@AndroidFindBy(id = "com.microsoft.todos:id/note_card")
	private MobileElement campoNoteCard;

	@AndroidFindBy(id = "com.microsoft.todos:id/note")
	private MobileElement campoNote;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Repeat']")
	private MobileElement botaoRepeat;

	@AndroidFindBy(id = "com.microsoft.todos:id/back")
	private MobileElement botaoBack;

	@AndroidFindBy(id = "com.microsoft.todos:id/delete")
	private MobileElement botaoIconDelete;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement botaoDelete;

	@AndroidFindBy(id = "com.microsoft.todos:id/add_step_title")
	private MobileElement botaoAddNovaStep;

	@AndroidFindBy(id = "com.microsoft.todos:id/add_step_title_edit")
	private MobileElement campoAddNovaStep;

	@AndroidFindBy(id = "com.microsoft.todos:id/remove_step_icon")
	private MobileElement botaoRemoverStep;

	@AndroidFindBy(id = "android:id/button1")
	private MobileElement botaoConfirmarDelecao;

	@AndroidFindBy(id = "com.microsoft.todos:id/my_day_row")
	private MobileElement botaoAddToMyDay;

	@AndroidFindBy(id = "com.microsoft.todos:id/remove_my_day_icon")
	private MobileElement botaoRemoveMyDayIcon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Planned']")
	private MobileElement botaoMenuPlanned;

	@AndroidFindBy(id = "com.microsoft.todos:id/search_icon")
	private MobileElement botaoPesquisar;

	@AndroidFindBy(id = "com.microsoft.todos:id/search_src_text")
	private MobileElement campoPesquisar;

	@AndroidFindBy(id = "com.microsoft.todos:id/task_content")
	private MobileElement tarefaEncontrada;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Exit search']")
	private MobileElement botaoVoltarPesquisa;

	@AndroidFindBy(id = "com.microsoft.todos:id/empty_state_text")
	private MobileElement textoEstadoVazio;

	public void validarElementoMensagemPesquisaNaoEncontrada() {
		assertTrue(textoEstadoVazio.isEnabled());
	}

	public void clicarNoBotaoVoltarPesquisa() {
		bp.clicarNo(botaoVoltarPesquisa);
	}

	public void validarPesquisaTarefa() {
		assertTrue(tarefaEncontrada.isEnabled());
	}

	public void escreverNoCampoPesquisar(String texto) {
		bp.escreverNo(campoPesquisar, texto);
	}

	public void clicarNoBotaoPesquisar() {
		bp.clicarNo(botaoPesquisar);
	}

	public void clicarNoMenuPlanejado() {
		bp.clicarNo(botaoMenuPlanned);
	}

	public void validarAddedToMyDay() {
		assertTrue(botaoRemoveMyDayIcon.isEnabled());
	}

	public void clicarEmRemoveAddToMyDay() {
		bp.clicarNo(botaoRemoveMyDayIcon);
	}

	public void clicarEmAddToMyDay() {
		bp.clicarNo(botaoAddToMyDay);
	}

	public void confirmarDelecaoStep() {
		bp.clicarNo(botaoConfirmarDelecao);
	}

	public void clicarBotaoRemoverStep() {
		bp.clicarNo(botaoRemoverStep);
	}

	public void prencherCampoAddStep(String texto) {
		bp.escreverNo(campoAddNovaStep, texto);
	}

	public void clicarEmAddStep() {
		bp.clicarNo(botaoAddNovaStep);
	}

	public void acessarMenuTarefas() throws Exception {
		botaoTarefas.click();
	}

	public void acionarBotaoNewToDo() throws Exception {
		botaoNewToDo.click();
	}

	public void informarTaskName(String taskName) throws Exception {
		campoAddATask.sendKeys(taskName);
	}

	public void acionarBotaoCreateTask() throws Exception {
		botaoCreateTask.click();
	}

	public void validarTarefa(String terefa) throws Exception {
		MobileElement info = (MobileElement) driver
				.findElement(MobileBy.xpath("//android.widget.TextView[@text='" + terefa + "']"));
		assertEquals(terefa, info.getText());
	}

	public void validarExclusaoTarefa() throws NoSuchElementException {
		assertTrue(botaoAddNovaStep.isEnabled());
	}

	public void selecionarTarefaParaEdicao(String taskName) throws Exception {
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='" + taskName + "']")).click();
	}

	public void informarCampoNoteCard(String noteCard) throws Exception {
		campoNoteCard.clear();
		bp.clicarNo(campoNoteCard);
		bp.escreverNo(campoNote, noteCard);
		esperar(2);
		bp.clicarNo(botaoBack);
		esperar(2);
	}

	public void selecionarRepeatOption(String repeat) throws Exception {
		botaoRepeat.click();
		Thread.sleep(2000);
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='" + repeat + "']")).click();
		Thread.sleep(2000);
	}

	public void acionarBotaoVoltar() throws Exception {
		botaoBack.click();
	}

	public void selecionarTarefaParaExclusao(String taskName) throws Exception {
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text='" + taskName + "']")).click();
	}

	public void acionarBotaoIconDelete() throws Exception {
		botaoIconDelete.click();
	}

	public void acionarBotaoDelete() throws Exception {
		botaoDelete.click();
	}

	public void validarDelecaoTarefa() throws Exception {
		assertEquals(true, driver.findElement(MobileBy.id("com.microsoft.todos:id/new_todo_fab")).isEnabled());
	}
}
