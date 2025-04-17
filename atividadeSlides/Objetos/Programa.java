package atividadeSlides.Objetos;

import atividadeSlides.Objetos.carro.Carro;

public class Programa {
    public static void main(String[] args) {

        Carro[] carros = new Carro[3];
        carros[0] = new Carro();
        carros[0].setPrecoCusto(100);
        carros[1] = new CarroGNV();
        carros[1].setPrecoCusto(100);
        carros[2] = new Carro();
        carros[2].setPrecoCusto(100);

        for (int i = 0; i < carros.length; i++) {
            System.out.println("Valor de venda do carro " + i + " -> " + carros[i].getPrecoVenda());
        }
    }
}
