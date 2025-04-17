package atividadeSlides.Objetos.carro;

import atividadeSlides.Objetos.moto.Motor;

public class Carro {
    private String cor;
    private String modelo;
    public double velocidadeAtual;
    public double velocidadeMaxima;
    private static int qtde;
    private int tanque;
    private double precoCusto;

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public int getTanque() {
        return tanque;
    }

    public void setTanque(int tanque) {
        this.tanque = tanque;
    }

    public Carro() {
        this.qtde++;
    }

    public static int getQtde() {
        return qtde;
    }


    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    private String chassi;
    private Motor motor;

    public Carro(String cor,String modelo, String chassi) {
        this.cor = cor;
        this.modelo = modelo;
        this.chassi = chassi;

    }


    public String getCor()
    {
        return cor;
    }
    public void setCor(String cor)
    {
        this.cor = cor;
    }
    public String getModelo()
    {
        return modelo;
    }
    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }


    public void liga() {
        System.out.println("Carro ligado!");
    }

    public void acelera(double quantidade) {
        double velocidadeNova = this.velocidadeAtual + quantidade;
        if (velocidadeNova > this.velocidadeMaxima) {
            System.out.println("Atribuída a velocidade máxima.");
            this.velocidadeAtual = this.velocidadeMaxima;
        } else {
            this.velocidadeAtual = velocidadeNova;
        }
    }


    public int retornaMarchaAtual() {
        if (this.velocidadeAtual < 0) {
            return -1;
        }
        if (this.velocidadeAtual >= 0 && this.velocidadeAtual < 40) {
            return 1;
        }
        if (this.velocidadeAtual >= 40 && this.velocidadeAtual < 80) {
            return 2;
        }
        return 3;
    }

    public double getPrecoVenda(){
        return precoCusto * 1.3;
    }

}
