package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest {
    Produto produto;


    @BeforeEach
    public void setUp() {

    }

    //Testar criação de produto com valores válidos.
    @Test
    public void criacaoProdutoValorValido(){
        produto = new Produto("Arroz",3.5,20);
        assert produto.getPreco() == 3.5;
        assert produto.getEstoque() == 20;
        assert produto.getNome().equals("Arroz");
    }

    //Testar criação de produto com preço negativo (deve ser inválido).
    //codigo não impedi ,nem lança exceção sobre adicionar produtos com valores negativos
    @Test
    public void criacaoProdutoValorNegativo(){
        Assertions.assertThrows(Exception.class, () -> {
            new Produto("Arroz", -3.5, 20);
        });
    }

    //Testar criação de produto com estoque negativo (deve ser inválido).
    //codigo não impedi ,nem lança exceção sobre adicionar produtos com estoque negativo
    @Test
    public void criacaoProdutoEstoqueNegativo(){
        Assertions.assertThrows(Exception.class, () -> {
            new Produto("Arroz", 3.5, -20);
        });
    }

    //Testar alteração do nome do produto para um valor válido.
    @Test
    public void alterarNomeProdutoValorValido(){
        produto = new Produto("Arroz",3.5,20);

        produto.setNome("Carne");

        Assertions.assertEquals("Carne",produto.getNome());
    }

    //Testar alteração do preço do produto para um valor válido.
    @Test
    public void alterarValorProdutoValorValido(){
        produto = new Produto("Arroz",3.5,20);

        produto.setPreco(35.5);

        Assertions.assertEquals(35.5,produto.getPreco());
    }

    //Testar alteração do estoque para um valor positivo.
    @Test
    public void alterarEstoqueProdutoValorValido(){
        produto = new Produto("Arroz",3.5,20);

        produto.setEstoque(100);

        Assertions.assertEquals(100,produto.getEstoque());
    }

    //Testar alteração do preço do produto para um valor negativo (deve falhar).
    //codigo não impedi ,nem lança exceção sobre modificar o preço para um valor negativo
    @Test
    public void alterarValorProdutoValorNegativo(){
       produto = new Produto("Arroz",3.5,20);
       Assertions.assertThrows(Exception.class, () -> {
           produto.setPreco(-35.5);
       });
    }
}
