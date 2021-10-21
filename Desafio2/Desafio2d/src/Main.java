public class Main {
    public static void main(String[] args) {
        // Criaremos um jogo onde temos jogadores em um tabuleiro imaginario definido por coordenadas x e y
        // Heranca aparece aqui porque ambos, heroi e goblin estendem Jogador

        Heroi heroi = new Heroi();
        // faltou encapsulamento, mas e apenas um exemplo
        // passando as posicoes iniciais
        heroi.x = 10;
        heroi.y = 10;

        Goblin goblin = new Goblin();
        goblin.x = 10;
        goblin.y = 11;

        System.out.println("O heroi tem => " + heroi.vida + " de vida.");
        System.out.println("O goblin tem => " + goblin.vida + " de vida.");

        heroi.atacar(goblin);

        System.out.println("O heroi tem => " + heroi.vida + " de vida.");
        System.out.println("O goblin tem => " + goblin.vida + " de vida.");


        heroi.mover(Direcao.NORTE);
        heroi.mover(Direcao.NORTE);
        // saiu do range
        heroi.atacar(goblin);
        System.out.println("O heroi tem => " + heroi.vida + " de vida.");
        System.out.println("O goblin tem => " + goblin.vida + " de vida.");
    }
}
