package br.com.rsi.hub3.automacao.tdd.testes;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

public class TesteConsultaHome {
	private WebDriver driver;	
	private DriverFactory in = new DriverFactory();
	private ExtentTest teste;
	private String nomeTeste;
	
	@BeforeSuite
	public void iniciarReport() {
		ReportConfig.iniciarReport("ConsultaHome");
	}
	
	@BeforeMethod
	public void inicializar() {
		driver = in.inicializarNavegador();
	}
	@AfterMethod
	public void finalizar(ITestResult result) throws IOException {
		teste = ReportConfig.criarTeste(nomeTeste);
		ReportConfig.realtorioReport(teste, result, driver);
		driver = in.fecharNavegador();
	}
	
	@AfterSuite
	public void finalizarReport() {
		ReportConfig.encerrarReport();
	}
	
	@Test
	public void TesteConsultaHomePositivo() {
		nomeTeste = "Cenario de Teste Positivo";
		PageObjectConsultaHome tab = new PageObjectConsultaHome(driver);
		tab.clicarBotaoTablets();
		
		assertEquals("TRAVEL CONFIDENTLY AND IN STYLE", tab.validacao());
	}
	
	@Test
	public void TesteConsultaHomeNegativo() {
		nomeTeste = "Cenario de Teste Negativo";
		Assert.assertFalse(new PageObjectConsultaHome(driver).verificarBotaoInexistente("Smartphone"));
	}

}
