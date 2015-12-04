/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tributum.controller;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Gilberto Gaspar
 */
public class FIleController {
    private static File arquivo;
    private final String diretorio = "C:\\Users\\Gilberto Gaspar\\Documents\\Projects\\tributum\\";
    
    public static File getArquivo() {
        return arquivo;
    }

    public static void setArquivo(File arquivo) throws IOException {
        if(arquivo.exists())
            this.arquivo = arquivo;
        else{
            arquivo.createNewFile();
            this.arquivo = arquivo;
        }
    }

    public static File buscarArquivo(String nomeArquivo) throws IOException{
        FIleController.setArquivo(new File(diretorio+nomeArquivo));
        return FIleController.getArquivo();      
     
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
            
            while(!linha != null){
                valores[cont] = linha;
                cont+=1;
                linha = lerLinha.readLine();
            }
            
            return valores;
        }catch(IOException i){
            throw new IOException("Erro na leitura do arquivo "+diretorio);
        }
                
    }
    
    public static boolean gravarArquivo(String diretorio, String[] dados) throws IOException{
        FileWriter escrita = new FileWriter(FIleController.getMapArquivos().get(diretorio));
        BufferedWriter buffEscrita = new BefferedWriter(escrita);
        
        for(String dado: dados){
            escrita.write(dado);
        }
        
        
        return true;
    }

}
