b) Liste todos os métodos de solicitações HTTP utilizados pelo padrão REST e suas respectivas finalidades;

*Resposta*

O padrão REST determina que métodos HTTP específicos sejam utilizados para requisições determinadas no servidor. A listagem destes métodos e seus usos é como se segue:

1. GET

O método GET deve ser utilizado para **receber representação de recursos e informações**, sem jamais modificá-los. Isso faz com que GETS também devam ser **idempotentes**, isto é, várias aplicações do método GET (e nenhum outro) devem retornar o mesmo resultado.

2. POST

O método POST deve ser utilizado para **criar um novo recurso na coleção de recursos**. 

3. PUT 

O método PUT deve ser utilizado **primariamente** para **atualizar um recurso préexistente**. Se o recurso não existe, ele pode ser criado através deste método, mas caso seja este o caso, a API deve informar o agente via o código 201.

4. DELETE

O método DELETE deve ser utilizado para **deletar recursos**. O método DELETE também é **idempotente**.

5. PATCH

O método PATCH deve ser utilizado para fazer uma **atualização parcial em um recurso**. Ou seja, se a substituição de um recuso não for total, deve-se utilizar o PATCHao invés do PUT. 
