package br.com.rsi.hub.automacao;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCadastro {
	private WebDriver driver;

	@Before
	public void inicializar() {
		PO_Web in = new PO_Web();
		driver = in.inicializarChorme();
	}

	@After
	public void finalizar() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}

	@Test
	public void TesteCadastroSucesso() throws InterruptedException {
		new PO_PaginadeCadastro(driver).PreenchendoCamposCadastroComSucesso();
	}

	@Test
	public void TesteCadastroSemSucesso() throws InterruptedException {
		new PO_PaginadeCadastro(driver).PreenchendoCamposCadastroSemSucesso();

		Thread.sleep(1000);
		WebElement validacao = driver.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]"));
		assertEquals("User name already exists", validacao.getText());
	}
}
