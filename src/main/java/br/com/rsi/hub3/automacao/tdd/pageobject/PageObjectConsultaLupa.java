package br.com.rsi.hub3.automacao.tdd.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectConsultaLupa {
	private WebDriver driver;
	
	public PageObjectConsultaLupa(WebDriver driver) {
		this.driver = driver;
	}
	
	public void Esperar() {
		JavascriptExecutor javaScriptExecutor= (JavascriptExecutor) driver;
        javaScriptExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
	}
	
	public void clicarBotaoLupa() {
		driver.findElement(By.id("menuSearch")).click();
	}
	
	public void preencherPesquisaLupa(String produto) {
		driver.findElement(By.id("autoComplete")).sendKeys(produto);
		Esperar();
	}
	public void clicarProdutoPesquisaLupa() {
		driver.findElement(By.xpath("//p[contains(text(),'HP CHROMEBOOK 14 G1(ENERGY STAR)')]")).click();
	}

	public void preencherPesquisaInvalidaLupa(String produtoInexistente) {
		driver.findElement(By.id("autoComplete")).sendKeys(produtoInexistente);
		Esperar();
	}
	
	public void clicarFecharLupa() {
		driver.findElement(By.xpath("//div[@class='autoCompleteCover']//div//img")).click();
	}
	
	public String validacao() {
		WebElement validacao = driver.findElement(By.xpath("//a[@class='select ng-binding']"));
		return validacao.getText();
	}
	
	public String validacaoPesquisaInvalida() {
		WebElement validacao = driver.findElement(By.xpath("//span[@class='ng-binding']"));
		return validacao.getText();
	}
	
//	public WebDriver PesquisarProtudoLupaComSucesso() throws InterruptedException {
//		driver.findElement(By.id("menuSearch")).click();
//		driver.findElement(By.id("autoComplete")).sendKeys("HP CHROMEBOOK 14 G1(ENERGY STAR)");
//		Esperar();
//		driver.findElement(By.xpath("//p[contains(text(),'HP CHROMEBOOK 14 G1(ENERGY STAR)')]")).click();
//		return this.driver;
//	}
	
//	public WebDriver PesquisarProtudoLupaSemSucesso() throws InterruptedException {
//		driver.findElement(By.id("menuSearch")).click();
//		driver.findElement(By.id("autoComplete")).sendKeys("DELL");
//		Esperar();
//		driver.findElement(By.id("menuSearch")).click();
//		driver.findElement(By.xpath("//div[@class='autoCompleteCover']//div//img")).click();
//		Esperar();
//		return this.driver;		
//	}
}
