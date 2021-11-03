# Introdução
- No pacote **model** temos os modelos de dados que correspondem a entidade e tabelas *categories* e *entries*.
- **CategoryRepository** consiste em uma interface que estende a classe **JpaRepository** para dar acesso aos métodos CRUD e finders customizados. Esta classe vai ser*autowired* na classe **CategoryController**. Analogamente o mesmo ocorre para **EntryRepository** e **EntryController**. 
- A configuração para o *Spring Data Source*, *JPA* e *Hibernate* estão no arquivo **application.properties** dentro do diretório **resources**.
- No pom.xml adicionamos as dependencias para o *Spring Boot* e o banco de dados *H2*.

# Data Model
## Anotações
 @Entity indica que a classe é persistente.\
 @Table gera a tabela onde a entidade será mapeada \
 @Id é a anotação para a chave primária \
 @GeneratedValue dá a estratégia de geração da chave primária e GenerationType.Auto indica que o campo será auto-incrementado \
 @Column define a coluna do banco de dados onde o campo será mapeado
  
# Repository Interface

Esta é uma interface que estende a classe JpaRepository. Isso nos dá acesso aos métodos save(), findOne(); findBy(), findAll(), count(), delete(), deleteById() dentre outros.

Além disso, para cumprir o desafio, adicionamos os métodos *finder* customizados findByName e findByDescription.

# REST API Controller

## Anotações

 @CrossOrigin implementa (CORS) permitindo compartilhamento de requsição entre domínios. Com o parâmetro da nossa raíz (origins = "http://localhost:8081"). \
 @RestController define um um controller e indica que o valor dos métodos de retorno deve estar ligado ao corpo de resposta \
 @RequestMapping("/api") faz com que todas as apis do nosso controle comecem com /api \
 @AUtorwired para injetar os beans **CategoryRepository** e **EntryRepository** na variável local  

# Rodando a aplicação

Basta executar através da IDE ou do terminal com o comando mvn spring-boot:run. Em seguida podemos acessar o *H2* através do URL http://localhost:8080/h2-ui \
No campo JDBC URL devemos colocar **jdbc:h2:mem:financas** caso estejamos utilizando banco em memória. E **jdbc:h2:file:/h2/financas** caso estejamos utilizando arquivos.

Em seguida podemos utilizar o postman para executar o CRUD.