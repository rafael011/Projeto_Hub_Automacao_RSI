package br.com.rsi.hub3.automacao.tdd.testes;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsi.hub3.automacao.tdd.inicializacao.DriverFactory;
import br.com.rsi.hub3.automacao.tdd.pageobject.*;
import br.com.rsi.hub3.automacao.tdd.reports.ReportConfig;

public class TesteCadastro {
	private WebDriver driver;
	private DriverFactory in = new DriverFactory();
	private ExtentTest teste;
	private String nomeTeste;
	
	@BeforeSuite
	public void iniciarReport() {
		ReportConfig.iniciarReport("Cadastro");
	}
	
	@BeforeMethod
	public void inicializar() {
		driver = in.inicializarNavegador();
	}

	@AfterMethod
	public void finalizar(ITestResult result) throws IOException {
		teste = ReportConfig.criarTeste(nomeTeste);
		ReportConfig.realtorioReport(teste, result, driver);
		in.Esperar("2000");
		driver = in.fecharNavegador();
	}
	
	@AfterSuite
	public void finalizarReport() {
		ReportConfig.encerrarReport();
	}

	@Test
	public void TesteCadastroPositivo() throws InterruptedException {
		nomeTeste = "Cenario de Teste Positivo";
		PageObjectCadastro cadastro = new PageObjectCadastro(driver);
		cadastro.clicarBotaoAcessoUsuarios();
		cadastro.clicarBotaoCriarConta();
		cadastro.preencherUsuario("rafael19");
		cadastro.preencherEmail("rgc.test19@gmail.com");
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
		
		assertEquals("rafael19", cadastro.validacao());
	}

	@Test
	public void TesteCadastroNegativo() throws InterruptedException {
		nomeTeste = "Cenario de Teste Negativo";
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
