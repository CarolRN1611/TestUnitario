package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Produto produto = new Produto("Arroz",3.5,-20);
        System.out.println(produto.getEstoque());
    }
}
