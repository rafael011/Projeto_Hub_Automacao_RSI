package br.com.rsi.hub3.automacao.tdd.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageObjectConsultaHome {
	private WebDriver driver;
	
	public PageObjectConsultaHome(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver PesquisaHomeComSucesso() {
		Actions acao = new Actions(driver);
		WebElement opcaoTablets = driver.findElement(By.id("tabletsTxt"));
		acao.moveToElement(opcaoTablets).perform();
		driver.findElement(By.id("tabletsLink")).click();
		return this.driver;
		
	}
	
	public WebDriver PesquisaHomeSemSucesso() {
		return this.driver;
		
	}
	
	

}
