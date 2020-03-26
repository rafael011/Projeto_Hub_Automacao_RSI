package br.com.rsi.hub3.automacao.tdd.testes;

//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import br.com.rsi.hub3.automacao.tdd.inicializacao.InicializacaoWeb;
import br.com.rsi.hub3.automacao.tdd.pageobject.*;

public class TesteCadastro {
	private WebDriver driver;

	@BeforeMethod
	public void inicializar() {
		InicializacaoWeb in = new InicializacaoWeb();
		driver = in.inicializarNavegador();
	}

	@AfterMethod
	public void finalizar() throws InterruptedException {
		Thread.sleep(4000);	
		driver.quit();
	}

	@Test
	public void TesteCadastroPositivo() throws InterruptedException {
		new PageObjectCadastro(driver).PreenchendoCamposCadastroComSucesso();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		WebElement validacao = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']"));
		assertEquals("rafael15", validacao.getText());
	}

	@Test
	public void TesteCadastroNegativo() throws InterruptedException {
		new PageObjectCadastro(driver).PreenchendoCamposCadastroSemSucesso();

		Thread.sleep(1000);
		WebElement validacao = driver.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]"));
		assertEquals("User name already exists", validacao.getText());
	}
}
