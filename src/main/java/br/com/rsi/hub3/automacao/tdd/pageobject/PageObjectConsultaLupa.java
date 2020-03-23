package br.com.rsi.hub3.automacao.tdd.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectConsultaLupa {
	private WebDriver driver;
	
	public PageObjectConsultaLupa(WebDriver driver) {
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
