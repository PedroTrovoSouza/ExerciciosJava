public class Vendedor extends Empregado {
    private double valorVendas;
    private double comissao;

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public double calcularSalario(double salarioBase, double imposto) {
        double salarioVendedor = salarioBase + (valorVendas * getComissao());

        return (salarioBase * imposto) - salarioVendedor;
    }
}
