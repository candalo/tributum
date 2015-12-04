/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.controller;

import tributum.model.EmptyException;
import tributum.model.Imposto;
import tributum.model.NomeException;
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
     * @throws NomeException, Exception
     */
    public static void cadastrarProduto(DadosProdutosGUI dadosProdutosGui) throws NomeException, Exception{
        String valorProduto;
        valorProduto = dadosProdutosGui.valorTextField.getText().replace(".", "");
        valorProduto = valorProduto.replace(",", ".");
        try{
            ProdutoController.setProduto(new Produto(dadosProdutosGui.nomeProdutoTextField.getText(),
                                             Double.parseDouble(valorProduto)));
        }catch(NomeException n){
            throw new NomeException(n.getMessage());
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
    
    /**
     * @param  produtoAux; Recebe o obj da classe Produto, calcula os impostos.
     * @return  String; Retorna o valor do produto, e os impostos, para exibição ao usuário.
     * @throws NullPointerException, EmptyException, NomeException e Exception
     * 
     */
    public static String calcularImpostosProduto(Produto produtoAux) throws NullPointerException, EmptyException, NomeException, Exception{
        Imposto[] impostos = new Imposto[4];
        String mensagem = "";
        try{
            impostos = ProdutoController.calculandoImpostos(produtoAux.getPreco());
        
            for(Imposto tributum: impostos){
                mensagem += tributum.getNomeImposto()+" R$"+Double.toString(tributum.getValorImposto())+"/n";
            }
            
            mensagem += " Soma dos impostos: R$"+Double.toString(produtoAux.valorTotalImposto(impostos));
        }catch(NomeException n){
            throw new NomeException(n.getMessage());
        }catch(NullPointerException np){
            throw new NullPointerException(np.getMessage());
        }catch(EmptyException ee){
            throw new EmptyException(ee.getMessage());
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        
        return mensagem;
    }
    
    /**
     * Método que abstrai os calculos e a criacao do array de impostos.
     * @param doble valorProduto, os calculos são baseados neste valor.
     * @throws NomeException, Exception. Caso nomes não esteja válido ou ocorrer algum outro erro
     * @return impostos[].
     */
    private static Imposto[] calculandoImpostos(double valorProduto) throws NomeException, Exception{
        Imposto[] impostos = new Imposto[4];
        
        try{
            impostos[0] = new Imposto("ICMS", valorProduto * 0.07);
        
            impostos[1] = new Imposto("IPI", valorProduto * 0.05);
        
            impostos[2] = new Imposto("PIS", valorProduto * 0.165);

            impostos[3] = new Imposto("COFINS", valorProduto * 0.76);
        }catch(NomeException n){
            throw new NomeException(n.getMessage());
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
        return impostos;
    }
}
