#PROJETO_POO_SistemaInventário

#INTEGRANTES
- Aluno: Guilherme Cavalcanti Amorim
- RA: 00000852347

#CONTEÚDO
[SOBRE]
[FUNCIONALIDADES]
[TECNOLOGIAS]
[COMO USAR]
[ESTRUTURA]
[PROCESSO]

#SOBRE
- O projeto foi criado para o auxilio de empresas de pequeno a médio porte a gerênciar e administrar seus inventários de maneira mais fácil, rápida e segura, fazendo com que seus usuários otimizem muito mais o tempo que gastariam investigando o inventário de suas próprias empresas. 

#FUNCIONALIDADES
- O projeto conta com funcionalidades de Login e de Inventário, sendo elas:
- LOGIN: Cadastro, Login de usuário(os dados cadastrados são salvos)
- INVENTÁRIO: Adição, Remoção, Atualização(por ID) e Busca de itens(por ID), onde também pode-se mostrar toda a sua lista de itens feitos até o dado momento(os itens cadastrados são atrelados a conta pela qual você fez login e mantidos por ela).
- Vídeos: 
- Gerenciamento: https://youtu.be/H9VYU69Ci-U (perdão pela má qualidade)
- Login: https://youtu.be/E8LLfd-Tmuk  (perdão pela má qualidade)

#TECNOLOGIAS
- JAVA 15(Única linguagem usada no projeto), javax.swing(Biblioteca utilizada para Interface gráfica), java.awt(utilizada para auxiliar a interface gráfica assim como o sistema de eventos), java.util(estrutura de dados como hashmaps e listas), java.io(utilizado para a persistência dos dados inseridos).

#COMO USAR
- Para utilizar o programa deve-se preencher os campos de Usuário e Senha, o sistema já vem com o usuário: "admin" e a senha: "admin1234" cadastrados por padrão, caso o usuário planeje cadastrar outra conta, ele deve preencher os campos de Usuário e Senha, onde ambos devem ter pelo menos 5 caractéres, o nome de Usuário cadastrado não pode ser o mesmo de outro usuário já cadastrado, após a mensagem de cadastro, basta dar Login. 
Ao entrar na página "GERENCIAMENTO DE INVENTÁRIO", o usuário pode adicionar, remover, atualizar e buscar itens ao mesmo tempo que pode imprimir todos os itens, cada item possúi: ID(único), nome, quantidade, preço. 
Para adicionar um item, basta preencher os campos de ID, nome, quantidade e preco e clicar no botão "Adicionar", onde preco e quantidade devem ser números, a quantidade de centavos pode ser incluida utilizando o formato "XX.XX", dois itens não podem compartilhar o mesmo ID. 

- Para remover um item, basta preencher o campo do ID com o ID do item a ser removido e clicar no botão "Remover", após isso, o item será removido.   

- Para atualizar as informacoes do item, deve preencher todos os campos, contendo o ID do item a ser atualizado, todos os outros campos podem ser alterados para a atualização, campos os quais você não deseja que sejam atualizados, devem ser preenchidos da mesma maneira que estava preenchido originalmente, após isso, o usuário deve pressionar o botão "Atualizar".

- Para buscar um item, o usuário deve preencher o campo de ID com o ID original do item a ser buscado e pressionar o botão "Buscar", o item então será mostrado no canto inferior da tela com todas as suas características.

- Para o usuário ver todos os itens atualmente em sua lista, basta clicar na opção "Mostrar todos", onde todos os itens cadastrados no momento serão expostos no canto inferior da tela, caso nenhum item esteja cadastrado atualmente, uma mensagem dizendo que não existe nenhum item atualmente será mostrada.

#ESTRUTURA
- O projeto é estruturado em packages, sendo eles: 
- (default package) -> Main.java
- login.pk -> Autenticacao.java, GerenciadorDados.java, Paginalogin.java
- mgmt.pk -> ListaProd.java, PaginaMngmt.java, Produto.java

#PROCESSO
- O processo do trabalho foi dividido em 3 etapas, a criação da página de login, a criação do sistema de listamento de itens e a criação do gerenciador de dados
- Login: A página de login foi a primeira criada, sendo a mais rápida de todas as etapas, onde o usuário e a senha são postos em um HashMap<> que atualmente está em usuarios.dat, mas que antes estava separado em Autenticação.java, a criação da página em si foi consideravelmente rápida e a parte mais divertida até então.
- Listamento: Essa foi a segunda parte mais demorada do projeto, o maior desafio foi entender como criar novos objetos sem instanciá-los e como poder referência-los, a criação da página em si seria relativamente fácil se não fosse pelo scroll que eu resolvi integrar no campo onde os itens aparecem, aprender a usá-lo foi complicado, mas uma hora funcionou
- Gerenciador de dados: A parte mais trabalhosa do projeto, onde a biblioteca Serializable foi utilizada para salvar os dados nos arquivos "usuarios.dat" e "inventarios.dat", onde é agregado um inventario a cada usuário cadastrado, o sistema funciona salvando os objetos(HashMap e Lista) em arquivos.dat, onde depois sao desserializados e carregados e reconstruídos em memória, permitindo assim a persistência de todos os dados em memória, mesmo sendo uma serialização simples de itens, eu demorei muito tempo para decifrar como ia ser implementado no programa sem ter que refazer tudo, esse projeto tem meu maior uso da biblioteca Serializable até hoje. 