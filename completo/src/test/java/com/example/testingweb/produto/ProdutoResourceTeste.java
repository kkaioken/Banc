package com.example.testingweb.produto;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import javax.ws.rs.core.MediaType;

import org.junit.Test;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

import com.example.testingweb.produto.ProdutoRequest;

public class ProdutoResourceTeste {
	
	@Test
	public void deve_trazer_um_produto_pelo_id() throws Exception {
		given().
			accept(MediaType.APPLICATION_JSON).
		expect().
			statusCode(200).
			body("descricao", equalTo("Geladeira")).
		when().
			get("http://localhost:8080/testesdesoftware/rest/produtos/5");
	}
	
	@Test
	public void deve_retornar_todos_os_produtos() throws Exception {
		Response json = given().
				accept(MediaType.APPLICATION_JSON).
			when().
				get("http://localhost:8080/testesdesoftware/rest/produtos/5");
		
		JsonPath jsonPath = new JsonPath(json.getBody().asString());
		int id = jsonPath.getInt("id");
		String descricao = jsonPath.get("descricao");
		double valorUnitario = jsonPath.getDouble("valorUnitario");
		
		assertTrue(5 == id);
		assertEquals("Geladeira", descricao);
		assertTrue(1200d == valorUnitario);
	}
	
	@Test
	public void deve_adicionar_um_produto() throws Exception {
		ProdutoRequest produtoRequest = new ProdutoRequest("iPad", 3000d);
		given().
			contentType(MediaType.APPLICATION_JSON).
			body(produtoRequest).
	       	post("http://localhost:8080/testesdesoftware/rest/produtos/").
	    then()
	    	.statusCode(200);
	}
	
	@Test
	public void deve_excluir_um_produto() throws Exception {
		given().
	       	delete("http://localhost:8080/testesdesoftware/rest/produtos/1").
	    then()
	    	.statusCode(200);
	}
	
	@Test
	public void deve_trazer_um_produto_pelo_id_json_path() throws Exception {
		Response json = given().
			accept(MediaType.APPLICATION_JSON).
		when().
			get("http://localhost:8080/testesdesoftware/rest/produtos/5");
		
		JsonPath jsonPath = new JsonPath(json.getBody().asString());
		double valorUnitario = jsonPath.getDouble("valorUnitario");
		
		assertTrue(1200d == valorUnitario);
	}
}
