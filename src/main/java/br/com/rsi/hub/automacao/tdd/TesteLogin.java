package br.com.rsi.hub.automacao.tdd;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TesteLogin {
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
	public void TesteLoginSucesso() throws InterruptedException {
		new PO_PaginaInicial(driver).LoginComSucesso();
		
		Thread.sleep(5000);
		WebElement validacao = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']"));
		assertEquals("rafael05", validacao.getText());
	}

	
	@Test
	public void TesteLoginInvalido() throws InterruptedException{
		new PO_PaginaInicial(driver).LoginSemSucesso();	 

		WebElement validacao = driver.findElement(By.id("signInResultMessage"));
		Thread.sleep(500);
		assertEquals("Incorrect user name or password.", validacao.getText());
	}

}
