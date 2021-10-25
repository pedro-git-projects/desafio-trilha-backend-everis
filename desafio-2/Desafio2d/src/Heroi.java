public class Heroi extends  Jogador {

    boolean atacar(Jogador oponente) {
        // super.atacar  quer dizer que estamos chmando o metodo atacar na classe super (Jogador)
        boolean ataque1 = super.atacar(oponente);
        boolean ataque2 = super.atacar(oponente);
        return  ataque1 || ataque2;
    }
}

