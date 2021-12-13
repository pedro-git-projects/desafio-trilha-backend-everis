a) O que são libs quando se trata de código? 

b) Cite 2 libs populares no Java e seu objetivo.

c) Qual é o propósito do Maven, e qual é o seu relacionamento com o arquivo pom.xml? 

d) Qual é a diferença do Maven para o Gradle

e) Com os conhecimentos adquiridos até agora, realize uma conexão com o desafio 3 onde falamos sobre JDBC, os drivers de comunicação com os bancos de dados.

i. Qual a relação entre os termos lib, driver e JDBC?

ii. Como é adicionado uma lib no projeto?

iii. Escolha um banco de dados (menos o H2) e explique como utilizar o driver de comunicação.

*Respostas*

a) Uma lib, library ou biblioteca é uma coleção de recursos não voláteis usados por programas de computador, incluindo dados de configuração, documentação, dados de ajuda, modelos de mensagem, código pré-escrito, sub-rotinas, classes, valores e especificações de tipo. No caso de Java, utilizamos usualmente código pré escrito.

b) 
1. Apache Commons, a qual tem propósito geral e estende diversas bibliotecas padrão do Java trazendo componentes estatistícos, matemáticos, helper para o JDBC, utilidades de E/S e ferramentas de login. 

2. Jackson. Utilizada para o processamento de daados formatados, incluindo Avro, CBOR, CSV, Ion, Protobuf, Smile, XML e YAML.

3. Maven é uma ferramenta de gerencimento de projeto provida pela Apache. O POM.xml é seu princpipal componente, sendo responsável por gerenciar as dependências e propriedades do projeto para que o Maven faça a build de forma adequada.

4. Gradle é outra ferramenta de build. Diferentemente do Maven, entretanto, gradle pode ser utilizado para o deployment de uma variedade de linguagens, incluindo python e C++. Sua maior vantagem em relação ao Maven é que faz uso de Groovy ao invés de XML, o que torna seu uso tanto mais versatil quanto mais legível. 

5. 

i. JDBC é quem é responsável por gerenciar nossas conexões com o banco de dados. A ideia do JDBC é generalizar as conexões, fazendo com que a migração entre base de dados seja um processo tranquilo. Portanto há diversas bibliotecas de *drivers* para o JDBC, estes drivers são configurados de forma a prover o JDBC com a capacidade de se conectar com um banco de dados específico, ie: MySQL, PostgreSQL. 

ii. Como nosso projeto é um projeto maven, basta entrar no site https://mvnrepository.com/ buscar a biblioteca desejada, adicionar no pom xml e atualizar o projeto com clean install.

iii. 

Primeiro declaramos a dependência para o driver JDBC do MySQL no arquivo pom.xml. 

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <scope>runtime</scope>
</dependency>
```

Em seguida especificamos os detalhes da conexação no application.properties.

```
spring.datasource.url=jdbc:mysql://localhost:3306/nomedobancodedados
spring.datasource.username=root
spring.datasource.password=password
```

Conectamos ao MYSQL utilizando o Spring JDBC
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```
