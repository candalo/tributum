/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.controller;

import tributum.model.Produto;
import tributum.view.DadosProdutosGUI;

/**
 *
 * @author Gilberto Gaspar
 */
public class ProdutoController {
    private static Produto produto;

    public static Produto getProduto() {
        return produto;
    }

    public static void setProduto(Produto produto) {
        ProdutoController.produto = produto;
    }
    
    /**
     * @param dadosProdutosGui; Recebe View para manipulação das informações obtidas
     *  e criar obj da classe Produto.
     * @return void.
     * @throws Lucas Acrescente as emissoes de excecoes.
     */
    public static void cadastrarProduto(DadosProdutosGUI dadosProdutosGui){
        
    }
    
    /**
     * @param  produtoAux; Recebe o obj da classe Produto, calcula os impostos.
     * @return  String; Retorna o valor do produto, e os impostos, para exibição ao usuário.
     * @throws Lucas Acrescente as emissoes de excecoes.
     */
    public static String calcularImpostosProduto(Produto produtoAux){
        return "";
    }
}
