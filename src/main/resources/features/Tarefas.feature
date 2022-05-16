#language: pt
#enconding: UTF-8

@tarefas  @todosCenarios 
Funcionalidade: Tarefas

  Contexto: 
    Dado que o usuario esteja na tela principal do app

  @CE003_IncluirTarefa @cenarioComCadastro @signoutTask
  Cenario: CE003 - FP - Tarefas - Incluir tarefa
    E acessar o menu tarefas
    E clicar no botao adicionar tarefa
    Quando inserir o nome da tarefa "nova tarefa Grazieli"
    E clicar no botao salvar
    Entao o app deve criar a tarefa "nova tarefa Grazieli" e exibi-la na lista de tarefas

	@CE004_EditarTarefa @cenarioComCadastro @signoutTask
  Esquema do Cenario: CE004 - FP - Tarefas - Editar tarefa
    E acessar o menu tarefas
    E abrir a tarefa "<tarefa>" para edicao
    Quando inserir um comentario "<comentario>"
    E clicar no botao voltar
    Entao o app deve atualizar a tarefa "<tarefa>" e exibi-la na tela de tarefas

    Exemplos: 
      | tarefa               | comentario                  |
      | nova tarefa Grazieli | teste automatizado Grazieli |

	@CE005_EditarTarefaAdicionarNovaStep @cenarioComCadastro @signoutEditTask
  Esquema do Cenario: CE005 - FA - Tarefas - Adcionar nova step
    E acessar o menu tarefas
    E abrir a tarefa "<tarefa>" para edicao
    E clicar em Add step
    Quando preencher o campo Add step com o valor "<step>"
    E clicar no botao voltar
    E abrir a tarefa "<tarefa>" para edicao
    Entao o app deve atualizar a tarefa "<step>" e exibi-la na tela de tarefas

    Exemplos: 
      | tarefa               | step               |
      | nova tarefa Grazieli | pausa para o café  |
      
	@CE006_ExcluirStep @cenarioComCadastro @signoutEditTask
  Esquema do Cenario: CE006 - FA - Tarefas - Excluir Step
    E acessar o menu tarefas
    E abrir a tarefa "<tarefa>" para edicao    
    E clicar em Add step
    Quando clicar no botao excluir da step "<step>"
    E confirmar a exclusao
    Entao a step e excluida
        
    Exemplos: 
      | tarefa               | step               |
      | nova tarefa Grazieli | pausa para o café  |      

	@CE007_AdicionarTarefaParaOMeuDia @cenarioComCadastro @signoutEditTask
  Esquema do Cenario: CE007 - FA - Tarefas - Adicionar tarefa para o meu dia
    E acessar o menu tarefas
    Quando abrir a tarefa "<tarefa>" para edicao   
    E clicar em Add To My Day
    Entao a tarefa e adicionada ao meu dia

    Exemplos: 
      | tarefa               |
      | nova tarefa Grazieli |

	@CE008_PesquisarTarefas @cenarioComCadastro @signoutLogin
  Esquema do Cenario: CE008 - FA - Tarefas - Pesquisar Tarefas
	  E clicar no botao pesquisar
	  Quando pesquisar pela tarefa "<tarefa>"
    Entao o app deve criar a tarefa "<tarefa>" e exibi-la na lista de tarefas
    E clicar no botao voltar da pesquisa

    Exemplos: 
      | tarefa               |
      | nova tarefa Grazieli |
 
	@CE009_TarefaNaoEncontrada @cenarioComCadastro @signoutLogin
  Esquema do Cenario: CE009 - FP - Tarefas - Tarefa não encontrada
	  E clicar no botao pesquisar
	  Quando pesquisar pela tarefa "<tarefa>"
    Entao e exibindo a mensagem "<mensagem>"
    E clicar no botao voltar da pesquisa

    Exemplos: 
      | tarefa        | mensagem																														  |
      | 111111111111  | We searched high and low but couldn’t find what you’re looking for.   |

	@CE010_ExcluirTarefa @cenarioComCadastro @signoutTask
  Esquema do Cenario: CE010 - FP - Tarefas - Excluir Tarefa
    E acessar o menu tarefas
    Quando ele abrir a tarefa "<taskname>" para exclusao
    E clicar no botao excluir
    E clicar no botao excluir para confirmar a exclusao
    Entao o sistema deve excluir a tarefa selecionada

    Exemplos: 
      | taskname             |
      | nova tarefa Grazieli |
          