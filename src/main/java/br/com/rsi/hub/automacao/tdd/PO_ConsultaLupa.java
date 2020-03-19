package br.com.rsi.hub.automacao.tdd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PO_ConsultaLupa {
	private WebDriver driver;
	
	public PO_ConsultaLupa(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver PesquisarProtudoLupaComSucesso() throws InterruptedException {
		driver.findElement(By.id("menuSearch")).click();
		driver.findElement(By.id("autoComplete")).sendKeys("HP CHROMEBOOK 14 G1(ENERGY STAR)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[contains(text(),'HP CHROMEBOOK 14 G1(ENERGY STAR)')]")).click();
		Thread.sleep(6000);
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
