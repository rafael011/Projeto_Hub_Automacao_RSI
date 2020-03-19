package br.com.rsi.hub.automacao.tdd;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	public void TesteLoginPositivo() throws InterruptedException {
		new PO_PaginadeLogin(driver).LoginComSucesso();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		WebElement validacao = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']"));
		assertEquals("rafael05", validacao.getText());
	}

	
	@Test
	public void TesteLoginNegativo() throws InterruptedException{
		new PO_PaginadeLogin(driver).LoginSemSucesso();	 
		new PO_PaginadeLogin(driver).EsperarValidacaoMsgErroLogin();
		
		WebElement validacao = driver.findElement(By.id("signInResultMessage"));
		assertEquals("Incorrect user name or password.", validacao.getText());
	}

}
