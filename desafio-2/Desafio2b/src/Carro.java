public class Carro {
    // Atributo abstraído do usuário, motor:
    Motor motor;

    // Associando um motor a esse carro no construtor
    Carro(){this.motor = new Motor(this);}

    void acelerar(){ motor.fatorDeInjecao += 0.5;}
    void frear(){ motor.fatorDeInjecao -= 0.5;}

}
