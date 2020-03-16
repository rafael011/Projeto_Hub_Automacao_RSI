package br.com.rsi.gub.automacao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class IniciarNavegador {
	
	private WebDriver driver;
	
	public WebDriver inicializarChorme() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/rafael.carmignotto/eclipse-workspace/ProjetoRSI/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		return driver;
	}
}
