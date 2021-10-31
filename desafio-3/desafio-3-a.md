a) Com suas palavras defina: 

i. O que é protocolo de comunicação HTTP e como ele funciona;
ii. O que é REST, e qual é a sua relação com o protocolo HTTP
iii. O que é Web API, qual é sua relação com REST;

*Respostas*

i. HTTP significa literalmente Hypertext Transfer Protocol, em português **Protocolo de Transferência em Hypertexto**. Um **protocolo**, por sua vez, consiste em um sistema de regras que definem como dados são transferidos entre computadores. O HTTP em particular foi criado originalmente visando a obtenção de arquivos HTML entre computadores concetados em rede. Ele geralmente funciona através do modelo **cliente-servidor**, onde uma máquina **cliente** faz  requisições a um **servidor** que envia a resposta adequada.   

ii. REST significa literalmente REPRESENTATIONAL STATE TRANSFER, em portugês **Transferência de Dstado Representacional**. É importante notar que, ao contrário do HTTPele não é um padrão ou especificação. Na verdade, REST é um estilo arquitetural para sistemas de hypermídia distribuídos. O padrão REST tem algumas características como *interface uniforme*, ou seja, os clientes devem acessar todos os recursos através do mesmo conjunto padrão de operações e a **ausência de estados**, que quer dizer que as requisições não devem depender de possíveis estados. Isso quer dizer, portanto, que uma aplicação que implementa HTTP pode **aderir** aos princípios REST.

iii. Em primeiro lugar, API significa literalmente Application Programming Interface, em portugês **Interface de Programação de Aplicativos**. Uma API consiste em uma interface que disponibiliza um série de funções aos seus usuários abstraindo seus mecânismos internos. Uma API web, por sua vez, é uma API que viaja pela internet. Nesse caso temos geralmente o cliente, que é quem chama a API e o servidor, que é quem responde. Sua relação com REST e, por consequẽncia HTTP, está no fato de que a transferência de dados na web se dá atráves do protocolo HTTP, e, como vimos anteriormente, REST é um padrão arquitetural que pode ser aplicado a requisições HTTP para padronizar como o cliente e servidor fazem/retornam as requisições. 
