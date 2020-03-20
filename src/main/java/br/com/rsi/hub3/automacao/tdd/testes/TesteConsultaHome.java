package br.com.rsi.hub3.automacao.tdd.testes;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import br.com.rsi.hub3.automacao.tdd.pageobject.*;

public class TesteConsultaHome {
private WebDriver driver;	
	
	@Before
	public void inicializar() {
		PO_InicializacaoWeb in = new PO_InicializacaoWeb();
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
