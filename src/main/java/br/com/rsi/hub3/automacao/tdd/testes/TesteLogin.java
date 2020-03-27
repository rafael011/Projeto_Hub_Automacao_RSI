package br.com.rsi.hub3.automacao.tdd.testes;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
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
import br.com.rsi.hub3.automacao.tdd.massadados.ExcelUtils;
import br.com.rsi.hub3.automacao.tdd.massadados.MassaDeDados;
import br.com.rsi.hub3.automacao.tdd.pageobject.PageObjectLogin;
import br.com.rsi.hub3.automacao.tdd.reports.ReportConfig;

public class TesteLogin {
	private WebDriver driver;
	private ExtentTest teste;
	private String nomeTeste;
	private MassaDeDados excel;
	private DriverFactory in = new DriverFactory();
	
	
	@BeforeSuite
	public void iniciarReport() {
		//setando o reporte 
		ReportConfig.iniciarReport("Login");
	}
	
	@BeforeMethod
	public void inicializar() throws Exception {
		driver = in.inicializarNavegador();
		excel = new MassaDeDados();
	}
	@AfterMethod
	public void finalizar(ITestResult result) throws IOException{
		teste = ReportConfig.criarTeste(nomeTeste);
		ReportConfig.realtorioReport(teste, result, driver);
		driver = in.fecharNavegador();
	}
	
	@AfterSuite
	public void finalizarReport() {
		ReportConfig.encerrarReport();
	}

	
	@Test
	public void TesteLoginPositivo() throws Exception{
		nomeTeste = "Cenario de Teste Positivo";

		PageObjectLogin login = new PageObjectLogin(driver);
		login.clicarBotaoAcessoUsuarios();
		login.preencherLoginComExcel(excel.getUsuario());
		login.preencherSenhaComExcel(excel.getSenha());
		login.clicarBotaoLogin();		
		assertEquals("rafael14", login.validacaoLogin());
	}
	
	@Test
	public void TesteLoginNegativo() throws Exception{
		nomeTeste = "Cenario de Teste Negativo";
		PageObjectLogin login = new PageObjectLogin(driver);
		login.clicarBotaoAcessoUsuarios();
		login.preencherLoginComExcel(excel.getUsuarioInvalido());
		login.preencherSenhaComExcel(excel.getSenhaInvalida());
		login.clicarBotaoLogin();
		assertEquals("Incorrect user name or password.", login.validacaoMensagemErro());
	}

}
