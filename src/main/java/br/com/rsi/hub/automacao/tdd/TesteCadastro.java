package br.com.rsi.hub.automacao.tdd;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TesteCadastro {
	private WebDriver driver;

	@Before
	public void inicializar() {
		PO_Web in = new PO_Web();
		driver = in.inicializarNavegador();
	}

	@After
	public void finalizar() throws InterruptedException {
		Thread.sleep(4000);	
		driver.quit();
	}

	@Test
	public void TesteCadastroSucesso() throws InterruptedException {
		new PO_PaginadeCadastro(driver).PreenchendoCamposCadastroComSucesso();
		
		Thread.sleep(1000);
		WebElement validacao = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']"));
		assertEquals("rafael10", validacao.getText());
	}

	@Test
	public void TesteCadastroSemSucesso() throws InterruptedException {
		new PO_PaginadeCadastro(driver).PreenchendoCamposCadastroSemSucesso();

		Thread.sleep(1000);
		WebElement validacao = driver.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]"));
		assertEquals("User name already exists", validacao.getText());
	}
}
