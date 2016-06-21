/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffMan;

/**
 *
 * @author fabio.tpereiro
 */
public class Node {
    
    private Integer freq;
    private char caracter;
    private Node esq;
    private Node dir;
    private int listaInt[];
    
    public Node () {
        freq = null;
        esq = null;
        dir = null;
        listaInt = null;
     }
    
    public int getListaInt(int indice){
        return listaInt[indice];
    
    }
    public int tamanhoInt(){
        return listaInt.length;
    
    }
    
    

    
    
   
    

    
    public int[] getListaInt(){
       return listaInt; 
    
    }
    
    public void setListaInt(Lista listaa){
        listaInt = new int [listaa.tamanhoInt()];
        for (int i=0; i< listaa.tamanhoInt(); i+=1) {
            listaInt[i]= listaa.getListaIntValor(i);
        }
        
    }
    
    public void printLista(){
        //se esquerda e direita nulos, entao achei um no folha!
        if(dir == null && esq == null){
            System.out.print("Node [" + caracter + "] :");
            printListaint();
            System.out.println("\n");
        }
        
    
    }
    
    public void printListaint(){
        if (listaInt != null) {
            for (int i=0; i < listaInt.length; i+=1)
                System.out.print(listaInt[i]+", ");
        }
    
    }
    
            
    

    public Integer getFreq() {
        return freq;
    }

    public void setFreq(Integer freq) {
        this.freq = freq;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }   

    public Node getEsq() {
        return esq;
    }

    public void setEsq(Node esq) {
        this.esq = esq;
    }

    public Node getDir() {
        return dir;
    }

    public void setDir(Node dir) {
        this.dir = dir;
    }
    
    public boolean ehFolha () {
        return dir == null && esq == null;
    }
    
    
            
    
}
