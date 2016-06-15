package huffMan;

import java.util.ArrayList;

//* Lista que pode ser usada para armazenar os nós na montagem da árvore de huffman
public class Lista {
        
    private ArrayList<Node> data = new ArrayList<Node> ();
    private ArrayList listaValor = new ArrayList();
    

    
    public void inserirValor(int valor){
        listaValor.add(valor);
        
    }
    
    public void removerValor(){
        if(!listaValor.isEmpty())
            listaValor.remove(listaValor.size() - 1);
    }
    
    public int[] getListaValor(){
        int[] aux = new int[listaValor.size()];
        
        for(int i = 0; i < listaValor.size(); i++){
            aux[i] = (int)listaValor.get(i);
        }
        return aux;
    
    }
    
    
    
    
    
    
    
    public void inserir (Node no) {
        data.add(no);
    }
    
    public void remover (int idx) {
        data.remove(idx);
    }
    
    
    public Node get (int idx){
        return data.get(idx);
    }
    
    public int tamanho () {
        return data.size();
    }
    
    public void printLista(){
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).getFreq() > 0)
                System.out.println(data.get(i).getCaracter() + ":" + data.get(i).getFreq());
        
        }
    
    }
    
}