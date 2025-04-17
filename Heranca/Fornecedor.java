public class Fornecedor extends Pessoa {
    private double valorCredito;
    private double valorDivida;

    public double getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(double valorDivida) {
        this.valorDivida += valorDivida;
    }

    public double getValorCredito() {
        return valorCredito;
    }

    public double setValorCredito(double valorCredito) {
        this.valorCredito += valorCredito;
        return valorCredito;
    }

    public double obterSaldo(double valorCredito, double valorDivida){
        return valorDivida - valorCredito;
    }


}
