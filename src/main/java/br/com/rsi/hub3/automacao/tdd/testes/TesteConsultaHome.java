package br.com.rsi.hub3.automacao.tdd.testes;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import br.com.rsi.hub3.automacao.tdd.inicializacao.DriverFactory;
import br.com.rsi.hub3.automacao.tdd.pageobject.*;

public class TesteConsultaHome {
	private WebDriver driver;	
	private DriverFactory in = new DriverFactory();
	
	@BeforeMethod
	public void inicializar() {
		driver = in.inicializarNavegador();
	}
	@AfterMethod
	public void finalizar() {
		driver = in.fecharNavegador();
	}
	
	@Test
	public void TesteConsultaHomePositivo() {
		PageObjectConsultaHome tab = new PageObjectConsultaHome(driver);
		tab.clicarBotaoTablets();
		
		assertEquals("TRAVEL CONFIDENTLY AND IN STYLE", tab.validacao());
	}
	
	@Test
	public void TesteConsultaHomeNegativo() {
		Assert.assertFalse(new PageObjectConsultaHome(driver).verificarBotaoInexistente("Smartphone"));
	}

}
