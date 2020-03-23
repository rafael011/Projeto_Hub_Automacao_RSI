package br.com.rsi.hub3.automacao.tdd.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsi.hub3.automacao.excel.LerArquivoExcel;

public class PO_InicializacaoWeb {
	private WebDriver driver;
	private LerArquivoExcel readFile;
	
	public WebDriver inicializarNavegador() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chormedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.advantageonlineshopping.com/#/");
		readFile = new LerArquivoExcel();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return driver;
	}
}
