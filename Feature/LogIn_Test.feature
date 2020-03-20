Feature: Login Action

Scenario: Successful Login with Valid Credentials
	Given Usuario esta na Home Page
	When Usuario navega ate a pagina de Login
	And o usuario entra com seu nomeDeUsuario e senha
	Then E exibida  a mensgaem Login com sucesso

Scenario: Successful LogOut
	When o usuario fazer o Logout do aplicativo
	Then E exibida a mensgaem Logout com sucesso
	
	
	
	
	