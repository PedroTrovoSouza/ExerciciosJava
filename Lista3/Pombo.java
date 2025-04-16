package Lista3;

public class Pombo extends AnimalVoadorAB{

    @Override
    public void comer() {
        qtdComidaIngerida += 10;
    }

    @Override
    public void moverse() {
        qtdCaminhoPercorrido += 5;
    }

    @Override
    public void dormir() {
        qtdHorasDormidas += 9;
    }

    @Override
    public void nome() {
        nome = "PruPru";
    }

    @Override
    public void idadeAnimal() {
        idade = 8;
    }

    @Override
    public void habitat() {
        habitat = "Prédios";
    }

    @Override
    public void altura() {
        altura = 1.0;
    }

    @Override
    public void peso() {
        peso = 0.10;
    }


}
