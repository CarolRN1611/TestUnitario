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
        Assertions.assertEquals(3.5,produto.getPreco());
        Assertions.assertEquals(20, produto.getEstoque());
        Assertions.assertEquals("Arroz",produto.getNome());
    }

    //Testar criação de produto com preço negativo (deve ser inválido).
    @Test
    public void criacaoProdutoValorNegativo(){
        produto = new Produto("Arroz",-3.5,20);
        Assertions.assertTrue(produto.getPreco() < 0);
        Assertions.assertEquals(20, produto.getEstoque());
        Assertions.assertEquals("Arroz",produto.getNome());
    }

    //Testar criação de produto com estoque negativo (deve ser inválido).
    @Test
    public void criacaoProdutoEstoqueNegativo(){
        produto = new Produto("Arroz",3.5,-20);
        Assertions.assertEquals(3.5,produto.getPreco());
        Assertions.assertTrue(produto.getEstoque() < 0);
        Assertions.assertEquals("Arroz",produto.getNome());
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
    @Test
    public void alterarValorProdutoValorNegativo(){
       produto = new Produto("Arroz",3.5,20);
       produto.setPreco(-6.5);
        Assertions.assertTrue(produto.getPreco() < 0);
        Assertions.assertEquals(20, produto.getEstoque());
        Assertions.assertEquals("Arroz",produto.getNome());
    }
}
