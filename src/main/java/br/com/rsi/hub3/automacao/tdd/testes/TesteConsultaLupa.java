package br.com.rsi.hub3.automacao.tdd.testes;

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
import br.com.rsi.hub3.automacao.tdd.pageobject.*;
import br.com.rsi.hub3.automacao.tdd.reports.ReportConfig;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

public class TesteConsultaLupa {
	
	private WebDriver driver;	
	private DriverFactory in = new DriverFactory();
	private ExtentTest teste;
	private String nomeTeste;
	
	@BeforeSuite
	public void iniciarReport() {
		ReportConfig.iniciarReport("ConsultaLupa");
	}
	
	@BeforeMethod
	public void inicializar() {
		driver = in.inicializarNavegador();
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
	public void TesteConsultaLupaPositivo() throws InterruptedException {
		nomeTeste = "Cenario de Teste Positivo";
		PageObjectConsultaLupa lupa = new PageObjectConsultaLupa(driver);
		lupa.clicarBotaoLupa();
		lupa.preencherPesquisaLupa("HP CHROMEBOOK 14 G1(ENERGY STAR)");
		lupa.clicarProdutoPesquisaLupa();
		
		assertEquals("HP CHROMEBOOK 14 G1(ENERGY STAR)", lupa.validacao());
	}
	
	@Test
	public void TesteConsultaLupaNegativo() throws InterruptedException {
		nomeTeste = "Cenario de Teste Negativo";
		PageObjectConsultaLupa lupa = new PageObjectConsultaLupa(driver);
		lupa.clicarBotaoLupa();
		lupa.preencherPesquisaLupa("DELL");
		lupa.clicarBotaoLupa();
		lupa.clicarFecharLupa();
		
		assertEquals("No results for \"DELL\"", lupa.validacaoPesquisaInvalida());
	}
	

}
