a) Explique o conceito de teste unitário

b) Descreva como fazer um código de teste.

c) Qual o intutito do teste unitário?

d) Quais são as ferramentas que utilizamos para realizar testes unitários.

*Respostas:*

a) Teste unitário consiste em testar o menor bloco de código que pode ser logicamente isolado em um sistema. No caso de Java, estes blocos serão métodos.

b) Vamos assumir aqui um teste com JUnit:

Um teste JUnit é um método contido em uma classe que é utilizada exclusivamente para testes conhecida, não surpreendentemente, como *classe teste*. Para marcar um método como um método de teste, anotamo-o com @Test, logo este método executará código sob um teste.

Consideremos este exemplo mínimo:

```java
package com.pedro.data.ntt;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AClassWithOneJUnitTest {

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }
}
```

Podemos utilizar métodos *assert* ,fornecidos pelo JUnit ou outro framework, para comparar o resultado esperado com o resultado encontrado. Métodos assert geralmente permitem que definamos mensagens caso os testes falhem.

c) É dito que há vários benefícios que decorrem de testes unitários, entretanto, sua função é bastante simples, demonstrar que o código de fato apresenta o comportamento esperado.

d) Em se tratando de Java, dois exemplos de ferramentas para testes unitários são JUnit e Mockito. 