package br.com.rsi.gub.automacao;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Login {
	private WebDriver driver;	

	@Before
	public void inicializar() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/rafael.carmignotto/eclipse-workspace/ProjetoRSI/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

//	@After
//	public void finalizar() {
//		driver.quit();
//	}

	@Test
	public void TesteLoginSucesso() throws InterruptedException {
		WebElement botaoAcessoUsuarios = driver.findElement(By.id("menuUserSVGPath"));
		WebElement user = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement botaoLogar = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-sender/button"));

		botaoAcessoUsuarios.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		user.sendKeys("rafael05");
		password.sendKeys("Rafa123");
		botaoLogar.click();
		Thread.sleep(5000);
		//Assert.assertEquals("Incorrect user name or password.", driver.findElement(By.id("signInResultMessage")).getText());
		//System.out.println(driver.findElement(By.id("signInResultMessage")).getText());
	}

	@Test
	public void TesteLoginInvalido() throws InterruptedException{
		WebElement botaoAcessoUsuarios = driver.findElement(By.id("menuUserSVGPath"));
		WebElement user = driver.findElement(By.name("username"));
		WebElement password = driver.findElement(By.name("password"));
		WebElement botaoLogar = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-sender/button"));

		botaoAcessoUsuarios.click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		user.sendKeys("rafael02");
		password.sendKeys("senhaErrada");
		botaoLogar.click();

		FluentWait esperar = new FluentWait(driver);
		esperar.withTimeout(15, TimeUnit.SECONDS); //Tempo total de espera até encontrar
        esperar.pollingEvery(1, TimeUnit.SECONDS); //De quanto em quanto verifica se o elemento já pode ser utilizado
        esperar.ignoring(NoSuchElementException.class); //ignorar tipos específicos de exceções enquanto aguarda
        
		WebElement validacao = driver.findElement(By.id("signInResultMessage"));
		esperar.until(ExpectedConditions.textToBePresentInElement(validacao, "Incorrect user name or password.")); //Esperar pelo quê? (Condição de espera)
		Assert.assertEquals("Incorrect user name or password.", validacao.getText());
	}

}
