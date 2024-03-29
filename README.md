# java-Sistema_senha

Software que simula um sistema de chamadas de senha por prioridade de atendimento. 

## • Funcionalidades

**Simula um painel de senhas:** Escolha o tipo de atendimento, chame a senha no painel em oredem e por prioridadde.

## • Instalação e Uso

1. Clone este repositório.
2. Instale o ambiente de desenvolvimento **[NetBeans](https://netbeans.apache.org/front/main/download/index.html).**
3. Instale o gerenciador de banco de dados **[HeidiSQL](https://www.heidisql.com/download.php).**
4. Instale o host de servidores locais abertos **[XAMPP](https://www.apachefriends.org/download.html)**.
5. Inicie o serviço do Mysql: No Xampp Control Panel, clique no botão “Start” ao lado do serviço do Mysql.
6. Com o Xampp aberto,xecute o **HeidiSQL**. Clique em `Nova` no canto inferior esquerdo e depois na opção `Sessão, na pasta raiz`. Escolha um nome para a nova sessão. Como tipo de rede, escolha "MySQL (TCP/IP)". Informe o "Servidor / IP" como sendo o seu domínio ou nome do servidor. O "Usuário", "Senha" e "Bancos de dados" são o usuário, senha e o banco de dados, respectivamente. Clique em "Salvar" perto do canto inferior esquerdo para gravar a sessão e, em seguida, "Abrir", para testar a conexão. **Caso não seja definido, usuário e senha por padrão será: "root" e campo senha vazio.**
7. Com o **HeidiSQL** aberto vá para o diretório do projeto clonado e execute o arquivo *.sql*: `database_sistemasenha.sql`.
8. Execute o script no **HeidiSQL** para criação do banco de dados e tabelas necessárias para o correto funcionamento do projeto. 
9. Ainda no NetBeans, importe o driver `jdbc mySQL` ou similar. O mesmo terá o papel de operar o projeto de forma assíncrona ao banco de dados.
10. Antes de executar o projeto leia o arquivo *.txt*: `lista_de_produtos.txt`.
11. Por fim, execute o projeto.

## • Tecnologias e Linguagens

<div style="display: inline_block">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" height="50" width="60"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mysql/mysql-original-wordmark.svg" height="50" width="60"/>
  <img src="https://upload.wikimedia.org/wikipedia/commons/9/98/Apache_NetBeans_Logo.svg" height="50" width="60"/>
  <img src="https://upload.wikimedia.org/wikipedia/commons/3/32/HeidiSQL_logo_image.png" height="50" width="55"/>
</div>

## • Referências e documentações

| **[Java](https://docs.oracle.com/en/java/javase/17/)** 
| **[MySQL](https://dev.mysql.com/doc/)** |
