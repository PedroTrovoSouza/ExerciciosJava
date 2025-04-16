package Lista3;

public class Elefante extends AnimalTerrestreAB{

    @Override
    public void comer() {
        qtdComidaIngerida += 10;
    }

    @Override
    public void moverse() {
        qtdCaminhoPercorrido += 50;
    }

    @Override
    public void dormir() {
        qtdHorasDormidas += 10;
    }

    @Override
    public void nome() {
        nome = "Elefante";
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
        altura = 3.5;
    }

    @Override
    public void peso() {
        peso = 750.50;
    }

}
