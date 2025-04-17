public class AppTesteFornecedor {
    public static void main(String[] args) {
        Fornecedor fornecedor = new Fornecedor();

        fornecedor.setValorCredito(500);
        fornecedor.setValorDivida(500);


        System.out.println( fornecedor.obterSaldo(fornecedor.getValorCredito(), fornecedor.getValorDivida()));
    }
}
