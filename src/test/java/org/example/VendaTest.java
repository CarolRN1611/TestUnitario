package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendaTest {
    Produto produto;
    Venda venda;

    @BeforeEach
    public void setUp() {
        produto = new Produto("Arroz",3.5,20);
    }

    //Testar venda com quantidade menor que o estoque disponível.
    @Test
    public void vendaProdutoQuantidadeMenorEstoque(){
        venda = new Venda(produto,10);
        Assertions.assertTrue(venda.realizarVenda());
        
        Assertions.assertEquals(produto, venda.getProduto());
        Assertions.assertEquals(10, venda.getQuantidadeVendida());
    }

    //Testar venda com quantidade igual ao estoque disponível.
    @Test
    public void vendaProdutoQuantidadeIgualEstoque(){
        venda = new Venda(produto,20);
        Assertions.assertTrue(venda.realizarVenda());
    }

    //Testar venda com quantidade maior que o estoque disponível (deve falhar).
    @Test
    public void vendaProdutoQuantidadeMaiorEstoque(){
        venda = new Venda(produto,30);
        Assertions.assertFalse(venda.realizarVenda());
    }

    //Testar cálculo do total da venda corretamente.
    @Test
    public void valorTotalVenda(){
        venda = new Venda(produto,10);
        venda.realizarVenda();
        Assertions.assertEquals(35.0,venda.getTotalVenda());
    }
    //Testar aumento de estoque do produto após uma venda.
    @Test
    public void aumentoEstoquePosVenda(){
        venda = new Venda(produto,10);
        venda.realizarVenda();
        produto.aumentarEstoque(15);
        Assertions.assertEquals(25,produto.getEstoque());
    }

    //Testar diminuição do estoque do produto após uma venda bem-sucedida
    @Test
    public void diminuirEstoquePosVenda(){
        venda = new Venda(produto,15);
        venda.realizarVenda();
        Assertions.assertEquals(5,produto.getEstoque());
    }


    //Testar realizar venda de um produto que não existe (deve falhar).
    @Test
    public void vendaDeProdutoInexistente(){
        Produto produtob = null;
        Venda venda = new Venda(produtob, 10);
        Assertions.assertThrows(Exception.class, () -> {
            venda.realizarVenda();
        });
    }

    //Testar criação de venda com quantidade negativa (deve falhar).
    //codigo não lança retorna false em caso de quantidade negatica ,nem lança um excessão
    @Test
    public void vendaProdutoNegativoQuantidade(){
        venda = new Venda(produto,-10);
        Assertions.assertFalse(venda.realizarVenda());
    }

    //Testar alteração do estoque após a tentativa de venda com estoque insuficiente.
    @Test
    public void alterarEstoquePosVendaInvalidaPorProdutoInsuficiente(){
        venda = new Venda(produto,25);
        venda.realizarVenda();
        Assertions.assertFalse(venda.realizarVenda());
        produto.aumentarEstoque(15);
        Assertions.assertEquals(35,produto.getEstoque());
    }

    //Testar criação de vários produtos e realizar vendas com estoque compartilhado.
    @Test
    public void vendaProdutoCompartilhado(){
        Venda venda1 = new Venda(produto,10);
        Venda venda2 = new Venda(produto,5);

        Assertions.assertTrue(venda1.realizarVenda());
        Assertions.assertTrue(venda2.realizarVenda());
        Assertions.assertEquals(5, produto.getEstoque());
    }


    //Testar calcular total de venda quando o preço do produto for alterado antes da venda.
    @Test
    public void calcularTotalVendaAlterarPrecoProduto(){
        produto.setPreco(5.5);
        venda = new Venda(produto,10);
        venda.realizarVenda();
        Assertions.assertEquals(55.0,venda.getTotalVenda());
    }

    //Testar comportamento da venda quando o estoque inicial é zero.
    @Test
    public void vendaProdutoEstoqueZero(){
        Produto produto2 = new Produto("Cafe",12.5,0);
        venda = new Venda(produto2,10);
        Assertions.assertFalse(venda.realizarVenda());
    }


    //Testar aumento do estoque após uma reposição e verificar se a venda é bem-sucedida posteriormente.
    @Test
    public void aumentoEstoquePosReposicao(){
        Produto produto2 = new Produto("Cafe",12.5,0);
        produto2.aumentarEstoque(10);
        Assertions.assertEquals(10,produto2.getEstoque());

        venda = new Venda(produto2,10);
        Assertions.assertTrue(venda.realizarVenda());
    }

}
