public class Jogador {
    int vida = 100;
    int x;
    int y;

    boolean atacar(Jogador oponente) {

        int diffX = Math.abs(x - oponente.x);
        int diffY = Math.abs(y - oponente.y);

        if(diffX == 0 && diffY == 1) {
            oponente.vida -= 10;
        } else if(diffX == 1 && diffY == 0) {
            oponente.vida -= 10;
        } else {
            return false;
        }

        return  true;
    }

    boolean mover(Direcao direcao) {
        if(direcao == Direcao.NORTE) {
            y--;
        } else if (direcao == Direcao.LESTE) {
            x++;
        } else if(direcao == Direcao.SUL) {
            y--;
        } else if(direcao == Direcao.OESTE) {
            x--;
        }
        return  true;
    }
}
