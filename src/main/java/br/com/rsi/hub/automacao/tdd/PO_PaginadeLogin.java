package br.com.rsi.hub.automacao.tdd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class PO_PaginadeLogin {
	private WebDriver driver;
	private WebElement validacao;

	public PO_PaginadeLogin(WebDriver driver) {
		this.driver = driver;
	}

	public String EsperarValidacaoMsgErroLogin() {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(15, TimeUnit.SECONDS); // Tempo total de espera até encontrar
		wait.pollingEvery(1, TimeUnit.SECONDS); // De quanto em quanto verifica se o elemento já pode ser utilizado
		wait.ignoring(NoSuchElementException.class); // ignorar tipos específicos de exceções enquanto aguarda
		validacao = driver.findElement(By.id("signInResultMessage"));
		wait.until(ExpectedConditions.textToBePresentInElement(validacao, "Incorrect user name or password.")); // Esperar																										// espera)
		return driver.findElement(By.id("signInResultMessage")).getText();
	}

	public WebDriver LoginComSucesso() throws InterruptedException {
		driver.findElement(By.id("menuUserSVGPath")).click(); // Clicando no botão de acesso de usuários OK
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("rafael05");
		driver.findElement(By.name("password")).sendKeys("Rafa123");
		driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-sender/button")).click();
		return driver;

	}

	public WebDriver LoginSemSucesso() throws InterruptedException {
		driver.findElement(By.id("menuUserSVGPath")).click(); // Clicando no botão de acesso de usuários OK
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("rafael");
		driver.findElement(By.name("password")).sendKeys("senhaErrada");
		driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-sender/button")).click();
		return driver;

	}

}
