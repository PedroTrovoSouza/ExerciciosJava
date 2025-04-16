package Lista3;

public class Gato extends AnimalTerrestreAB{
    @Override
    public void comer() {
        qtdComidaIngerida += 20;
    }

    @Override
    public void moverse() {
        qtdCaminhoPercorrido += 2;
    }

    @Override
    public void dormir() {
        qtdHorasDormidas += 4;
    }

    @Override
    public void nome() {
        nome = "Penelope";
    }

    @Override
    public void idadeAnimal() {
        idade = 10;
    }

    @Override
    public void habitat() {
        habitat = "Apartamento";
    }

    @Override
    public void altura() {
        altura = 0.90;
    }

    @Override
    public void peso() {
        peso = 1.20;
    }
}
