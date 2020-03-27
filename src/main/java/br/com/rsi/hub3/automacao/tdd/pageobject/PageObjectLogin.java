package br.com.rsi.hub3.automacao.tdd.pageobject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import br.com.rsi.hub3.automacao.tdd.massadados.*;


public class PageObjectLogin {
	private WebDriver driver;
	
	
	public PageObjectLogin(WebDriver driver) {
		this.driver = driver;
	}

	public String EsperarValidacaoMsgErroLogin() {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(15, TimeUnit.SECONDS); // Tempo total de espera até encontrar
		wait.pollingEvery(1, TimeUnit.SECONDS); // De quanto em quanto verifica se o elemento já pode ser utilizado
		wait.ignoring(NoSuchElementException.class); // ignorar tipos específicos de exceções enquanto aguarda
		WebElement validacao = driver.findElement(By.id("signInResultMessage"));
		wait.until(ExpectedConditions.textToBePresentInElement(validacao, "Incorrect user name or password.")); // Esperar o que?/Condição de espera)
		return driver.findElement(By.id("signInResultMessage")).getText();
	}
	
	public void Esperar(String tempo) {
		JavascriptExecutor javaScriptExecutor= (JavascriptExecutor) driver;
        javaScriptExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1],"+tempo+");");
	}
	
	public void clicarBotaoAcessoUsuarios() {
		driver.findElement(By.id("menuUserLink")).click();
		Esperar("5000");
	}
	
	public void preencherLoginComExcel(String login) throws Exception {
		driver.findElement(By.name("username")).sendKeys(login);
	}

	public void preencherSenhaComExcel(String senha) throws Exception {
		driver.findElement(By.name("password")).sendKeys(senha);
	}

	public void clicarBotaoLogin() throws Exception{
		driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-sender/button")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	public String validacaoLogin() throws InterruptedException {
		WebElement validacao = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']"));
		return validacao.getText();
	}
	
	public String validacaoMensagemErro() throws InterruptedException {
		WebElement validacao = driver.findElement(By.xpath("//label[@id='signInResultMessage']"));
		Esperar("500");
		return validacao.getText();
	}

}
