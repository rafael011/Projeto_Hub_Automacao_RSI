package br.com.rsi.hub3.automacao.tdd.testes;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import br.com.rsi.hub3.automacao.tdd.pageobject.*;

public class TesteCadastro {
	private WebDriver driver;

	@Before
	public void inicializar() {
		PO_InicializacaoWeb in = new PO_InicializacaoWeb();
		driver = in.inicializarNavegador();
	}

	@After
	public void finalizar() throws InterruptedException {
		Thread.sleep(4000);	
		driver.quit();
	}

	@Test
	public void TesteCadastroPositivo() throws InterruptedException {
		new PO_PaginadeCadastro(driver).PreenchendoCamposCadastroComSucesso();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement validacao = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']"));
		assertEquals("rafael15", validacao.getText());
	}

	@Test
	public void TesteCadastroNegativo() throws InterruptedException {
		new PO_PaginadeCadastro(driver).PreenchendoCamposCadastroSemSucesso();

		Thread.sleep(1000);
		WebElement validacao = driver.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]"));
		assertEquals("User name already exists", validacao.getText());
	}
}
