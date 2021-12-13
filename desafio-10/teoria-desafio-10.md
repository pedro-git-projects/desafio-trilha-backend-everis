a) O que você entende por Spring Framework?

b) Cite 3 exemplos de ferramentas Spring e suas respectivas finalidades;

c) Quais ferramentas do Spring foram utilizadas na trilha até o momento?

d) Cite 5 vantagens em utilizar Spring;

e) Descreva os passos de criação de uma Web API Spring boot, com conexão com SQL Server;

f) Qual a funcionalidade do pom.xml?

g) Qual a funcionalidades do applications.properties?

h) Qual o propósito das Annotations?

i) Cite 10 annotations, com suas respectivas finalidades e descreva ou desenhe um 
cenário exemplificando a sua utilização.

j) O que é um advice em Spring? Quais os tipos de advice para o Spring?

k) O que é Spring IoC Container?

l) Como adicionamos segurança à nossa aplicação Spring?

m) Qual é o pacote Spring responsável pelas conexões com os bancos de dados?

n) Explique e exemplifique como criar um agendamento de execução de métodos Spring; Cite exemplos de usabilidade;

*Respostas:*

a) Spring é um framework para desenvolvimento Java. Sua principal funcionalidades é a de container, o qual é chamado de *Spring Application Context*, responsável por criar e gerir os componentes da aplicação. Estes componentes, comumente referidos como beans são relacionados pelo próprio framework em seu contexto de aplicação. O ato de ligar estes componentes é chamado de *injeção de dependência*. Provendo estes recursos e uma sintaxe agradável de anotações o Spring acelera o desenvolvimento.

b) 

i. AutoConfiguration: Detecta a presença de classes no ClassPath e as configura automaticamente.

```java
 
@EnableAutoConfiguration
@ComponentScan(excludeFilters = @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class))
public @interface SpringBootApplication {
//  …
}	
```
	
ii.  Actuator: Apesar de não ter sido usado nos desafios, é uma das ferramentas mais importantes do Spring, trazendo funções de monitoramento de métricas e saúde da aplicação.

```java
public class MyService extends AbstractHealthIndicator {
  // …
  @Override
  protected void doHealthCheck(Health.Builder builder) throws Exception {
    final String echo = pushNotifier.echo("Abcd");
    if (!echo.equals("\"dcbA\"")) {
      throw new RuntimeException("Response mismatch. Was " + echo);
    }
    builder.up();
  }
}
```

iii. Spring Initializer: Permite gerar um projeto com Maven ou Gradle, utilizando Java, Kotlin e Groovy. Além disso podemos selecionar as bibliotecas dinâmicamente e de maneira simples.

c) Foram utilizados Spring Starter Web, Spring Starter Validation, Spring Starter JPA, H2, Lombok, Spring Starter Test, Swagger e Hamcrest.

d) 

1. Autoconfiguração;
2. Facilidade no controle de dependências
3. Economia sintática com o uso de anotações
4. Facilita testes por ter JUnit integrado
5. Já vem com o Tomcat configurado para o servidor HTTP

e) 
1. Utilize alguma versão do spring initialr para gerar o template do projeto.
2. Decida qual "sabor" de SQL você deseja utilizar e adicione os drivers necessários às dependências.
3. Crie uma camada de repositório utilizando o JPA para herdar os métodos CRUD básicos.
4. Crie controladores REST e métodos que façam as requisições adequadas.
5. Realize os testes unitários.

f) O POM no nome do arquivo significa *Project Object Model*  ou modelo de projeto do objeto. Ele é utilizado pelo Apache Maven, que é a ferramenta de administração de projeto que costumamos utilizar com o Spring Boot, sua função é gerenciar as dependências e a construção do projeto.

g) É um arquivo de configuração das prorpeidades da nossa aplicação. Na trilha de desafios foi usado exclusivamente para fazer a configuração do banco de dados passando, por exemplo, a porta onde ele deve ser iniciado, o driver a ser utilizado, url da base de dados, etc.

h) Annotations surgiram para substituir os arquivos de configuração .xml anteriormente utilizados pelo Spring. Annotations fazem parte da linguagem Java mas tem função apenas de metadados, o Spring então as utiliza como configuração, sendo uma alternativa bem menos verbosa do que o xml.

i) 
1. @Entity, marca a classe como representando uma entidade que deve ser mapeada para o banco de dados.

```java
@Entity
public class Category {

    private Long id;
   
    private String name;
   
    private String description;
   
}
```

2. @Id, identifica que o atributo de um objeto anotado deve ser mapeado como chave primária no banco de dados.

```java
@Entity
public class Category {

    @Id
    private Long id;
   
    private String name;
   
    private String description;
   
}
```

3. @Repository, identifica que a classe anotada é um repositório, ou seja, uma abstração de acesso e armazenamento de dados.

```java
@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

}
```

4. @Controller, identifica que a classe anotada é um controller capaz de executar requisições HTTP.

```java
@Controller
public class CategoryController {
  // ....
  }

```

5. @RequestMapping, mapeia as requisições HTTP para o caminho passado como parâmetro.

```java
@Controller
@RequestMapping("/api")
public class CategoryController {
  // ....
}
```

6. @RestController, versão especializada do controller que inclui além dos conteúdos de @Controller, os de @ResponseBody.

```java
@RestController
@RequestMapping("books-rest")
public class SimpleBookRestController {
    
    @GetMapping("/{id}", produces = "application/json")
    public Book getBook(@PathVariable int id) {
        return findBookById(id);
    }

    private Book findBookById(int id) {
        // ...
    }
}
```

7. @PostMapping, equivalente a @RequestMapping(method = RequestMethod.POST).
```java
 @PostMapping(name = "Criar categoria")
    public ResponseEntity<CategoryResponseDTO> insert(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {
        Category categorySave = categoryService.save(categoryRequestDTO.convertToEntity());
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryResponseDTO.convertToCategoryDTO(categorySave));
    }
```

8. @GetMapping, equivalente a @RequestMapping(method = RequestMethod.GET).
```java
@GetMapping(name = "Listar categoria pelo Id", path = {"/{id}"})
    public ResponseEntity<CategoryResponseDTO> find(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        return category.map(value -> ResponseEntity
                .ok(CategoryResponseDTO.convertToCategoryDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
```

9. @PutMapping, equivalente a @RequestMapping(method = RequestMethod.PUT).
```java
 @PutMapping(name = "Atualizar categoria", path = {"/{id}"})
    public ResponseEntity<CategoryResponseDTO> update(@PathVariable Long id, @Valid @RequestBody CategoryRequestDTO categoryDto) {
        Category categoryUpdate = categoryService.update(categoryDto.convertToEntity(id));
        return ResponseEntity.ok(CategoryResponseDTO.convertToCategoryDTO(categoryUpdate));
    }
```

10.  @NotBlank, não permite que o campo anotado não seja populado durante uma requisição
```java
 @NotBlank(message = "{Campo(s) obrigatórios não foram preenchidos}")
    @Size(min = 3, max = 15, message = "{A descrição deve ter entre 3 e 15 caracteres}")
    private String description;
```
j) O advice é uma ação tomada por um aspecto em um determinado join point. Os tipos de advice são "around", "before" e "after". A finalidade de aspectos é facilitar operações como registros, armazenamento de cache e gerenciamento de transações. 

k) IoC em IoC container se refere a *Inversion of Control*. O que também é conhecido como Injeção de Dependência. Isto é, um processo pleo quial objetos definem suas dependência. Ou seja,os objetos com os quais trabalharão apenas através de argumentos de construtor, argumentos para factory methods ou propriedades definidas no objeto após sua construção ou retorno de um factory method. O conteiner *injeta* essas dependências quando cria o bean. 

l) Para tanto utilizamos as dependências do tipo Spring Boot Security no nosso projeto, elas permitem que façamos autenticações, autorizações assim como paginação de APIs serverlet.

m) Ele é o Spring JDBC, responsável por abrir a conexão, preparar e executar sentenças SQL, iterar pelos resultados, processar exceções, lidar com transações e fechar a conexão

n) Podemos fazer isso utilizando a annotation @Scheduled. A qual substitui o Time e TimerTask da API do Java. @Scheduled indica para o Spring que o método será agendado. Isso pode ser usado se, por exemplo, o cliente eseja saber como está o fluxo de vendas por um determinado período. Um exemplo de implementação: 

```java
public class VerificadorDePegamentos {

    private final long SEGUNDO = 1000; 
    private final long MINUTO = SEGUNDO * 60; 
    private final long HORA = MINUTO * 60;

    @Scheduled(fixedDelay = HORA) 
    public void verificaPorHora() { 
        // Código que realiza a consulta de fluxo de vendas 
    }

}
```
