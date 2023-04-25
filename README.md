<h1> SA05 - Envio de projeto para a GitHub </h1>

<p>
  Atividade desenvolvida com o objetivo de enviar um projeto para o GitHub e desenvolver seus pormenores como, por exemplo, elaborar um readme explicativo 
  e conforme as especificações. 
</p>

## Sumário
<ul>
  <li><a href="#telas">Telas</a></li>
  <li><a href="#tecnologias">Tecnologias utilizadas</a></li>
  <li><a href="#getting-started">Getting Started</a></li>
  <li><a href="#sobre">Sobre</a></li>
  <li><a href="#participantes">Participantes</a></li>
  <li><a href="#licença">Licença</a></li>
</ul>
</br>

## Telas
<table>
<tr>
  <th>Listagem de usuário</th>
  <th>Adição de usuário</th>
  <th>Edição de usuário</th>
  </tr>
  <tr>
    <td><img src="./src/main/base/user-list.jpg"/></td>
    <td><img src="./src/main/base/add-user.jpg"/></td>
    <td><img src="./src/main/base/edit-user.jpg"/></td>
  </tr>
</table>
</br>



## Tecnologias

- Java
- WildFly 24
- HTML
- CSS
- Bootstrap
- MySQL
</br>



## Getting Started

- Eclipse [Required]
- Gerenciador de banco SQL (MySQL WorkBench / PostGres / Adjacente) [Required]
- Java 8 [Required]
- JDK 1.8+ [Required]
- WildFly 24 [Required]
</br>

1. Clonar o repositório
<pre>
<code>git clone https://github.com/SetropLeo/ShoesHappy-MVC.git</code>
</pre>
</br>

2. Configurar o projeto com o banco de dados no arquivo usuarioDAO (src/main/java/dao/UsuarioDAO.java)
<pre>
<code>1. Alterar login do banco</code>
<code>2. Alterar senha do banco</code>
<code>3. Alterar url do banco</code>
</pre>
</br>

3. No gerenciador de bancos, criar um novo banco chamado shoeshappy. Rodar o seguinte comando: 
<pre>
<code>create database shoeshappy</code>
</pre>
</br>

4. Criar a seguinte tabela dentro do banco shoeshappy: 
<pre>
<code>create table `usuario` (
 codigo INT(3) NOT NULL AUTO_INCREMENT,
 nome VARCHAR(120) NOT NULL,
 email VARCHAR(220) NOT NULL,
 pais VARCHAR(120),
 PRIMARY KEY (codigo)
);</code>
</pre>
</br>

5. Para rodar o projeto, clicar com o botão direito em cima da pasta do projeto e selecionar: 
<pre>
 <code>Run As -> Run on Server -> WildFly 24</code>
</pre>
<p> Após isso, é só acessar o seguinte link:</p>
<code><a href="http://localhost:8080/ShoesHappy/">http://localhost:8080/ShoesHappy/</a></code>

<br><br>


## Sobre

Aplicação Web desenvolvida com Java e MySQL. O sistema gira em torno de um CRUD simples onde é possível realizar adições, edições e exclusões de usuários em um sistema.


<br><br>


## Participantes

- [Leonardo Lawisch Portes](https://github.com/SetropLeo)
<br><br>


## Licença

- Licença MIT
<br><br>
