package huffMan;

import java.util.ArrayList;

//* Lista que pode ser usada para armazenar os nós na montagem da árvore de huffman
public class Lista {
        
    private ArrayList<Node> listaNode = new ArrayList<Node> ();
    private ArrayList listaInt = new ArrayList();
    

    
    public void inserirValorInt(int valor){
        listaInt.add(valor);
        
    }
    
    public void removerValorInt(){
        if(!listaInt.isEmpty())
            listaInt.remove(listaInt.size() - 1);
    }
    
    public int[] getListaInt(){
        int[] aux = new int[listaInt.size()];
        
        for(int i = 0; i < listaInt.size(); i++){
            aux[i] = (int)listaInt.get(i);
        }
        return aux;
    
    }
    
    
    
    
    
    
    
    public void inserirNode (Node no) {
        listaNode.add(no);
    }
    
    public void removerNode (int idx) {
        listaNode.remove(idx);
    }
    
    
    public Node getNode (int idx){
        return listaNode.get(idx);
    }
    
    public int tamanhoNode () {
        return listaNode.size();
    }
    
    public int tamanhoInt () {
        return listaInt.size();
    }
    
    public void printListaNode(){
        for(int i = 0; i < listaNode.size(); i++){
            if(listaNode.get(i).getFreq() > 0)
                System.out.println(listaNode.get(i).getCaracter() + ":" + listaNode.get(i).getFreq());
        
        }
    
    }
    
    public void clean(){
        listaInt.clear();
        listaInt.clear();
    }
    
    public void printListaInt(){
        for(int i = 0; i < listaInt.size(); i++){
            System.out.print((int)listaInt.get(i) + ", ");
        
        }
    
    }
    
    public int getListaIntValor(int indice){
    return (int)listaInt.get(indice);
    
    }
   
}
