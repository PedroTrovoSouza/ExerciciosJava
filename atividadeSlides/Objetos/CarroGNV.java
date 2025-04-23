package atividadeSlides.Objetos;

import atividadeSlides.Objetos.carro.Carro;

public class CarroGNV extends Carro {
    int qtdeCilindros;
    String autorizacaoINMETRO;

    @Override
    public double getPrecoVenda() {
        return getPrecoCusto() * 1.4;
    }
}
