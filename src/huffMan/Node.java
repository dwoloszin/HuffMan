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
    private Lista lista;
    
    public Node () {
        freq = null;
        esq = null;
        dir = null;
        lista = new Lista();
     }
    
    public int getListaValor(int indice){
        return lista.getListaValor(indice);
    
    }
    public int getListaTamanho(){
        return lista.tamanholistaValor();
    
    }
    
    

    
    
    public void inserirlist(int valor){
        lista.inserirValor(valor);
    }
    
    public void removerlista(int indice){
    lista.remover(indice);
    }
    
    public Lista getLista(){
       return lista; 
    
    }
    
    public void setLista(Lista listaa){
        this.lista = listaa;
    }
    
    public void printLista(){
        //se esquerda e direita nulos, entao achei um no folha!
        if(dir == null && esq == null){
            System.out.print("Node [" + caracter + "] :");
            lista.printListaInt();
            System.out.println("\n");
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
