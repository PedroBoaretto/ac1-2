package com.example.ac1parte2.repository;
import com.example.ac1parte2.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByNomeStartingWith(String nome);

    Categoria findCategoriaWithProdutosById(Long id);
}
