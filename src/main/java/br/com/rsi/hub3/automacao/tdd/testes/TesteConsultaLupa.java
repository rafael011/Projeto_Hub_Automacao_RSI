package br.com.rsi.hub3.automacao.tdd.testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import br.com.rsi.hub3.automacao.tdd.inicializacao.InicializacaoWeb;
import br.com.rsi.hub3.automacao.tdd.pageobject.*;
import static org.junit.Assert.assertEquals;

public class TesteConsultaLupa {
	
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
	public void TesteConsultaLupaPositivo() throws InterruptedException {
		new PageObjectConsultaLupa(driver).PesquisarProtudoLupaComSucesso();
		
		WebElement validacao = driver.findElement(By.xpath("//a[@class='select ng-binding']"));
		assertEquals("HP CHROMEBOOK 14 G1(ENERGY STAR)", validacao.getText());
	}
	
	@Test
	public void TesteConsultaLupaNegativo() throws InterruptedException {
		new PageObjectConsultaLupa(driver).PesquisarProtudoLupaSemSucesso();
		
		WebElement validacao = driver.findElement(By.xpath("//span[@class='ng-binding']"));
		assertEquals("No results for \"DELL\"", validacao.getText());
	}
	

}
