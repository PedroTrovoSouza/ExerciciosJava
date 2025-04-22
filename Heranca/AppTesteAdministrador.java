package Heranca;

public class AppTesteAdministrador {
    public static void main(String[] args) {
        Administrador administrador = new Administrador();

        administrador.setCodigoSetor(112992);
        administrador.setImposto(10);
        administrador.setSalarioBase(5000);
        administrador.setAjudaDeCusto(1000);

        System.out.println(administrador.calcularSalario(administrador.getSalarioBase(), administrador.getImposto()));
    }

}
