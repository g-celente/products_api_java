package com.g_celente.produtos_api.controller;

import com.g_celente.produtos_api.model.ProdutoModel;
import com.g_celente.produtos_api.services.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Essa classe recebe requisições REST
@RequestMapping("api/products") //Para indicar a rota em que está
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping //mapea a rota como uma requisição Post
    public ProdutoModel saveProduct(@RequestBody ProdutoModel produto) {
        try {
            ProdutoModel newProduto = service.addProduct(produto);
            return newProduto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> getProductById(@PathVariable("id") String id) {
        try {
            Optional<ProdutoModel> produto = service.getProductById(id);
            return produto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping
    public List<ProdutoModel> getAllProducts() {
        try {
            List<ProdutoModel> products = service.getAllProducts();
            return products;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping("/search/{name}")
    public List<ProdutoModel> searchByName(@RequestParam("name") String name) {
        try {
            List<ProdutoModel> product = service.search(name);
            return product;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable("id") String id) {
        try {
            String success = service.deleteProductById(id);
            return success;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
