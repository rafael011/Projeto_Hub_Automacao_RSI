package br.com.rsi.gub.automacao;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Funcoes {
	
	private WebDriver driver;	
	FluentWait esperar = new FluentWait(driver);

	public void esperar() {	
		esperar.withTimeout(12, TimeUnit.SECONDS); //Tempo total de espera até encontrar
        esperar.pollingEvery(1, TimeUnit.SECONDS); //De quanto em quanto verifica se o elemento já pode ser utilizado
        esperar.ignoring(NoSuchElementException.class); //ignorar tipos específicos de exceções enquanto aguarda
	}

	public void esperarOQue() {
		WebElement validacao = driver.findElement(By.id("signInResultMessage"));
		esperar.until(ExpectedConditions.textToBePresentInElement(validacao, "Incorrect user name or password."));
	}
	
	public String obterValorCampo(String name_campo) {
		return driver.findElement(By.id(name_campo)).getAttribute("value");
	}
	
	
	public void inicializar() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/rafael.carmignotto/eclipse-workspace/ProjetoRSI/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	}
}
