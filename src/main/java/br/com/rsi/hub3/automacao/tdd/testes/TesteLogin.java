package br.com.rsi.hub3.automacao.tdd.testes;

import static org.junit.Assert.assertEquals;
import br.com.rsi.hub3.automacao.tdd.reports.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;

import br.com.rsi.hub3.automacao.tdd.inicializacao.InicializacaoWeb;
import br.com.rsi.hub3.automacao.tdd.pageobject.PageObjectLogin;



public class TesteLogin {
	private WebDriver driver;
	private ExtentTest test;
	
//	@BeforeTest
//	public void setConfigReport() {
//		//setando o reporte 
//		ReportConfig.setReport();
//	}
	
	@Before
	public void inicializar() {
		InicializacaoWeb in = new InicializacaoWeb();
		driver = in.inicializarNavegador();
	}
	@After
	public void finalizar() {
		driver.quit();
	}

	
	@Test
	public void TesteLoginPositivo() throws Exception{
		new PageObjectLogin(driver).LoginComSucesso();
		
		WebElement validacao = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']"));
		assertEquals("rafael05", validacao.getText());
		
		//definindo teste para o report
		//test = ReportConfig.createTest("validarLogin");
	}
	
	@Test
	public void TesteLoginNegativo(){
		new PageObjectLogin(driver).LoginSemSucesso();	 
		new PageObjectLogin(driver).EsperarValidacaoMsgErroLogin();
		
		WebElement validacao = driver.findElement(By.id("signInResultMessage"));
		assertEquals("Incorrect user name or password.", validacao.getText());
	}

}
