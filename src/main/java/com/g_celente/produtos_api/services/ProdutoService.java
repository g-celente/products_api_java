package com.g_celente.produtos_api.services;

import com.g_celente.produtos_api.model.ProdutoModel;
import com.g_celente.produtos_api.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoModel addProduct(ProdutoModel produtoModel) {
        var id = UUID.randomUUID().toString();
        produtoModel.setId(id);
        repository.save(produtoModel);
        return produtoModel;
    }

    public Optional<ProdutoModel> getProductById(String id) {
        try {
            Optional<ProdutoModel> produtoModel = repository.findById(id);
            return  produtoModel;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ProdutoModel> getAllProducts() {
        try {
            List<ProdutoModel> products = repository.findAll();
            return  products;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String deleteProductById(String id) {
        try {
            repository.deleteById(id);
            return "Produto Deletado Com Sucesso";
        } catch (Exception e) {
            return "Erro ao tentar deletar produto: " + e;
        }
    }

    public List<ProdutoModel> search(String name) {
        try {
            List<ProdutoModel> produto = repository.findByName(name);
            return produto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
