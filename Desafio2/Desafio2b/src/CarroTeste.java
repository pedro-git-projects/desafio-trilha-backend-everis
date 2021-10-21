public class CarroTeste {
    public static void main(String[] args) {
        Carro mustangBoss = new Carro();
        System.out.println(mustangBoss.motor.getRpm());

        mustangBoss.acelerar();

        System.out.println(mustangBoss.motor.getRpm());

        System.out.println("Podemos ver aque ao usuário com um carro particular, não importa como foi implementado o fator de injecção");
        System.out.print("Logo dizemos que o fator de injeção é um dado abstraído");
    }
}
