public class Main {
    public static void main(String[] args) {
        EstudanteSemEncapsulamento problema = new EstudanteSemEncapsulamento();
        // Sem encapsulamento precisamos acessar e modificar diretamente os atributos:
        problema.nome = "Faltou encapsulamento";
        System.out.println(problema.nome);
        // Isso faz com que não tenhamos o controle que é possível ter em um métoodo, podendo fazer por exemplo:
        problema.idade = -100;
        System.out.println(problema.idade);
        // Encapsular a classe com getters e setter evita esse tipo de problema:

        Estudante pedro = new Estudante();
        pedro.setNome("Pedro");
        pedro.setIdade(-10);
        pedro.setIdade(23);
        // Note que para o encapsulamento ser efetivo, tambem precisamos tornar os atributos privados, de forma que nao possam ser alterados diretamente
        // Entretanto, isso tambem faz com que percamos acesso aos atributos do objeto, ai que entram os getters
        // System.out.println(pedro.idade);
        System. out.printf("A idade encapsulada do usuario %s e %d", pedro.getNome(), pedro.getIdade());



    }
}
