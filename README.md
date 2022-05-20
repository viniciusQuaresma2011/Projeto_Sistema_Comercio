# Projeto_Sistema_Comercio

*********CONTAINERS -PASSO A PASSO PARA A EXECUÇÃO DO PROJETO******

1º Passo: Importar o projeto 
-Realize o git clone do projeto para o editor de codigo local ou de preferencia, use:
git clone https://github.com/viniciusQuaresma2011/Projeto_Sistema_Comercio.git

2º Passo: Acessar o diretório do projeto
-Entre na pasta do diretório do projeto com o comando:
cd Projeto_Sistema_Comercio

3º Passo: Criar as Imagens e levantar os containers com as suas respectivas imagens
-Para criar as imagens e subir para um container, use o comando abaixo no terminal:
docker-compose up

4º Passo: Acessar a aplicaçao e testar!!
-Acesse o link abaixo para testar o sistema:
http://localhost:8081/

SUGESTÃO DE TESTE:

-Cadastrar um Usuário: Acesse o módulo de usuário, e preencha com o nome, email, nome de usuário, filial, setor, função. Deverá estar listado na página de listagem de usuário.










**************PASSO A PASSO PARA ACESSAR O BANCO DE DADOS MYSQL DENTRO DO CONTAINER E CONFERIR O CADASTRO DO USUARIO, POR EXEMPLO. *****************

1º Passo: Para conferir se o usuario cadastrado está no banco:
*acesse o terminal, e digite esse comando:

ATENÇÃO: projeto_sistema_comercio_mysql-standalone_1 é o nome do container com a imagem do mysql rodando.

***COMANDO ABAIXO PARA SER EXECUTADO O 1º PASSO:

docker exec -it projeto_sistema_comercio_mysql-standalone_1 bash



2º Passo: entrar no mysql que está no container:
***use o comando abaixo:

mysql -uroot -p

***em seguida coloque a senha abaixo:

teste

3º Passo: visualizar os bancos disponiveis
-Para acessar os bancos disponiveis, digite no terminal (com o acesso direto ao mysql, realizado acima nos passos 1º e 2º):

show databases;

4º Passo: vamos selecionar o banco do projeto, que é: banco_usuario
-Para selecionar o banco, digite o seguinte codigo:

use banco_usuario;

5º Passo: para conferir de fato se o usuario foi cadastrado de fato, use o comando abaixo:

select * from usuario;


