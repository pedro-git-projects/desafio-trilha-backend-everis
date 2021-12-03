a) O que são exceptions?

*Resposta:*

Para responder o que é uma exceção, vamos começar definindo o que uma exceção não é: Segundo a documentação oficial do Java um erro "indica um problema sério que uma aplicação razoável não deveria tentar pegar". Ou seja, a documentação está se referindo a erros dos quais a aplicação não é capaz de se recuperar. A única forma de lidar com esses erros é modificando a aplicação ou refatorando o código. Uma exceção, por outro lado, indica "condições que uma aplicação razoável pode desejar pegar". Isso inclui ambos, problemas de tempo de compilação e tempo de execução.

b) Qual é o funcionamento do **try**, **catch** e **finally**?

*Resposta:*

Try, Catch e Finally servem para tratar excessões no código. Caso haja ao menos uma excessão não tratada no nosso programa, encontrá-la em runtime tornará a execução do resto do programa impossível.  Try define um bloco de código onde, caso ocorra uma excessão, ele lançará a excessão para o bloco catch, se o bloco catch pega a excesão, então ele executa o seu conteúdo. Por fim, finally define um bloco que é executado independentemente do lançamento ou recebimento de uma execssão pelo try e catch. Para ilustrar:

```java
public class Main {
    public static void main(String[] args) {
       try {
           int x = 5;
           int y = 0;
           int z = x/y;

           System.out.println("A saída é: " + z);
       }
       catch(Exception e) {
           System.out.println("Uma excessão foi encontrada");
       }
       finally {

       }

    }
}
```

c) Qual é a relação entre **try**, **catch**, **finally** e **throws**?

*Resposta:*

Colocando de forma breve:

 - O bloco *try* executará código crítico que pode gerar exceções.

 - O bloco de *catch* é executado sempre que uma exceção é lançada no bloco *try*.

 - O bloco *finally* é executado sempre independentemente do resultado dos blocos *try* e *catch*. 

- A palavra reservada *throw* permite que uma excessão seja lançada, quebrando o fluxo de execução.

- Por fim, a palavra reservada  *throws* é utilizada em um método para sinalizar que aquele método pode lançar excessões de um determinado tipo. É útil para tratar excessões chacadas que não desejamos lançar para um catch dentro do método.

d) Para que serve a anotação **@ExceptionHandler**?

*Resposta:*

Para lidar com exceções no Spring podemos definir um método na classe Controller e usar a anotação @ExceptionHandler, essa anotação permite que que pegemos qualquer excesão. Podemos ter vários métodos anotados com @ExceptionHandler dentro do controller com exceções válidas.

e) Para que serve a annotation **@ControllerAdvice**?

*Resposta:*

Essa anotação serve para melhorar o funcionamento da anotação do exercício anterior: A @ExceptionHandler funciona apenas dentro do  controller onde foi definido. Caso haja vários controllers, precisamos separar os @ExecptionHandlers em uma única classe para tornar o código manutenível, @ControllerAdvice faz isso automaticamente. 
