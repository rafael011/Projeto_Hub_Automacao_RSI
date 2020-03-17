package br.com.rsi.hub.automacao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PO_Web {
	private WebDriver driver;
	
	public WebDriver inicializarChorme() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/rafael.carmignotto/eclipse-workspace/ProjetoRSI/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		return driver;
	}
}
