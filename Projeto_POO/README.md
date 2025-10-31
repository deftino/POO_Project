#PROJETO_POO_SistemaInvent�rio

#INTEGRANTES
- Aluno: Guilherme Cavalcanti Amorim
- RA: 00000852347

#CONTE�DO
[SOBRE]
[FUNCIONALIDADES]
[TECNOLOGIAS]
[COMO USAR]
[ESTRUTURA]
[PROCESSO]

#SOBRE
- O projeto foi criado para o auxilio de empresas de pequeno a m�dio porte a ger�nciar e administrar seus invent�rios de maneira mais f�cil, r�pida e segura, fazendo com que seus usu�rios otimizem muito mais o tempo que gastariam investigando o invent�rio de suas pr�prias empresas. 

#FUNCIONALIDADES
- O projeto conta com funcionalidades de Login e de Invent�rio, sendo elas:
- LOGIN: Cadastro, Login de usu�rio(os dados cadastrados s�o salvos)
- INVENT�RIO: Adi��o, Remo��o, Atualiza��o(por ID) e Busca de itens(por ID), onde tamb�m pode-se mostrar toda a sua lista de itens feitos at� o dado momento(os itens cadastrados s�o atrelados a conta pela qual voc� fez login e mantidos por ela).
- V�deos: 
- Gerenciamento: https://youtu.be/H9VYU69Ci-U (perd�o pela m� qualidade)
- Login: https://youtu.be/E8LLfd-Tmuk  (perd�o pela m� qualidade)

#TECNOLOGIAS
- JAVA 15(�nica linguagem usada no projeto), javax.swing(Biblioteca utilizada para Interface gr�fica), java.awt(utilizada para auxiliar a interface gr�fica assim como o sistema de eventos), java.util(estrutura de dados como hashmaps e listas), java.io(utilizado para a persist�ncia dos dados inseridos).

#COMO USAR
- Para utilizar o programa deve-se preencher os campos de Usu�rio e Senha, o sistema j� vem com o usu�rio: "admin" e a senha: "admin1234" cadastrados por padr�o, caso o usu�rio planeje cadastrar outra conta, ele deve preencher os campos de Usu�rio e Senha, onde ambos devem ter pelo menos 5 caract�res, o nome de Usu�rio cadastrado n�o pode ser o mesmo de outro usu�rio j� cadastrado, ap�s a mensagem de cadastro, basta dar Login. 
Ao entrar na p�gina "GERENCIAMENTO DE INVENT�RIO", o usu�rio pode adicionar, remover, atualizar e buscar itens ao mesmo tempo que pode imprimir todos os itens, cada item poss�i: ID(�nico), nome, quantidade, pre�o. 
Para adicionar um item, basta preencher os campos de ID, nome, quantidade e preco e clicar no bot�o "Adicionar", onde preco e quantidade devem ser n�meros, a quantidade de centavos pode ser incluida utilizando o formato "XX.XX", dois itens n�o podem compartilhar o mesmo ID. 

- Para remover um item, basta preencher o campo do ID com o ID do item a ser removido e clicar no bot�o "Remover", ap�s isso, o item ser� removido.   

- Para atualizar as informacoes do item, deve preencher todos os campos, contendo o ID do item a ser atualizado, todos os outros campos podem ser alterados para a atualiza��o, campos os quais voc� n�o deseja que sejam atualizados, devem ser preenchidos da mesma maneira que estava preenchido originalmente, ap�s isso, o usu�rio deve pressionar o bot�o "Atualizar".

- Para buscar um item, o usu�rio deve preencher o campo de ID com o ID original do item a ser buscado e pressionar o bot�o "Buscar", o item ent�o ser� mostrado no canto inferior da tela com todas as suas caracter�sticas.

- Para o usu�rio ver todos os itens atualmente em sua lista, basta clicar na op��o "Mostrar todos", onde todos os itens cadastrados no momento ser�o expostos no canto inferior da tela, caso nenhum item esteja cadastrado atualmente, uma mensagem dizendo que n�o existe nenhum item atualmente ser� mostrada.

#ESTRUTURA
- O projeto � estruturado em packages, sendo eles: 
- (default package) -> Main.java
- login.pk -> Autenticacao.java, GerenciadorDados.java, Paginalogin.java
- mgmt.pk -> ListaProd.java, PaginaMngmt.java, Produto.java

#PROCESSO
- O processo do trabalho foi dividido em 3 etapas, a cria��o da p�gina de login, a cria��o do sistema de listamento de itens e a cria��o do gerenciador de dados
- Login: A p�gina de login foi a primeira criada, sendo a mais r�pida de todas as etapas, onde o usu�rio e a senha s�o postos em um HashMap<> que atualmente est� em usuarios.dat, mas que antes estava separado em Autentica��o.java, a cria��o da p�gina em si foi consideravelmente r�pida e a parte mais divertida at� ent�o.
- Listamento: Essa foi a segunda parte mais demorada do projeto, o maior desafio foi entender como criar novos objetos sem instanci�-los e como poder refer�ncia-los, a cria��o da p�gina em si seria relativamente f�cil se n�o fosse pelo scroll que eu resolvi integrar no campo onde os itens aparecem, aprender a us�-lo foi complicado, mas uma hora funcionou
- Gerenciador de dados: A parte mais trabalhosa do projeto, onde a biblioteca Serializable foi utilizada para salvar os dados nos arquivos "usuarios.dat" e "inventarios.dat", onde � agregado um inventario a cada usu�rio cadastrado, o sistema funciona salvando os objetos(HashMap e Lista) em arquivos.dat, onde depois sao desserializados e carregados e reconstru�dos em mem�ria, permitindo assim a persist�ncia de todos os dados em mem�ria, mesmo sendo uma serializa��o simples de itens, eu demorei muito tempo para decifrar como ia ser implementado no programa sem ter que refazer tudo, esse projeto tem meu maior uso da biblioteca Serializable at� hoje. 