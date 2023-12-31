package com.example.ac1parte2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.ac1parte2.models.Produto;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByPrecoGreaterThan(Double valor);

    List<Produto> findByPrecoLessThanEqual(Double valor);

    List<Produto> findByNomeStartingWith(String nome);
}
