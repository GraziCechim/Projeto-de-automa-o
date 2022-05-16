#language: pt
#enconding: UTF-8

@login @todosCenarios 
Funcionalidade: Login

	@CE001_RealizarLogin @cenarioSemCadastro @signoutLogin
  Cenario: CE001 - FP - Login - Realizar Login 
    E inserir o email "testemobile@outlook.com.br"
    E clicar no botao Sign in
    Quando inserir a senha "Senhatest"
    E clicar no botao sign in novamente
    Entao e realizado o login exibindo a mensagem "To Do user"
    
  @CE002_EntreComUmaNovaConta @cenarioSemCadastro @signout
  Cenario: CE002 - FA - Login - Entre com uma nova conta ou criar uma nova
    E inserir o email "testemobile@outlook.com.br'"
    E clicar no botao Sign in
    Entao e solicitado o login com uma conta microsoft ou criacao de uma nova, emitindo a mensagem "Sign in with Microsoft, or create an account if you don't have one."