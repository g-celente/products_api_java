package com.g_celente.produtos_api.repositories;

import com.g_celente.produtos_api.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, String> {

    List<ProdutoModel> findByName(String name);

}


