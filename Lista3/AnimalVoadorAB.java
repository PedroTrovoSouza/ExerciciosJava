package Lista3;

public abstract class AnimalVoadorAB extends AnimalAB {
    protected int qtdAssas = 0;
    protected double envergadura;
    protected int qtdPatas;

    public void setQtdAssas(int qtdAssas) {
        this.qtdAssas = qtdAssas;
    }

    public void setEnvergadura(double envergadura) {
        this.envergadura = envergadura;
    }

    public void setQtdPatas(int qtdPatas) {
        this.qtdPatas = qtdPatas;
    }

    @Override
    public void setQtdComidaIngerida(double qtdComidaIngerida) {
        super.setQtdComidaIngerida(qtdComidaIngerida);
    }

    @Override
    public void setQtdCaminhoPercorrido(double qtdCaminhoPercorrido) {
        super.setQtdCaminhoPercorrido(qtdCaminhoPercorrido);
    }

    @Override
    public void setQtdHorasDormidas(double qtdHorasDormidas) {
        super.setQtdHorasDormidas(qtdHorasDormidas);
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    @Override
    public void setIdade(int idade) {
        super.setIdade(idade);
    }

    @Override
    public void setHabitat(String habitat) {
        super.setHabitat(habitat);
    }

    @Override
    public void setAltura(double altura) {
        super.setAltura(altura);
    }

    @Override
    public void setPeso(double peso) {
        super.setPeso(peso);
    }
}
