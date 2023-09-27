package com.example.ac1parte2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.ac1parte2.models.Categoria;
import com.example.ac1parte2.models.Produto;
import com.example.ac1parte2.repository.CategoriaRepository;
import com.example.ac1parte2.repository.ProdutoRepository;

@SpringBootApplication
public class Ac1parte2Application {

	@Bean
	public CommandLineRunner init(@Autowired ProdutoRepository produtoRepository,
			@Autowired CategoriaRepository categoriaRepository) {

		return args -> {

			produtoRepository.save(new Produto((long) 1, "Porsche GT4 RS", 1000000.00));
			produtoRepository.save(new Produto((long) 2, "Porsche Macan", 700000.00));
			produtoRepository.save(new Produto((long) 3, "BMW M2", 960000.00));

			categoriaRepository.save(new Categoria((long) 1, "Carros de Luxo"));
			categoriaRepository.save(new Categoria((long) 2, "Motos"));

			System.out.println("----------------------------------------------------");
			System.out.println("** Lista todos os produtos **");
			List<Produto> listaProduto = produtoRepository.findAll();
			listaProduto.forEach(System.out::println);
			
			System.out.println("----------------------------------------------------");

			System.out.println("** Lista todas as categorias **");
			List<Categoria> listaCategoria = categoriaRepository.findAll();
			listaCategoria.forEach(System.out::println);

			System.out.println("----------------------------------------------------");

			System.out.println("** obter produto com valor maior que 900mil **");
			listaProduto = produtoRepository.findByPrecoGreaterThan(900000.00);
			listaProduto.forEach(System.out::println);

			System.out.println("----------------------------------------------------");

			System.out.println("** obter produto com valor menor ou igual a 800mil **");
			listaProduto = produtoRepository.findByPrecoLessThanEqual(800000.00);
			listaProduto.forEach(System.out::println);

			System.out.println("----------------------------------------------------");

			System.out.println("** obter produto por nome que comece com 'Pors'**");
            listaProduto = produtoRepository.findByNomeStartingWith("Pors");
            listaProduto.forEach(System.out::println);

			System.out.println("----------------------------------------------------");

			System.out.println("** obter categoria por nome que comece com 'Carro' **");
			listaCategoria = categoriaRepository.findByNomeStartingWith("Carro");
			listaCategoria.forEach(System.out::println);
			System.out.println("----------------------------------------------------");
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1parte2Application.class, args);
	}

}
