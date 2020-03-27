package br.com.rsi.hub3.automacao.tdd.pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageObjectConsultaHome {
	private WebDriver driver;
	
	public PageObjectConsultaHome(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clicarBotaoTablets() {
		Actions acao = new Actions(driver);
		WebElement opcaoTablets = driver.findElement(By.id("tabletsTxt"));
		acao.moveToElement(opcaoTablets).perform();
		driver.findElement(By.id("tabletsLink")).click();
	}
	
	public boolean verificarBotaoInexistente(String produtoInexistente) {
		List<WebElement> ListaElementosHome = driver.findElements(By.xpath("//span[@class='shop_now roboto-bold ng-binding']"));
		for (WebElement elemento : ListaElementosHome) {
			if (elemento.getText().contains(produtoInexistente)) {
				return true;
			}
		}
		return false;
	}	
	
	public String validacao() {
		WebElement validacao = driver.findElement(By.xpath("//h1[@class='roboto-bold ng-binding']"));
		return validacao.getText();
	}

}
