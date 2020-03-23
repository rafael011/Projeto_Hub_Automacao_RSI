package br.com.rsi.hub3.automacao.excel;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteLerArquivo {

	private WebDriver driver;
	private LerArquivoExcel readFile;
	private By searchBoxLocator = By.id("search_query_top");
	private By searchBtnLocator = By.name("submit_search");
	private By resultTextLocator = By.cssSelector("span.heading-counter");

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chormedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		readFile = new LerArquivoExcel();
		
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void test() throws IOException {
		
		String filepath = "src\\test\\resources\\massa.xlsx";

		//String login = readFile.getCellValue(filepath, "Planilha1", 0, 0);

		driver.findElement(searchBoxLocator).clear();

		driver.findElement(searchBoxLocator).sendKeys(readFile.getCellValue(filepath, "Planilha1", 0, 0));
		driver.findElement(searchBtnLocator).click();
//		String resultText = driver.findElement(resultTextLocator).getText();
//		System.out.println("Page result text:" + resultText);
		
		System.out.println((readFile.getCellValue(filepath, "Planilha1", 0, 0)));
	}

}
