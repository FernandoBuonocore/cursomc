package com.buonotec.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.buonotec.cursomc.domain.Categoria;
import com.buonotec.cursomc.domain.Produto;
import com.buonotec.cursomc.repositories.CategoriaRepository;
import com.buonotec.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Autowired
	private CategoriaRepository daoCategoria;
	
	@Autowired
	private ProdutoRepository daoProduto;
	
	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().add(p1);
		cat1.getProdutos().add(p2);
		cat1.getProdutos().add(p3);
		cat2.getProdutos().add(p2);

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		daoCategoria.saveAll(Arrays.asList(cat1, cat2));
		
		daoProduto.saveAll(Arrays.asList(p1, p2, p3));
	}

}
