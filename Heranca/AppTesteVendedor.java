public class AppTesteVendedor {
    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor();

        vendedor.setCodigoSetor(112992);
        vendedor.setImposto(10);
        vendedor.setSalarioBase(5000);
        vendedor.setComissao(0.30);
        vendedor.setValorVendas(1000);

        System.out.println(vendedor.calcularSalario(vendedor.getSalarioBase(), vendedor.getImposto()));

    }
}
