/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.controller;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gilberto Gaspar
 */
public class FIleController {
    private static Map<String,File> mapArquivos;

    public static Map<String, File> getMapArquivos() {
        return mapArquivos;
    }

    /**
     * @param mapArquivos Map<String, File>, Recebe o mapa de arquivos.
     */
    public static void setMapArquivos(Map<String, File> mapArquivos) {
        FIleController.mapArquivos = mapArquivos;
    }
    
    public static File buscarArquivo(String diretorio){
        return FIleController.getMapArquivos().get(diretorio);
    }
    
    public static File armazenarArquivo(String diretorio, File arquivo){
        return FIleController.getMapArquivos().put(diretorio, arquivo);
    }
    
    public static String[] lerArquivo(String diretorio) throws IOException{
        File arquivo;
        String[] valores = new String[10];
        int cont =0;
        
        try{
            arquivo = FIleController.buscarArquivo(diretorio);
        
            FileReader ler = new FileReader(arquivo);
            BufferedReader  lerLinha = new BufferedReader(ler);
            String linha = lerLinha.readLine();
            
            while(!linha.equals("%")){
                valores[cont] = linha;
                cont+=1;
                linha = lerLinha.readLine();
            }
            
            return valores;
        }catch(IOException i){
            throw new IOException("Erro na leitura do arquivo "+diretorio);
        }
                
    }

}
