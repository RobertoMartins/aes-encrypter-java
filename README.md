# AES Encrypter 
Implementação do Advanced Encryption Standard (AES, ou Padrão de Criptografia Avançada, em português), também conhecida pelo seu nome original Rijndael, é uma especificação para criptografia de dados eletrônicos.
Essa implementação é uma adaptação do codigo em Java apresentado no capitulo 12 do livro <b>Foundations of Security - What Every Programmer Needs to Know</b>.

# Como executar
<ol>
  <li>Clone ou baixe o projeto em seu PC 
    <code> git clone https://github.com/RobertoMartins/aes-encrypter-java.git</code>
  </li>
  
  <li>Abra na IDE que deseja</li>
  <li>Execute a classe Run</li>
  </ol>

## Arquivos
<b>mykey: </b> Chave criada para criptografar. É possivel criar outra no inicio do programa ou escolhendo a opçao 1 do menu.<br/>
<b>textoOriginal:</b> Arquivo de texto onde se deve colocar o texto que deseja criptografar;
Outos arquivos serão criados durante a execução;

## Funcionamento

Para facilitar a execução, todos os arquivos que são lidos e criados estão na pasta raiz do projeto.<br/>
Ao iniciar será solicitado o arquivo da chave, na pasta do projeto ja exite o arquivo <b>mykey</b>. Após digitar o nome, será exibido o menu.<br/>
<ul>
<li>Na opção 1, é possivel criar uma nova chave, basta digitar o nome do arquivo e reiniciar o programa com a nova chave para usa-la.</li>
<li>Na opção 2, basta digitar o nome do arquivo que deseja criptografar, na pasta do projeto, irá aparecer um novo arquivo de texto com o conteúdo criptografado.</li>
<li>Na opção 3, para descriptografar um arquivo, basta digitar o nome do arquivo. Lembrando que a chave utilizada deve ser a mesma que usou para criptografar.</li>
<li>A opção 4 finaliza a aplicação.
</ul>
