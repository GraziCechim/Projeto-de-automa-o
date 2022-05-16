#language: pt
#enconding: UTF-8

@lista  @todosCenarios 
Funcionalidade: Lista

  Contexto: 
    Dado que o usuario esteja na tela principal do app

  @CE011_IncluirNovaLista @cenarioComCadastro @signoutTask
  Cenario: CE011 - FP - Tarefas - Incluir nova Lista
		E a clicar em nova lista
		E preencher o campo nome da lista com o valor "lista da Grazieli"
		E escolher primeira cor
		Quando clicar no botao Criar Lista
		Entao a nova lista e criada
		
  @CE012_CancelarCriacaoDeNovaLista @cenarioComCadastro @signoutLogin
  Cenario: CE012 - FP - Tarefas - Cancelar Criação de nova lista
		E a clicar em nova lista
		Quando clicar no botao cancelar
		Entao o app retorna para a tela principal
