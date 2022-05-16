package steps;

import static utils.Utils.*;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pageObjects.TaskPage;

public class TaskSteps {
	
	TaskPage tp = new TaskPage(driver); 


	@Dado("que o usuario esteja na tela principal do app")
	public void queOUsuarioEstejaNaTelaPrincipalDoApp() throws Exception {

	}

	@Quando("preencher o campo Add step com o valor {string}")
	public void preencherOCampoAddStepComOValor(String texto) {
		tp.prencherCampoAddStep(texto);
	}
	
	@Dado("clicar em Add step")
	public void clicarEmAddStep() {
		tp.clicarEmAddStep();
	}

	
	@Dado("acessar o menu tarefas")
	public void clicarBotaoAddTarefa() throws Exception {    
	    tp.acessarMenuTarefas();  
	}
	

	@Quando("clicar no botao adicionar tarefa")
	public void eleClicarNoBotaoAdicionarTarefa() throws Exception {
	    tp.acionarBotaoNewToDo();
	}

	@Quando("inserir o nome da tarefa {string}")
	public void eleInserirONomeDaTarefa(String taskName) throws Exception {
	    tp.informarTaskName(taskName);
	}

	@Quando("clicar no botao salvar")
	public void eleClicarNoBotaoSalvar() throws Exception {
	    tp.acionarBotaoCreateTask();
	}

	@Entao("o app deve criar a tarefa {string} e exibi-la na lista de tarefas")
	public void oSistemaDeveCriarATarefaEExibiLaNaTelaDeTarefas(String tarefa) throws Exception {
		tp.validarTarefa(tarefa);
	}
	
	@Quando("abrir a tarefa {string} para edicao")
	public void abrirATarefaParaEdicao(String taskName) throws Exception {
		esperar(2);
	    tp.selecionarTarefaParaEdicao(taskName);
	}

	@Quando("inserir um comentario {string}")
	public void inserirUmComentario(String noteCard) throws Exception {
	    tp.informarCampoNoteCard(noteCard);
	}

	@Quando("definir a repeticao {string}")
	public void definirARepeticao(String repeat) throws Exception {
	    tp.selecionarRepeatOption(repeat);
	}

	@Quando("clicar no botao voltar")
	public void clicarNoBotaoVoltar() throws Exception {
	    tp.acionarBotaoVoltar();
	    esperar(2);
	}

	@Entao("o app deve atualizar a tarefa {string} e exibi-la na tela de tarefas")
	public void oAppDeveAtualizarATarefaEExibiLaNaTelaDeTarefas(String tarefa) throws Exception {
		tp.validarTarefa(tarefa);
	}

	@Quando("ele abrir a tarefa {string} para exclusao")
	public void eleAbrirATarefaParaExclusao(String taskName) throws Exception {
	    tp.selecionarTarefaParaExclusao(taskName);
	}
	
	@Quando("clicar no botao excluir")
	public void eleClicarNoBotaoExcluir() throws Exception {
	    tp.acionarBotaoIconDelete();
	}

	@Quando("clicar no botao excluir para confirmar a exclusao")
	public void eleClicarNoBotaoExcluirParaConfirmarAExclusao() throws Exception {
	    tp.acionarBotaoDelete();
	}

	@Entao("o sistema deve excluir a tarefa selecionada")
	public void oSistemaDeveExcluirATarefaSelecionada() throws Exception {
	    tp.validarDelecaoTarefa();
	}
	
	@Quando("clicar no botao excluir da step {string}")
	public void clicarNoBotaoExcluirDaStep(String string) {
		tp.clicarBotaoRemoverStep();
	}

	@Quando("confirmar a exclusao")
	public void confirmarAExclusao() {
		tp.confirmarDelecaoStep();
	}
	
	@Entao("a step e excluida")
	public void aStepEExcluida() throws Exception {
		tp.validarExclusaoTarefa();
	}	
	
	@Dado("clicar em Add To My Day")
	public void clicarEmAddToMyDay() {
		tp.clicarEmAddToMyDay();
	}
	
	@Entao("a tarefa e adicionada ao meu dia")
	public void aTarefaEAdicionadaAoMeuDia() {
		tp.validarAddedToMyDay();
	}
	
	@Entao("clicar no menu Planned")
	public void clicarNoMenuPlanned() {
		tp.clicarNoMenuPlanejado();
	}
	
	@Entao("clicar no botao pesquisar")
	public void clicarNoBotaoPesquisar() {
		tp.clicarNoBotaoPesquisar();
	}
	
	@Dado("pesquisar pela tarefa {string}")
	public void pesquisarPelaTarefa(String texto) {
		tp.escreverNoCampoPesquisar(texto);
	}
	
	@Entao("clicar no botao voltar da pesquisa")
	public void clicarNoBotaoVoltarDaPesquisa() {
		tp.clicarNoBotaoVoltarPesquisa();
	}
	
	
	
	@Entao("e exibindo a mensagem {string}")
	public void eRealizadoOLoginExibindoAMensagem(String texto) throws Exception {
		tp.validarElementoMensagemPesquisaNaoEncontrada();
	}
	
	
}
