package Lista3;

public class Leao extends AnimalTerrestreAB{
    @Override
    public void comer() {
        qtdComidaIngerida += 40;
    }

    @Override
    public void moverse() {
        qtdCaminhoPercorrido += 30;
    }

    @Override
    public void dormir() {
        qtdHorasDormidas += 10;
    }

    @Override
    public void nome() {
        nome = "Leão";
    }

    @Override
    public void idadeAnimal() {
        idade = 10;
    }

    @Override
    public void habitat() {
        habitat = "Savana";
    }

    @Override
    public void altura() {
        altura = 1.70;
    }

    @Override
    public void peso() {
        peso = 350;
    }
}
