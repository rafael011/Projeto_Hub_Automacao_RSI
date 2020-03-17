package br.com.rsi.hub.automacao;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Acoes {
	
	private WebDriver driver;	
	
//	public String obterValorCampo(String name_campo) {
//		return driver.findElement(By.id(name_campo));
//	}
	
	public void escrever(String name_campo, String texto) { //Tornando o id e o texto como variaveis 
		driver.findElement(By.name(name_campo)).sendKeys(texto);
	}
	
	public void clicar_Id(String id_campo) {
		driver.findElement(By.id(id_campo)).click();
	}
	
	public void clicar_Xpath(String xpath_campo) {
		driver.findElement(By.xpath(xpath_campo)).click();
	}
	
	public void clicar_Name(String name_campo) {
		driver.findElement(By.xpath(name_campo)).click();
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
