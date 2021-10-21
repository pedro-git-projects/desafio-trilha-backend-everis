public class Main {
    public static void main(String[] args) {
        Passaro arara = new Passaro();
        Passaro papagaio = new Papagaio();

        // Perceba que, embora eu tenha chamado metodos com a mesma assinatura em cada um dos Passaros (papagaio estende passaro)
        // o metodo e executado de maneira distinta, esse e o polimorfismo

        arara.cantar();
        papagaio.cantar();

    }
}
