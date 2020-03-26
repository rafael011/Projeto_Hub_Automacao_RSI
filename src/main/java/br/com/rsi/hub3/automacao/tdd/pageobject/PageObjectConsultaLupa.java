package br.com.rsi.hub3.automacao.tdd.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
	
	public String Esperar() {
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(20, TimeUnit.SECONDS); 
		wait.pollingEvery(500, TimeUnit.MILLISECONDS); 
		wait.ignoring(NoSuchElementException.class); 
		WebElement validacao = driver.findElement(By.xpath("//p[contains(text(),'HP CHROMEBOOK 14 G1(ENERGY STAR)')]"));
		wait.until(ExpectedConditions.textToBePresentInElement(validacao, "HP CHROMEBOOK 14 G1(ENERGY STAR)"));
		return driver.findElement(By.xpath("//p[contains(text(),'HP CHROMEBOOK 14 G1(ENERGY STAR)')]")).getText();
	}
	
	public String Esperar2() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement validacao = driver.findElement(By.xpath("//p[contains(text(),'HP CHROMEBOOK 14 G1(ENERGY STAR)')]"));
		wait.until(ExpectedConditions.textToBePresentInElement(validacao, "HP CHROMEBOOK 14 G1(ENERGY STAR)"));
		return driver.findElement(By.xpath("//p[contains(text(),'HP CHROMEBOOK 14 G1(ENERGY STAR)')]")).getText();
	}
	
	public WebDriver PesquisarProtudoLupaComSucesso() throws InterruptedException {
		driver.findElement(By.id("menuSearch")).click();
		driver.findElement(By.id("autoComplete")).sendKeys("HP CHROMEBOOK 14 G1(ENERGY STAR)");
		Esperar2();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//p[contains(text(),'HP CHROMEBOOK 14 G1(ENERGY STAR)')]")).click();
		return this.driver;
	}
	
	public WebDriver PesquisarProtudoLupaSemSucesso() throws InterruptedException {
		driver.findElement(By.id("menuSearch")).click();
		driver.findElement(By.id("autoComplete")).sendKeys("DELL");
		Thread.sleep(5000);
		driver.findElement(By.id("menuSearch")).click();
		driver.findElement(By.xpath("//div[@class='autoCompleteCover']//div//img")).click();
		Thread.sleep(6000);
		
		return this.driver;		
	}
}
