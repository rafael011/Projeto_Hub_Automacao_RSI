package br.com.rsi.hub.automacao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PO_PaginaInicial {
	private WebDriver driver;
	private WebElement validacao;
	
	public PO_PaginaInicial(WebDriver driver) {
		this.driver = driver;
	}	
	
//	public String EsperarValidacao() {
//		FluentWait esperar = new FluentWait(driver);
//		esperar.withTimeout(15, TimeUnit.SECONDS); //Tempo total de espera até encontrar
//        esperar.pollingEvery(1, TimeUnit.SECONDS); //De quanto em quanto verifica se o elemento já pode ser utilizado
//        esperar.ignoring(NoSuchElementException.class); //ignorar tipos específicos de exceções enquanto aguarda
//        
//		validacao = driver.findElement(By.id("signInResultMessage"));
//		esperar.until(ExpectedConditions.textToBePresentInElement(validacao, "Incorrect user name or password.")); //Esperar pelo quê? (Condição de espera)
//		return driver.findElement(By.id("signInResultMessage")).getText();
//	}
	
	public WebDriver LoginComSucesso() throws InterruptedException {
		driver.findElement(By.id("menuUserSVGPath")).click();  //Clicando no botão de acesso de usuários OK
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("rafael05");
		driver.findElement(By.name("password")).sendKeys("Rafa123");
		driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-sender/button")).click();
		return driver;
		
//		WebElement botaoAcessoUsuarios = driver.findElement(By.id("menuUserSVGPath"));
//		WebElement user = driver.findElement(By.name("user"));
//		WebElement password = driver.findElement(By.name("password"));
//		WebElement botaoLogar = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-sender/button"));
//		
//		botaoAcessoUsuarios.click();
//		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//		user.sendKeys("rafael05");
//		password.sendKeys("Rafa123");
//		botaoLogar.click();
		
	}
	
	public WebDriver LoginSemSucesso() throws InterruptedException {		
		driver.findElement(By.id("menuUserSVGPath")).click();  //Clicando no botão de acesso de usuários OK
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.name("username")).sendKeys("rafael");
		driver.findElement(By.name("password")).sendKeys("senhaErrada");
		driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-sender/button")).click();
		return driver;
		
	}

}
