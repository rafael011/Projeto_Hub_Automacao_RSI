package br.com.rsi.hub3.automacao.tdd.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class PageObjectCadastro {
	private WebDriver driver;
	
	public PageObjectCadastro(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clicarBotaoAcessoUsuarios() {
		driver.findElement(By.id("menuUserLink")).click();
		Esperar("5000");
	}

	public void clicarBotaoCriarConta() {
		driver.findElement(By.xpath("//a[@class='create-new-account ng-scope']")).click();
	}

	public void preencherUsuario(String usuario) {
		driver.findElement(By.name("usernameRegisterPage")).sendKeys(usuario);
	}

	public void preencherEmail(String email) {
		driver.findElement(By.name("emailRegisterPage")).sendKeys(email);
	}

	public void preencherSenha(String senha) {
		driver.findElement(By.name("passwordRegisterPage")).sendKeys(senha);
	}

	public void preencherConfirmacaoSenha(String senha) {
		driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys(senha);
	}

	public void preencherNome(String nome) {
		driver.findElement(By.name("first_nameRegisterPage")).sendKeys(nome);
	}

	public void preencherSobrenome(String sobrenome) {
		driver.findElement(By.name("last_nameRegisterPage")).sendKeys(sobrenome);
	}

	public void preencherTelefone(String telefone) {
		driver.findElement(By.name("phone_numberRegisterPage")).sendKeys(telefone);
	}

	public void selecionarPais(String pais) {
		Esperar("3000");
		Select combobox = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		Esperar("3000");
		combobox.selectByVisibleText(pais);
	}

	public void preencherCidade(String cidade) {
		driver.findElement(By.name("cityRegisterPage")).sendKeys(cidade);
	}

	public void preencherEndereco(String endereco) {
		driver.findElement(By.name("addressRegisterPage")).sendKeys(endereco);
	}

	public void preencherEstado(String estado) {
		driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys(estado);
	}

	public void preencherCep(String cep) {
		driver.findElement(By.name("postal_codeRegisterPage")).sendKeys(cep);
	}

	public void clicarOpcaoAceitarTermos() {
		driver.findElement(By.name("i_agree")).click();
	}

	public void clicarBotaoRegistrar() {
		driver.findElement(By.id("register_btnundefined")).click();
		Esperar("2000");
	}
	
	public String validacaoMensagemErro() {
		WebElement validacao = driver.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]"));
		return validacao.getText();
	}
	
	public String validacao() {
		WebElement validacao = driver.findElement(By.xpath("//span[@class='hi-user containMiniTitle ng-binding']"));
		return validacao.getText();
	}
	
	//label[@class='center block smollMargin invalid']
	
	public void Esperar(String tempo) {
		JavascriptExecutor javaScriptExecutor= (JavascriptExecutor) driver;
        javaScriptExecutor.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1],"+tempo+");");
	}
	
	
}
