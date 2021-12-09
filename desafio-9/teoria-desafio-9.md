a) O que é um padrão de projeto e porque nós os utilizamos?

*Resposta:*

Um padrão de projeto consiste em uma solução geral e reutílizavel para um problema ou classe de problemas recorrentes em se tratando de design de software. Estes padrões, além de pouparem tempo, ajudam a estruturar o código de acordo com determinados padrões, pensados para melhorar a produtividade e escalabilidade dos projetos. É também por estas boas propriedades que utilizamos padrões de projeto.

b) Cite e explique com suas palavras:

i. Um dos padrões de criação.
ii. Um dos padrões estruturais
iii. Um dos padrões comportamentais. 


*Resposta:*

i. Há diversos padrões criacionais, como *Factory Method*, *Abstract Factory*, *Singleton*, *Monostate*, *Builder* e *Prototype*. Falarei aqui sobre o factory method: 

## Factory Method:

A ideia é que temos uma interface e classes concretas e quem cria as instâncias é uma chamda "fábrica", eliminando assim o contato da classe criadora com as classes concretas. 

Por exemplo:

Vamos fazer um código em que os botões desempenharão a função de produto e os diálogos atuarão como criadores.

Caixas de diálogo diferente requerem  elementos próprios. É por isso que criaremos uma subclasse para cada tipo de diálogo e substituíremos seus métodos fábrica.

Agora, cada tipo de diálogo instanciará as classes de botão apropriadas. O diálogo base funciona com produtos usando sua interface comum, é por isso que seu código permanece funcional após todas as alterações.

Pirmeiro a interface do produto comum: 

```java
package pedroNttData.factory_method.example.buttons;

/**
 * Interface comum para todos os botões
 */
public interface Button {
    void render();
    void onClick();
}
```

Em seguida o produto concreto: 

```java
package pedroNttData.factory_method.example.buttons;

/**
 * Implementação do botão HTML
 */
public class HtmlButton implements Button {

    public void render() {
        System.out.println("<button>Test Button</button>");
        onClick();
    }

    public void onClick() {
        System.out.println("Click! Button says - 'Hello World!'");
    }
}
```

Outro produto concreto: 

```java
package pedroNttData.factory_method.example.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Botão para o Widnwos
 */
public class WindowsButton implements Button {
    JPanel panel = new JPanel();
    JFrame frame = new JFrame();
    JButton button;

    public void render() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hello World!");
        label.setOpaque(true);
        label.setBackground(new Color(235, 233, 126));
        label.setFont(new Font("Dialog", Font.BOLD, 44));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(panel);
        panel.add(label);
        onClick();
        panel.add(button);

        frame.setSize(320, 200);
        frame.setVisible(true);
        onClick();
    }

    public void onClick() {
        button = new JButton("Exit");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                System.exit(0);
            }
        });
    }
}
```

Agora nossa fábrica

```java
package pedroNttData.factory_method.example.factory;

import pedroNttData.factory_method.example.buttons.Button;

/**
 * Classe  fábrica báisca. Perceba que "fábrica" é apenas um papel para a classe. Ela
 * deve ter alguma lógica do negócio principal que precisa de diferentes produtos para ser
 * criado.
 */
public abstract class Dialog {

    public void renderWindow() {
        // ...outro código ...

        Button okButton = createButton();
        okButton.render();
    }

    /**
     * Subclasses vão fazer override nesse método para criar objetos botão específicos 
     */
    public abstract Button createButton();
}
```

Um criador concreto:

```java
package pedroNttData.factory_method.example.factory;

import pedroNttData.factory_method.example.buttons.Button;
import pedroNttData.factory_method.example.buttons.HtmlButton;

/**
 * Produzirá botões html
 */
public class HtmlDialog extends Dialog {

    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
```

Outro: 

```java
package pedroNttData.factory_method.example.factory;

import pedroNttData.factory_method.example.buttons.Button;
import pedroNttData.factory_method.example.buttons.WindowsButton;

/**
 * Produzirá botões windows
 */
public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
```

Por fim o código do cliente:

```java
package pedroNttData.factory_method.example;

import pedroNttData.factory_method.example.factory.Dialog;
import pedroNttData.factory_method.example.factory.HtmlDialog;
import pedroNttData.factory_method.example.factory.WindowsDialog;

/**
 * Classe onde tudo é colocado em prática
 */
public class Demo {
    private static Dialog dialog;

    public static void main(String[] args) {
        configure();
        runBusinessLogic();
    }

   
    static void configure() {
        if (System.getProperty("os.name").equals("Windows 10")) {
            dialog = new WindowsDialog();
        } else {
            dialog = new HtmlDialog();
        }
    }

   
    static void runBusinessLogic() {
        dialog.renderWindow();
    }
}
```


ii. Há diversos padrões estruturais, como *adapter*, *bridge*, *composite*, *decorator*, *facade*, *flyweight* e *proxy*.Falarei aqui sobre o adapter:

## Adapter:

Esse padrão de projeto é utilizado para permitir a comunicação entre classes que não poderiam trabalhar juntas devido à incompatibilidade de suas interfaces. 

Por exemplo, suponhamos que tenhamos uma classe modelando objetos com encaixes redondos:


```java
package pedroNttData.adapter.example.round;

/**
 * São compatíveis com pinos redondos 
 */
public class RoundHole {
    private double radius;

    public RoundHole(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg peg) {
        boolean result;
        result = (this.getRadius() >= peg.getRadius());
        return result;
    }
}
```

E uma classe modelando objetos com pinos redondos:

```java
package pedroNttData.adapter.example.round;

/**
 * Pinos redondos são compatíveis com encaixes redondos
 */
public class RoundPeg {
    private double radius;

    public RoundPeg() {}

    public RoundPeg(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
```

Teremos também objetos representando pinos quadrados, os quais são incompatíveis com encaixes redondos.

```java
package pedroNttData.adapter.example.square;

public class SquarePeg {
    private double width;

    public SquarePeg(double width) {
        this.width = width;
    }

    public double getWidth() {
        return width;
    }

    public double getSquare() {
        double result;
        result = Math.pow(this.width, 2);
        return result;
    }
}
```

Criamos então uma classe adapter, visando compatibilizar as classes.

```java
package pedroNttData.adapter.example.adapters;

import pedroNttData.adapter.example.round.RoundPeg;
import pedroNttData.adapter.example.square.SquarePeg;

/**
 * Permite o encaixe de pinos quadrados em encaixes redondos
 */
public class SquarePegAdapter extends RoundPeg {
    private SquarePeg peg;

    public SquarePegAdapter(SquarePeg peg) {
        this.peg = peg;
    }

    @Override
    public double getRadius() {
        double result;
        // Calcula o ráio mínimo do círculo para o encaixe
        result = (Math.sqrt(Math.pow((peg.getWidth() / 2), 2) * 2));
        return result;
    }
}
```

E no cliente ficaria algo como:

```java
package pedroNttData.adapter.example;

import pedroNttData.adapter.example.adapters.SquarePegAdapter;
import pedroNttData.adapter.example.round.RoundHole;
import pedroNttData.adapter.example.round.RoundPeg;
import pedroNttData.adapter.example.square.SquarePeg;


public class Demo {
    public static void main(String[] args) {
        // Redondo e redondo
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if (hole.fits(rpeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // Causaria erro de compilação

        // A interface adaptador resolve o problema.
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (hole.fits(smallSqPegAdapter)) {
            System.out.println("Pino quadrado w2 serve no encaixe redondo r5.");
        }
        if (!hole.fits(largeSqPegAdapter)) {
            System.out.println("Pino quadrado w20 não serve no encaixe redondo r5.");
        }
    }
}
```

iii. Há diversos padrões comportamentais, como *Chain of Responsability*, *Memento*, *Command*, *Iterator* e *Observer*. Vou falar aqui do Observer:

### Observer

Observer é um padrão de design comportamental que especifica a comunicação entre objetos. Para isso eles são divididos em duas categorias: observáveis e observadores. Um observável é um objeto que notifica os observadores sobre suas mudanças de estado.

Por exemplo, uma agência de notícias pode notificar canais quando recebe notícias. Receber notícias é o que muda o estado da agência de notícias, e faz com que os canais sejam notificados.

Criando a classe da agência de notícias:

```java
public class NewsAgency {
    private String news;
    private List<Channel> channels = new ArrayList<>();

    public void addObserver(Channel channel) {
        this.channels.add(channel);
    }

    public void removeObserver(Channel channel) {
        this.channels.remove(channel);
    }

    public void setNews(String news) {
        this.news = news;
        for (Channel channel : this.channels) {
            channel.update(this.news);
        }
    }
}
```

NewsAgency é um observável, e quando as notícias são atualizadas, o estado da Agência de Notícias muda. Quando a mudança acontece, a NewsAgency notifica os observadores sobre esse fato chamando seu método de atualização().

Para ser capaz de fazer isso, o objeto observável precisa manter referências aos observadores, e no nosso caso, é a variável canais.

Vamos ver como o observador, a classe do Canal, pode parecer. Ele deve ter o método de atualização() que é invocado quando o estado da Agência de Notícias muda:

```java
public class NewsChannel implements Channel {
    private String news;

    @Override
    public void update(Object news) {
        this.setNews((String) news);
    } 
}
```
```java
public interface Channel {
    public void update(Object o);
}
```
A interface do canal tem apenas um método:

```java
NewsAgency observable = new NewsAgency();
NewsChannel observer = new NewsChannel();

observable.addObserver(observer);
observable.setNews("news");
assertEquals(observer.getNews(), "news");
```

Agora, se adicionarmos uma instância do NewsChannel à lista de observadores e alterarmos o estado da Agência de Notícias, a instância do NewsChannel será atualizada:


```java
public class ONewsChannel implements Observer {

    private String news;

    @Override
    public void update(Observable o, Object news) {
        this.setNews((String) news);
    }
}
```

Há uma interface de Observador predefinida nas bibliotecas centrais Java, o que torna a implementação do padrão de observador ainda mais simples. Vamos dar uma olhada.

A interface java.util.Observer define o método de update() então não há necessidade de defini-lo nós mesmos como fizemos na seção anterior.

Vamos ver como podemos usá-lo em nossa implementação:

```java
public class ONewsAgency extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
    }
}
```

Aqui, o segundo argumento vem de Observável como veremos abaixo.

Para definir o observável, precisamos estender a classe Observável de Java:

```java
public class ONewsAgency extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
    }
}
```

Observe que não precisamos chamar o método de atualização do observador() diretamente. Basta ligar para o setChanged() e notificar os observadores(), e a classe Observável está fazendo o resto para nós.

Além disso, ele contém uma lista de observadores e expõe métodos para manter essa lista – adicionarObserver() e excluirObserver().

Para testar o resultado, só precisamos adicionar o observador a esta lista e definir as novidades:

```java
ONewsAgency observable = new ONewsAgency();
ONewsChannel observer = new ONewsChannel();

observable.addObserver(observer);
observable.setNews("news");
assertEquals(observer.getNews(), "news");
```

c) Explique o conceito de arquitetura de software e seu propósito;

*Resposta:*

A arquitetura de software de um sistema consiste na definição dos componentes de software, suas propriedades externas, e seus relacionamentos com outros softwares. A arquitetura vai muito além de diagramas e desenhos técnicos e ela está totalmente associada às definições de produto e do negócio. Defini-la bem requer estratégias que resultem em implementações mais simples e eficazes. E é por esta razão que devemos utiliza-la. 

d) Até o momento devemos ter criado 12 classes, o seu projeto deve estar bem parecido com um dos dois cenários abaixo:

i. Qual arquitetura estamos seguindo até o momento? Justifique sua resposta. 

*Resposta:*

Estamos utilizando o padrão de projeto *MVC*, que signfica *Model View Controller*. Estamos utilizando esta arquitetura porque separamos o código três partes Model, O model é a camada que possui a lógica da aplicação. Ele é o responsável pelas regras de negócios, persistência com o banco de dados e as classes de entidades. A view é a camada de visualização e representa a parte do sistema que interage com o usuário. É pela interface que haverá a entrada dos dados inseridos pelo usuário e também a saída de informações que serão exibidas para ele. Esses dados serão inseridos ou exibidos geralmente por formulários de entrada ou de saída, tabelas, grids, entre outras formas. A view não contém lógica de negócios, portanto todo o processamento é feito pela camada model e então a resposta é repassada para a view pelo controlador. Por fim o Já sabemos que as requisições são enviadas pela view e a lógica de negócios é representada pelo model. Para que haja a comunicação entre essas duas camadas de maneira organizada, é necessário construir a camada controller. Sua função é ser uma camada intermediária entre a camada de apresentação (View) e a camada de negócios (Model).

g) O que significa a sigla SOLID?

Ela significa: Single Responsibility Principle (Princípio da Responsabilidade Única). Open-Closed Principle (Princípio Aberto e Fechado). Liskov Substitution Principle (Princípio da substituição de Liskov). Interface Segregation Principle (Princípio da Segregação de Interface). Dependency Inversion Principle (Princípio da Inversão de Dependência).


h) Quais princípios foram utilizados no projeto até o momento? Explique. (máx 10 
linhas

Utilizamos o Single Responsability Principle, já que cada classe no projeto tem apenas uma razão para alterar seu estado, ou seja, cumpre uma única função, services implementam a lógica da aplicação, repositório geram a herança das propriedades necessárias para persistência no banco de dados, controllers expõe os endpoints e assim por diante.

Também utilizamos o princípio da substituição de Liskov, já que os DTOs, classes drevidas das nossas entidades, foram passados ao invés das entidades elas mesmas durante o desafio 6 sem maiores problemas.

No caso das nossas interfaces estendendo o JPA repository estamos instanciando o principio aberto-fechado.  