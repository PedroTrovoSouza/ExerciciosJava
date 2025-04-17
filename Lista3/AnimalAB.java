package Lista3;

public abstract class AnimalAB implements AnimalIF {

    protected double qtdComidaIngerida = 0;
    protected double qtdCaminhoPercorrido = 0;
    protected double qtdHorasDormidas = 0;
    protected String nome = "";
    protected int idade = 0;
    protected String habitat = "";
    protected double altura = 0.0;
    protected double peso = 0.0;

    public void setQtdComidaIngerida(double qtdComidaIngerida) {
        this.qtdComidaIngerida = qtdComidaIngerida;
    }

    public void setQtdCaminhoPercorrido(double qtdCaminhoPercorrido) {
        this.qtdCaminhoPercorrido = qtdCaminhoPercorrido;
    }

    public void setQtdHorasDormidas(double qtdHorasDormidas) {
        this.qtdHorasDormidas = qtdHorasDormidas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
