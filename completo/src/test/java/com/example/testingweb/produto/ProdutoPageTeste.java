package com.example.testingweb.produto;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.example.testingweb.produto.Produto;

public class ProdutoPageTeste {

	private WebDriver driver;
	
	@Before
	public void init() {
		driver = new FirefoxDriver();
	}
	
	@Test
	public void deve_cadastrar_um_produto() throws Exception {
		Produto notebook = new Produto("Notebook", 2500d);
		
		ProdutoPage produtoPage = new ProdutoPage(driver);
		produtoPage.cadastrar(notebook);
		
		 assertTrue(driver.getPageSource().contains(notebook.getDescricao()));
	}
	
	@Test
	public void deve_editar_um_produto() throws Exception {
		Produto notebook = new Produto("Notebook", 2500d);
		notebook.setId(5);
		
		ProdutoPage produtoPage = new ProdutoPage(driver);
		produtoPage.editar(notebook);
		
		 assertTrue(driver.getPageSource().contains(notebook.getDescricao()));
	}
}
