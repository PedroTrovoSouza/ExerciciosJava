package Lista3;

public class Cachorro extends AnimalAB{
    @Override
    public void nome() {
        nome = "Rex";
    }

    @Override
    public void idadeAnimal() {
        idade = 2;
    }

    @Override
    public void habitat() {
        habitat = "Apartamento";
    }

    @Override
    public void altura() {
        altura = 1.10;
    }

    @Override
    public void peso() {
        peso = 10;
    }

    @Override
    public void comer() {
        qtdComidaIngerida += 50.0;
    }

    @Override
    public void moverse() {
        qtdCaminhoPercorrido += 5;
    }

    @Override
    public void dormir() {
        qtdHorasDormidas += 5;
    }
}
