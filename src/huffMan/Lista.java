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
    
    public int tamanhoDados () {
        return data.size();
    }
    
    public int tamanholistaValor () {
        return listaValor.size();
    }
    
    public void printLista(){
        for(int i = 0; i < data.size(); i++){
            if(data.get(i).getFreq() > 0)
                System.out.println(data.get(i).getCaracter() + ":" + data.get(i).getFreq());
        
        }
    
    }
    
    public void clean(){
        listaValor.clear();
        listaValor.clear();
    }
    
    public void printListaInt(){
        for(int i = 0; i < listaValor.size(); i++){
            System.out.print((int)listaValor.get(i) + ", ");
        
        }
    
    }
    
    public int getListaValor(int indice){
    return (int)listaValor.get(indice);
    
    }
    
    public void printListaNoComValores(){
        for(int i = 0; i < data.size(); i++){
            System.out.print(data.get(i).getCaracter() + ":[");
            Lista lista1 = new Lista();
            lista1 = data.get(i).getLista();
            for(int j = 0; j < lista1.tamanholistaValor(); j++){
                System.out.print(lista1.getListaValor(j));  
            
            }
            System.out.println("");
        
        }
    
    }
    
    
    
    
}
