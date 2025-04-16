package Lista3;

public class Peixe extends AnimalMarinhoAB{

    @Override
    public void comer() {
        qtdComidaIngerida += 20;
    }

    @Override
    public void moverse() {
        qtdCaminhoPercorrido += 10;
    }

    @Override
    public void dormir() {
        qtdHorasDormidas += 6;
    }

    @Override
    public void nome() {
        nome = "Nemo";
    }

    @Override
    public void idadeAnimal() {
        idade = 2;
    }

    @Override
    public void habitat() {
        habitat = "Mar";
    }

    @Override
    public void altura() {
        altura = 0.90;
    }

    @Override
    public void peso() {
        peso = 1;
    }
}
