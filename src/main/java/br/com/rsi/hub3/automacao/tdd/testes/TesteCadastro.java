package br.com.rsi.hub3.automacao.tdd.testes;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import br.com.rsi.hub3.automacao.tdd.inicializacao.DriverFactory;
import br.com.rsi.hub3.automacao.tdd.pageobject.*;

public class TesteCadastro {
	private WebDriver driver;
	private DriverFactory in = new DriverFactory();
	
	@BeforeMethod
	public void inicializar() {
		driver = in.inicializarNavegador();
	}

	@AfterMethod
	public void finalizar() throws InterruptedException {
		in.Esperar("2000");
		driver = in.fecharNavegador();
	}

	@Test
	public void TesteCadastroPositivo() throws InterruptedException {
		PageObjectCadastro cadastro = new PageObjectCadastro(driver);
		cadastro.clicarBotaoAcessoUsuarios();
		cadastro.clicarBotaoCriarConta();
		cadastro.preencherUsuario("rafael16");
		cadastro.preencherEmail("rgc.test16@gmail.com");
		cadastro.preencherSenha("Rafa123");
		cadastro.preencherConfirmacaoSenha("Rafa123");
		cadastro.preencherNome("Rafael");
		cadastro.preencherSobrenome("Gomes");
		cadastro.preencherTelefone("11999990000");
		cadastro.selecionarPais("Brazil");
		cadastro.preencherCidade("Sao Paulo");
		cadastro.preencherEndereco("Rua Abcde, N 20");
		cadastro.preencherEstado("SP");
		cadastro.preencherCep("08455000");
		cadastro.clicarOpcaoAceitarTermos();
		cadastro.clicarBotaoRegistrar();
		
		assertEquals("rafael16", cadastro.validacao());
	}

	@Test
	public void TesteCadastroNegativo() throws InterruptedException {
		PageObjectCadastro cadastro = new PageObjectCadastro(driver);
		cadastro.clicarBotaoAcessoUsuarios();
		cadastro.clicarBotaoCriarConta();
		cadastro.preencherUsuario("rafael05");
		cadastro.preencherEmail("rgc.teste1@gmail.com");
		cadastro.preencherSenha("Rafa123");
		cadastro.preencherConfirmacaoSenha("Rafa123");
		cadastro.preencherNome("Rafael");
		cadastro.preencherSobrenome("Gomes");
		cadastro.preencherTelefone("11999990000");
		cadastro.selecionarPais("Brazil");
		cadastro.preencherCidade("Sao Paulo");
		cadastro.preencherEndereco("Rua Abcde, N 20");
		cadastro.preencherEstado("SP");
		cadastro.preencherCep("08455000");
		cadastro.clicarOpcaoAceitarTermos();
		cadastro.clicarBotaoRegistrar();

		assertEquals("User name already exists", cadastro.validacaoMensagemErro());
	}
	
}
