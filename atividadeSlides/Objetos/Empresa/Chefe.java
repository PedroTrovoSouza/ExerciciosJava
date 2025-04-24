package atividadeSlides.Objetos.Empresa;

public class Chefe extends Trabalhador{

   public Chefe(String nome, String sobrenome, double salarioBase) {
        super(nome, sobrenome);
        this.salarioBase = salarioBase;
    }

    @Override
    public double gerarSalario() {
        return 0;
    }
}
