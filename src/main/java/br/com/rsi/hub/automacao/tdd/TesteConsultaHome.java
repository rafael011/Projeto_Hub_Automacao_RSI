package br.com.rsi.hub.automacao.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TesteConsultaHome {
private WebDriver driver;	
	
	@Before
	public void inicializar() {
		PO_Web in = new PO_Web();
		driver = in.inicializarNavegador();
	}
	@After
	public void finalizar() {
		driver.quit();
	}
	
	@Test
	public void TesteConsultaHomePositivo() {
		new PO_ConsultaHome(driver).PesquisaHomeComSucesso();
		
		WebElement validacao = driver.findElement(By.xpath("//h1[@class='roboto-bold ng-binding']"));
		assertEquals("TRAVEL CONFIDENTLY AND IN STYLE", validacao.getText());
	}

}
