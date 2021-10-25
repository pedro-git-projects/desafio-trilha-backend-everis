public class Motor {

    Carro carro;

    double fatorDeInjecao = 1;

    Motor(Carro carro) { this.carro = carro; }

    int getRpm() {
        return (int) Math.round(fatorDeInjecao * 3000);
    }
}
