Arquivos anexados:
Arquivo Huffman.zip (1,394 MB)
Instru��es nos ultimos slides da aula de Huffman. Lembrem-se:

S� pode usar as estruturas de dados vista/desenvolvidas em aula
Comentar todo if/ for/ while
Data de Entrega: 21/06 

Em anexo, um projeto base com tudo o que � necessario para executar o trabalho. 

A classe Arquivo.java trabalha com os arquivos, abrindo, lendo e fechando arquivos binarios e de texto.
A classe Huffman.java � um template vazio para implementa��o. (implementar m�todos compactar e descompactar)
A classe HuffmanExemplo.java tem os m�todos pr� implementados (falta partes), para servir de referencia para o entendimento do uso da classe Arquivo 
J� tem dois arquivos de exemplo para testes:

tigre.txt (exemplo da aula)
bibleUTF8.txt (biblia em ingles)
Como gerar um JAR?

Imaginando que o projeto fica na pasta: C:\Users\Fabio\Documents\NetBeansProjects\Huffman

Dentro do Netbeans, clique com o bot�o direito no projeto e escolha "Limpar e Construir"

O arquivo JAR ser� criado dentro da pasta dist

C:\Users\Fabio\Documents\NetBeansProjects\Huffman\dist\Huffman.jar

Como executar?

Na linha de comando, dentro da pasta com o jar (lembre-se de copiar os arquivos textos para a pasta), use:

Compactar: java -jar Huffman.jar -c tigre.txt tigre.huf

Descompactar: java -jar Huffman.jar -d tigre .huf tigre2.txt