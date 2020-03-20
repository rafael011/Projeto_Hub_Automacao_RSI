package br.com.rsi.hub3.automacao.tdd.testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import br.com.rsi.hub3.automacao.tdd.pageobject.*;

import static org.junit.Assert.assertEquals;

public class TesteConsultaLupa {
	
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
	public void TesteConsultaLupaPositivo() throws InterruptedException {
		new PO_ConsultaLupa(driver).PesquisarProtudoLupaComSucesso();
		
		WebElement validacao = driver.findElement(By.xpath("//a[@class='select ng-binding']"));
		assertEquals("HP CHROMEBOOK 14 G1(ENERGY STAR)", validacao.getText());
	}
	
	@Test
	public void TesteConsultaLupaNegativo() throws InterruptedException {
		new PO_ConsultaLupa(driver).PesquisarProtudoLupaSemSucesso();
		
		WebElement validacao = driver.findElement(By.xpath("//span[@class='ng-binding']"));
		assertEquals("No results for \"DELL\"", validacao.getText());
	}
	

}
