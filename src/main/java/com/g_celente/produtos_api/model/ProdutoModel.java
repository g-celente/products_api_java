package com.g_celente.produtos_api.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "produtos")
public class ProdutoModel {

    @Id
    @Column
    private String id;
    @Column(name = "nome")
    private String nome_produto;
    @Column
    private String descricao;
    @Column
    private Double preco;


    @Override
    public String toString() {
        return "ProdutoModel{" +
                "id='" + id + '\'' +
                ", nome_produto='" + nome_produto + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
