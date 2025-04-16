package atividadeSlides.Objetos.Empresa;

public abstract class Trabalhador {
    private String nome;
    private String sobrenome;
    double salarioBase;

    public Trabalhador(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public abstract double gerarSalario();
    //Demais métodos da classe Trabalhador
}

