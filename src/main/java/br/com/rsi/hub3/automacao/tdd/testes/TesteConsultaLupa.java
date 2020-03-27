package br.com.rsi.hub3.automacao.tdd.testes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import br.com.rsi.hub3.automacao.tdd.inicializacao.DriverFactory;
import br.com.rsi.hub3.automacao.tdd.pageobject.*;
import static org.junit.Assert.assertEquals;

public class TesteConsultaLupa {
	
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
	public void TesteConsultaLupaPositivo() throws InterruptedException {
		PageObjectConsultaLupa lupa = new PageObjectConsultaLupa(driver);
		lupa.clicarBotaoLupa();
		lupa.preencherPesquisaLupa("HP CHROMEBOOK 14 G1(ENERGY STAR)");
		lupa.clicarProdutoPesquisaLupa();
		
		assertEquals("HP CHROMEBOOK 14 G1(ENERGY STAR)", lupa.validacao());
	}
	
	@Test
	public void TesteConsultaLupaNegativo() throws InterruptedException {
		PageObjectConsultaLupa lupa = new PageObjectConsultaLupa(driver);
		lupa.clicarBotaoLupa();
		lupa.preencherPesquisaInvalidaLupa("DELL");
		lupa.clicarBotaoLupa();
		lupa.clicarFecharLupa();
		
		assertEquals("No results for \"DELL\"", lupa.validacaoPesquisaInvalida());
	}
	

}
