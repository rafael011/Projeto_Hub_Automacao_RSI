package br.com.rsi.hub3.automacao.tdd.testes;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import br.com.rsi.hub3.automacao.tdd.inicializacao.InicializacaoWeb;
import br.com.rsi.hub3.automacao.tdd.pageobject.*;

public class TesteConsultaHome {
private WebDriver driver;	
	
	@BeforeMethod
	public void inicializar() {
		InicializacaoWeb in = new InicializacaoWeb();
		driver = in.inicializarNavegador();
	}
	@AfterMethod
	public void finalizar() {
		driver.quit();
	}
	
	@Test
	public void TesteConsultaHomePositivo() {
		new PageObjectConsultaHome(driver).PesquisaHomeComSucesso();
		
		WebElement validacao = driver.findElement(By.xpath("//h1[@class='roboto-bold ng-binding']"));
		assertEquals("TRAVEL CONFIDENTLY AND IN STYLE", validacao.getText());
	}
	
	@Test
	public void TesteConsultaHomeNegativo() {
		Assert.assertFalse(new PageObjectConsultaHome(driver).PesquisaHomeSemSucesso("Smartphone"));
	}

}
