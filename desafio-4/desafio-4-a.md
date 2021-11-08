i. O que é JDBC?

*Resposta*

JDBC significa litalmente **Java Database Connectivity** é uma API para Java que define como um cliente deverá acessar um banco de dados. Seu uso envolve fazer consultas, comandos e tratar conjuntos de resultados. 

A JDBC surgiu como uma alternativa para a API ODBC escrita em C e oferece uma API que lida com os aspectos mecânicos da interação de aplicações Java com seus bancos de dados. A JDBC é composta por duas camadas:

1. A API da JDBC, que permite a comunicação entre a aplicação Java e o gerenciador JDBC;

2. O driver JDBC que suporta a comunicação entre o gerenciador JDBC e o driver do banco de dados. 

ii. O que é ORM? Cite 3 exemplos.

*Resposta*

ORM significa literalmente **Object Relational Mapper** ou em portugês **Mapeador Objeto Relacional** e consiste em uma técnica para criar correspondências entre dados de sistemas de tipo incompatíveis fazendo uso de linguagens orientadas à objetos. Geralmente ORM é utilizado para fazer a comunicação entre os bancos de dados relacionais de uma aplicação orientada a objetos.Três exemplos são:

1. Apache OpenJPA
2. EclipseLink
3. Hibernate

iii. O que é JPA, qual sua relação com os ORM's?

*Resposta*

JPA, ou **Java Persistence API** consiste em uma especificação para a criação "automática" de DAOs (Data Access Objects) em tempo de compilação, é nesses repositórios que a JPA **faz uso** de um ORM, como por exemplo, Hibernate.

iv. O que é Spring Data?

*Resposta*

Spring Data consiste em um projeto do Spring cujo objetivo é unificar e facilitar o acesso a diferentes tipos de locais de persistência, sejam eles relacionais ou ou NoSQL. 

