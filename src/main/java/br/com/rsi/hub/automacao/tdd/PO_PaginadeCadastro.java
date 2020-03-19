package br.com.rsi.hub.automacao.tdd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class PO_PaginadeCadastro {
	private WebDriver driver;
	private WebElement validacao;
	
	
	public PO_PaginadeCadastro(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver PreenchendoCamposCadastroComSucesso() throws InterruptedException {
		driver.findElement(By.id("menuUserLink")).click();
		Thread.sleep(5000);
		//EsperarValidacaoCadastro(validacao);
		driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']")).click();
		driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']")).click();

		driver.findElement(By.name("usernameRegisterPage")).sendKeys("rafael15");
		driver.findElement(By.name("emailRegisterPage")).sendKeys("rgc.test15@gmail.com");
		driver.findElement(By.name("passwordRegisterPage")).sendKeys("Rafa123");
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Rafa123");

		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Rafael");
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Gomes");
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("11999990000");

		Thread.sleep(3000);
		//EsperarValidacaoCadastro(validacao);
		Select combobox = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		Thread.sleep(2000);
		//EsperarValidacaoCadastro(validacao);
		combobox.selectByVisibleText("Brazil");

		driver.findElement(By.name("cityRegisterPage")).sendKeys("Sao Paulo");
		driver.findElement(By.name("addressRegisterPage")).sendKeys("Rua Abcde, N 20");
		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("SP");
		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("08455000");
		driver.findElement(By.name("i_agree")).click();
		driver.findElement(By.id("register_btnundefined")).click();
		return driver;
	}
	
	public WebDriver PreenchendoCamposCadastroSemSucesso() throws InterruptedException {
		driver.findElement(By.id("menuUserLink")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']")).click();

		driver.findElement(By.name("usernameRegisterPage")).sendKeys("rafael05");
		driver.findElement(By.name("emailRegisterPage")).sendKeys("rgc.teste1@gmail.com");
		driver.findElement(By.name("passwordRegisterPage")).sendKeys("Rafa123");
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys("Rafa123");

		driver.findElement(By.name("first_nameRegisterPage")).sendKeys("Rafael");
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys("Gomes");
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys("11999990000");

		Thread.sleep(2000);
		Select combobox = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		Thread.sleep(3000);
		combobox.selectByVisibleText("Brazil");

		driver.findElement(By.name("cityRegisterPage")).sendKeys("Sao Paulo");
		driver.findElement(By.name("addressRegisterPage")).sendKeys("Rua Abcde, N 20");
		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys("SP");
		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys("08455000");
		driver.findElement(By.name("i_agree")).click();
		driver.findElement(By.id("register_btnundefined")).click();
		return driver;
	}
	
	
	public FluentWait EsperarValidacaoCadastro(WebElement validacao) throws InterruptedException {
		//Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(7, TimeUnit.SECONDS); 
		wait.pollingEvery(1, TimeUnit.SECONDS); 
		wait.ignoring(NoSuchElementException.class);
		validacao = driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']"));
		wait.until(ExpectedConditions.textToBePresentInElement(validacao, "CREATE NEW ACCOUNT")); 
		return wait;
	}
}
