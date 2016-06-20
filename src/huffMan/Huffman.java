//referencia para uso da classe Arquivo e implementação de partes do algoritmo de Huffman
package huffMan;

public class Huffman {
    
    private Node raiz;   
    
    public Huffman () {
        raiz = null;
    }    
  
    public void compactar (String origem, String destino) throws Exception {
        int freq[] = new int [256];
        Arquivo file = Arquivo.getInstance();
        //parte 0 - abre o arquivo de texto pela primeira vez, para montar a tabela de frequencia
        file.abreArquivoTextoLeitura(origem);

        byte caracter;
        //parte 1 - le o arquivo e monta a tabela de frequencia
        while ( (caracter =(byte) file.leCaracterArquivoTexto()) != -1) {
            //soma 1 na frequencia da posicao indicada pelo valor do caracter
            //exemplo: caracter = 'a' é a mesma coisa que caracter = 97
            //freq[caracter] = freq[97]
            freq[caracter]+=1;
        }
       
        //CODIGO ILUSTRATIVO, NAO PRECISA ESTAR NA VERSAO FINAL
        //imprime tabela de frequencia, percorrendo os 256 possiveis valores de um byte/char
        for (int i=0; i< 256; i+=1) {
            //soh imprime se a frequencia for maior que zero
            if (freq[i]>0) {
                //imprime os caracteres que não são pulo de linhas
                if ( ((char)i)!='\n' && ((char)i)!='\r')
                    System.out.println("freq['"+((char)i)+"']="+freq[i]);
                //imprime o pulo de linha \n (newline)
                if ( ((char)i)=='\n' )   
                     System.out.println("freq['\\n']="+freq[i]);
                //imprime o pulo de linha \r (return)
                if ( ((char)i)=='\r' )   
                     System.out.println("freq['\\r']="+freq[i]);                
            }
        }

        //seu código para criar a lista de nós vai aqui
        Lista nos = new Lista();
        //percorre o vetor, caso o freq seja maior q ZERO, cria um node adicionando a letra e a frequencia. Insere na lista o NODE.
         for (int i = 0; i < 256; i+=1) {
            //soh imprime se a frequencia for maior que zero
            if (freq[i]>0) {
                Node node = new Node();
                node.setFreq(freq[i]);
                node.setCaracter((char)i);
                nos.inserir(node);
            }
         }
         //verificar se a lista esta correta. PRint List
         //nos.printLista();
        
         //parte 3 - monta a arvore, iterando sobre a lista até ela ter tamanho 1
         //seu código de montagem da arvore na lista vai aqui
         //variaveis de controle
         Integer menor = Integer.MAX_VALUE;
         Integer indice = 0;
         Node novo1 = new Node();
         Node novo2 = new Node();
         
         
         //MONTAR A ARVORE
         while(nos.tamanho() > 1){
             //percorre a lista e pega o menor valor
            for(int i = 0; i < nos.tamanho(); i++){
                if(nos.get(i).getFreq() < menor){
                    indice = i;
                    menor = nos.get(i).getFreq();
                }
            }
            //variaveis de controle
            //associar o menor valor ao novo node
            //ressetar as variaveis
            novo1 = nos.get(indice);
            nos.remover(indice);
            menor = Integer.MAX_VALUE;
            
            //percorre a lista e pega o menor valor
            for(int i = 0; i < nos.tamanho(); i++){
                if(nos.get(i).getFreq() < menor){
                    indice = i;
                    menor = nos.get(i).getFreq();
                }
            }
            //variaveis de controle
            //associar o menor valor ao novo node
            //ressetar as variaveis
            novo2 = nos.get(indice);
            nos.remover(indice);
            menor = Integer.MAX_VALUE;
            
            Node novo3 = new Node();
            novo3.setFreq(novo1.getFreq() + novo2.getFreq());
            
            
            // garante que o menor fique sempre a esquerda
            if(novo1.getFreq() < novo2.getFreq()){
                novo3.setEsq(novo1);
                novo3.setDir(novo2);
            }
            else{
                novo3.setEsq(novo2);
                novo3.setDir(novo1);
            }
            
            nos.inserir(novo3);
            
  
         }
       
        //parte 4 - atualiza raiz da arvore com o no que restou na lista | this.raiz = nos.get(0);
         this.raiz = nos.get(0);
        //pode imprimir a arvore depois de atualizar a raiz para dar uma conferida
        this.print();
         //parte 5 - cria tabela de códigos 
        
        //SUGESTÃO - usar uma matriz de inteiros
        //sabemos que tem até 256 tipos diferente de caracteres na nossa tabela de 
        //frequencia, mas ainda nao sabemos o tamanho dos códigos.
        //por exemplo:
        //a = 97... se o código para o caracter 'a' for 01001, então
        //codigos['a'] = codigos[97] = new int[5];
        //codigos['a'][0] = 0;
        //codigos['a'][1] = 1;
        //codigos['a'][2] = 0;
        //codigos['a'][3] = 0;
        //codigos['a'][4] = 1;
        int codigos[][] = new int[256][];
        percorrerArvore(raiz);
        
        
        
        
        
        
        
        
        
        
        
        //parte 6 - preencher a tabela de códigos percorrendo a arvore, guardando o caminho em 
        //pilha e atualizando a tabela sempre que encontrar um nó folha
        //fiz um metodo auxiliar da pilha, para que seja possivel obter 
        //os valores da pilha sem ter que desempilhar e empilhar tudo denovo
        //método - int[] fotografiaPilha ()
        Pilha pilha = new Pilha ();
        
        
       
        //seu código para obter os códigos de cada caracter vai aqui
        
        //CODIGO ILUSTRATIVO, NAO PRECISA ESTAR NA VERSAO FINAL
        //imprime tabela de código para os caracteres que tem frequencia maior que 0
        for (int i=0; i< 256; i+=1) {
            //soh imprime se a frequencia for maior que zero
            if (freq[i]>0) {
                //imprime os caracteres que não são pulo de linhas
                int[] codigo = codigos[i];
                if (codigo == null)
                    continue;
                if ( ((char)i)!='\n' && ((char)i)!='\r')
                    System.out.print("codigos['"+((char)i)+"']=");
                //imprime o pulo de linha \n (newline)
                if ( ((char)i)=='\n' )   
                     System.out.println("codigos['\\n']=");
                //imprime o pulo de linha \r (return)
                if ( ((char)i)=='\r' )   
                     System.out.println("codigos['\\r']=");  
                for (int j=0; j< codigo.length; j+=1) {
                    System.out.print(codigo[j]);
                }
                System.out.println();
            }
        }
        
        //parte 7 - abre o arquivo binario
        file.abreArquivoBinarioEscrita(destino, freq);
        
        //parte 8 - reabre o arquivo texto
        file.abreArquivoTextoLeitura(origem);
        
        //parte 9 - percorre o arquivo texto, caracter a caracter, procurando 
        //o codigo para cada caracter e gravando a sequencia de bits com 
        //a funcao file.escreveBit        
        while ( (caracter =(byte) file.leCaracterArquivoTexto()) != -1) {
            System.out.print((char)caracter);
            //obtem o código
            int [] codigo = codigos[caracter];
            if (codigo == null)
                continue;
            //escreve os bits no arquivo binario 
            for (int i=0; i< codigo.length; i+=1) {
                file.escreveBit(codigo[i]);               
            }
        }
        
        //parte 10 - fecha arquivos
        file.fechaArquivoBinarioEscrita();
        file.fechaArquivoTextoLeitura();
        
    }
    
    public void descompactar (String origem, String destino) throws Exception {
        int freq[] = new int [256];
        Arquivo file = Arquivo.getInstance();        
        //parte 0 - abre o arquivo binario e guarda o numero de bits que precisam
        //ser lidos
        long numeroDeBitsParaLer = file.abreArquivoBinarioLeitura(origem);
        
        //parte 1 - le tabela de frequencia guardada no arquivo binario
        freq = file.leTabelaFrequencia();
        
        //parte 2 - abre o arquivo de texto para escrita do documento descompactado
        file.abreArquivoTextoEscrita(destino);
        
        //parte 3 - monta a arvore de huffman a partir da tabela de frequencia (igual no compactar)
        
        //parte 4 - monteagem da arvore - cria lista de nós com a informacao da tabela de frequencia
        Lista nos = new Lista();
        //seu código de montagem da lista vai aqui
        
        //parte 5 - monta a arvore, iterando sobre a lista até ela ter tamanho 1
        
        //seu código de montagem da arvore na lista vai aqui
        
        //parte 6 - atualiza raiz da arvore com o no que restou na lista | this.raiz = nos.get(0);
        //pode imprimir a arvore depois de atualizar a raiz para dar uma conferida
        //this.print ();
        
        //parte 7 - le bit a bit o arquivo binario, percorre a arvore e grava o 
        //caracter encontrado no arquivo de texto        
       
        //exemplo da leitura bit a bit do arquivo
        for (int i=0; i < numeroDeBitsParaLer; i+=1) {            
            int bit = file.leBit();           
                
            
        }
        
        //parte 8 fecha os arquivos
        file.fechaArquivoBinarioLeitura();
        file.fechaArquivoTextoEscrita();
    }
    
    
    
    
    //retorna o nó de menor frequencia, retirando-o da lista de nós passada como parametro
    private Node removeMenorFrequencia (Lista l) {
        int idx=-1;
        int menor = Integer.MAX_VALUE;
        for (int i =0; i < l.tamanho(); i+=1) {
            if (l.get(i).getFreq() < menor) {
                menor = l.get(i).getFreq();
                idx = i;
            }
        }            
        Node result = l.get(idx);
        l.remover(idx);
        return result;
        
    }
    
    //imprime a arvore
     public void print () {
        printAux(raiz, 0);
    }
    
     //auxilia na impressao da arvore
    private void printAux (Node no, Integer nivel) {
        
        for (int i=0; i< nivel; i++) {
            System.out.print("\t");
        }
        if (no == null) {
            System.out.println("\\- NULO");
            return;
        }
        else {
            if (no.ehFolha())
                System.out.println("\\- " + no.getFreq()+"-("+no.getCaracter()+")");        
            else
                System.out.println("\\- " + no.getFreq());        
        }
        printAux(no.getEsq(), nivel+1);
        printAux(no.getDir(), nivel+1);
    }
    
    
    public void percorrerArvore(Node raiz){
        if(raiz != null){
            Lista lista = new Lista();
            
            lista = percorrerArvoreAux(raiz,lista);
            //lista.printListaInt();
    
        }
    }
    
    //percorrer arvore retornando a lista de indices
    private Lista percorrerArvoreAux(Node node, Lista lista){
        
        if(!node.ehFolha()){
            if(node.getEsq() != null){
                lista.inserirValor(0);
                percorrerArvoreAux(node.getEsq(),lista);
            }
            
            if(node.getDir() != null){
                lista.inserirValor(1);
                percorrerArvoreAux(node.getDir(),lista);
                
            }
            
   
        }
        //qse certo.. vmo q vmo
        System.out.print(node.getCaracter() + ":");
        lista.printListaInt();
        //grava a informacao do codigo binario no proprio no folha
        if(node.getDir() == null && node.getEsq() == null){
            node.setLista(lista);
        }
        // gerar uma lista com o caracter e a sequencia de bits
        node.printLista();
        System.out.println("\n");
        lista.removerValor();
        return lista;
    
    }
    
    
    
}
