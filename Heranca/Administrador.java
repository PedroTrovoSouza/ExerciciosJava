package Heranca;

public class Administrador extends Empregado{
    private double ajudaDeCusto;

    public double getAjudaDeCusto() {
        return ajudaDeCusto;
    }

    public void setAjudaDeCusto(double ajudaDeCusto) {
        this.ajudaDeCusto = ajudaDeCusto;
    }

    @Override
    public double calcularSalario(double salarioBase, double imposto) {
        double salario = salarioBase + getAjudaDeCusto();
        return (salarioBase * imposto) - salario;
    }
}
