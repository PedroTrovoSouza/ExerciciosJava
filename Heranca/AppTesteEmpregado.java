package Heranca;

public class AppTesteEmpregado {
    public static void main(String[] args) {
        Empregado empregado = new Empregado();

        empregado.setCodigoSetor(112992);
        empregado.setImposto(10);
        empregado.setSalarioBase(5000);

        System.out.println(empregado.calcularSalario(empregado.getSalarioBase(), empregado.getImposto()));
    }

}
