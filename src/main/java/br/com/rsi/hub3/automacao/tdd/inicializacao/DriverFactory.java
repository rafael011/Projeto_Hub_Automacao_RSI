package br.com.rsi.hub3.automacao.tdd.inicializacao;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
	private WebDriver driver;

	public WebDriver inicializarNavegador() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chormedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("special_offer_items")));

		return driver;
	}
	
	public WebDriver fecharNavegador() {
		driver.quit();
		return driver;
	}

	public void Esperar(String tempo) {
		JavascriptExecutor javaScriptExecutor= (JavascriptExecutor) driver;
        javaScriptExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1],"+tempo+");");
	}

}
