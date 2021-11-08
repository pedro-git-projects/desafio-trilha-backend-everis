Defina com suas palabras qual é a responsabilidade das camadas vistas até agora, entity, controller, repository, service.

*Resposta* 

 **Entity**: Uma classe anotada com @Entity representa uma classe que está relacionada com uma tabela no banco de dados. Cada instância dessa classe será representada por uma ênupla na tabela, suas informações sendo aquelas que fazem parte dos atributos do objeto. 

**Controller** Uma classe anotada com @Controller representa um endpoint. Nela são definidos os métodos que controlarão as requisições HTTP. 

**Repository** Uma classe, geralmente interface, anotada com @Repository deve estender a classe JpaRepository, herdando desta última os métodos necessários para buscar, inserir e modificar o banco de dados. Faz parte da camada de persistência da nossa aplicação. 

**Service** Uma classe anotada com @Service intermedia classes anotadas com @Controller e @Repository, nela temos as regras de negócio da nossa aplicação.