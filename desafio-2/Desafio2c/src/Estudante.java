public class Estudante {
    private String nome;
    private int idade;

    // Métodos para encapsulamento
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        if(idade >= 0) {
          this.idade = idade;
        } else {
            System.out.println("Insira uma idade válida!");
        }
    }

    public String getNome() {
        return nome;
    }

    public int getIdade(){
        return idade;
    }
}
